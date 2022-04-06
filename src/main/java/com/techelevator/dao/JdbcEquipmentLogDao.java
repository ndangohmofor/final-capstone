package com.techelevator.dao;

import com.techelevator.model.EquipmentLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class JdbcEquipmentLogDao implements EquipmentLogDao {

    JdbcTemplate template;

    @Autowired
    public JdbcEquipmentLogDao (DataSource dataSource) {
        template = new JdbcTemplate(dataSource);
    }

    @Override
    public EquipmentLog getEquipmentLogByUser(long userId) {
        EquipmentLog log = new EquipmentLog();
        String logsql = "SELECT machine_name, date, duration, reps, weight\n" +
                "FROM equipment_log\n" +
                "JOIN machine ON equipment_log.machine_id = machine.id\n" +
                "WHERE user_id = ?";
        SqlRowSet results = template.queryForRowSet(logsql, userId);
        if (results.next()) {
            log = mapToRowEquipmentLog(results);
        }
        return log;
    }

//    @Override
//    public EquipmentLog addToLog (EquipmentLog log) {
//
//    }

    private EquipmentLog mapToRowEquipmentLog (SqlRowSet results) {
        EquipmentLog el = new EquipmentLog();
        el.setDuration(results.getInt("duration"));
        el.setDate(results.getTimestamp("date").toLocalDateTime());
        el.setReps(results.getInt("reps"));
        el.setWeight(results.getInt("weight"));
        el.setUserId(results.getInt("user_id"));
        el.setMachineId(results.getInt("machine_id"));
        el.setMachineName(results.getString("machine_name"));
        return el;
    }

}
