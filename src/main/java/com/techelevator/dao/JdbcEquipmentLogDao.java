package com.techelevator.dao;

import com.techelevator.model.EquipmentLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcEquipmentLogDao implements EquipmentLogDao {

    JdbcTemplate template;

    @Autowired
    public JdbcEquipmentLogDao (DataSource dataSource) {
        template = new JdbcTemplate(dataSource);
    }

    @Override
    public List<EquipmentLog> getEquipmentLogByUser(long userId) {
        List<EquipmentLog> log = new ArrayList<>();
        String logSql = "SELECT *\n" +
                "FROM equipment_log\n" +
                "JOIN machine on equipment_log.machine_id = machine.id\n" +
                "WHERE user_id = ?;";
        SqlRowSet results = template.queryForRowSet(logSql, userId);
        while (results.next()) {
            log.add(mapToRowEquipmentLog(results));
        }
        return log;
    }

//    @Override
//    public EquipmentLog addToLog (EquipmentLog log) {
//
//    }

    private EquipmentLog mapToRowEquipmentLog (SqlRowSet results) {
        EquipmentLog el = new EquipmentLog();
        el.setId(results.getLong("id"));
        el.setDuration(results.getLong("duration"));
        el.setDate(results.getTimestamp("date").toLocalDateTime());
        el.setReps(results.getLong("reps"));
        el.setWeight(results.getLong("weight"));
        el.setUserId(results.getLong("user_id"));
        el.setMachineId(results.getLong("machine_id"));
        el.setMachineName(results.getString("machine_name"));
        return el;
    }

}
