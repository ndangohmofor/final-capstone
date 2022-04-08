package com.techelevator.dao;

import com.techelevator.model.EquipmentLog;
import com.techelevator.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import sun.awt.EventQueueItem;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcEquipmentLogDao implements EquipmentLogDao {

    JdbcTemplate template;

    @Autowired
    public JdbcEquipmentLogDao(DataSource dataSource) {
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

    @Override
    public void addExerciseToLog(long duration, LocalDateTime date, long reps, long weight, long userId, long machineId) {
        String sql = "insert into equipment_log(duration, date, reps, weight, user_id, machine_id) values (?,?,?,?,?,?);";
        template.update(sql, duration, date, reps, weight, userId, machineId);
    }

    @Override
    public List<EquipmentLog> getUserLogsByName(String input) {
        List<EquipmentLog> log = new ArrayList<>();
        String logSql = "Select * from equipment_log " +
                "join machine on equipment_log.machine_id = machine.id " +
                "join user_profile on equipment_log.user_id = user_profile.user_id " +
                "Where last_name ilike ?";
        SqlRowSet results = template.queryForRowSet(logSql, "%"+input+"%");
        while (results.next()) {
            log.add(mapToRowEquipmentLog(results));
        }
        return log;
    }

    private EquipmentLog mapToRowEquipmentLog(SqlRowSet results) {
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
