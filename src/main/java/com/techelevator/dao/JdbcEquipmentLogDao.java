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
import java.time.format.DateTimeFormatter;
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
                "WHERE user_id = ? ORDER BY date DESC;";
        SqlRowSet results = template.queryForRowSet(logSql, userId);
        while (results.next()) {
            log.add(mapToRowEquipmentLog(results));
        }
        return log;
    }

    public List<EquipmentLog> getEquipmentLogByUserName(String userName) {
        List<EquipmentLog> log = new ArrayList<EquipmentLog>();
        String logSql = "select * from equipment_log e join machine m on e.machine_id = m.id join app_user u on e.user_id=u.id and u.user_name= ?";
        SqlRowSet results = template.queryForRowSet(logSql, userName);
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
                "join app_user on equipment_log.user_id = app_user.id " +
                "Where user_name = ? order by date DESC ";
        SqlRowSet results = template.queryForRowSet(logSql,input);
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
