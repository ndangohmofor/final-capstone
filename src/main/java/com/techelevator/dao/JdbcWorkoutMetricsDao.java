package com.techelevator.dao;

import com.techelevator.model.EquipmentLog;
import com.techelevator.model.WorkOutMetricsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.*;

@Component
public class JdbcWorkoutMetricsDao implements WorkoutMetricsDao {

    JdbcTemplate template;

    @Autowired
    public JdbcWorkoutMetricsDao(DataSource dataSource) {
        template = new JdbcTemplate(dataSource);
    }


    @Override
    public List<WorkOutMetricsLog> getWorkoutMetricsByUser(String userName) {

        String sql = "select id from app_user where user_name = ?";
        long id =0;
        try {
            id = template.queryForObject(sql, Long.class, userName);
        }catch(Exception e){
            id = 0;
        }
        if(id != 0){
            return getWorkoutMetricsByUser(id);
        }else {
            return null;
        }
    }

    @Override
    public List<WorkOutMetricsLog> getWorkoutMetricsByUser(Long userId) {

        String sql = "SELECT CHECK_IN, CHECK_OUT, MACHINE_NAME, WEIGHT, REPS FROM (SELECT COUNT(GC.CHECK_IN || ' ' || GC.CHECK_OUT)," +
                "       GC.check_in," +
                "       GC.check_out," +
                "       M.MACHINE_NAME," +
                "       EL.DURATION," +
                "       EL.WEIGHT," +
                "       EL.REPS" +
                " FROM app_user AU" +
                "         JOIN equipment_log el on AU.id = el.user_id" +
                "         JOIN gym_checkin gc on el.user_id = gc.user_id and el.date between gc.check_in and gc.check_out" +
                "         JOIN machine m on el.machine_id = m.id" +
                " WHERE AU.id = ?" +
                " GROUP BY GC.check_in, GC.check_out, M.MACHINE_NAME, EL.DURATION, EL.REPS, EL.WEIGHT) AS RESULTS;";

        SqlRowSet results = template.queryForRowSet(sql, userId);
        List<WorkOutMetricsLog> wmMetrics = extractResults1(results);
        return wmMetrics;
    }

    private List<WorkOutMetricsLog> extractResults1(SqlRowSet results) {
        Map<String, WorkOutMetricsLog> equipmentsInSession = new LinkedHashMap<String, WorkOutMetricsLog>();
        List<WorkOutMetricsLog> wmMetrics = new ArrayList<WorkOutMetricsLog>();
        while (results.next()) {
             String key = ""+ results.getTimestamp("check_in").toLocalDateTime()+" " +results.getTimestamp("check_out").toLocalDateTime();
             if(equipmentsInSession.containsKey(key)){
                 WorkOutMetricsLog wmLog = equipmentsInSession.get(key);
                 EquipmentLog e = new EquipmentLog();
                 e.setMachineName(results.getString("machine_name"));
                 e.setWeight(results.getInt("weight"));
                 e.setReps(results.getInt("reps"));
                 wmLog.getEquipments().add(e);
             }else{
                 WorkOutMetricsLog wmLog = new WorkOutMetricsLog();
                 if(results.getTimestamp("check_in") != null)
                     wmLog.setWorkOutDate(results.getTimestamp("check_in").toLocalDateTime().toLocalDate());
                 if(results.getTimestamp("check_in")!=null)
                     wmLog.setGym_checkin(results.getTimestamp("check_in").toLocalDateTime());
                 if(results.getTimestamp("check_out")!=null)
                     wmLog.setGym_checkout(results.getTimestamp("check_out").toLocalDateTime());
                 EquipmentLog e = new EquipmentLog();
                  e.setMachineName(results.getString("machine_name"));
                 e.setWeight(results.getInt("weight"));
                 e.setReps(results.getInt("reps"));
                 wmLog.getEquipments().add(e);
                 equipmentsInSession.put(key, wmLog);
             }
        }
        for(Map.Entry<String, WorkOutMetricsLog> e : equipmentsInSession.entrySet()){
              wmMetrics.add(e.getValue());
            System.out.println(e.getValue());
        }
        return wmMetrics;
    }
}
