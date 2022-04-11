package com.techelevator.dao;

import com.techelevator.model.EquipmentLog;
import com.techelevator.model.WorkoutMetrics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcWorkoutMetricsDao implements WorkoutMetricsDao {

    JdbcTemplate template;

    @Autowired
    public JdbcWorkoutMetricsDao(DataSource dataSource) {
        template = new JdbcTemplate(dataSource);
    }



    @Override
    public List<WorkoutMetrics> getWorkoutMetricsByUser(String userName) {

        List<WorkoutMetrics> log = new ArrayList<WorkoutMetrics>();
        String logSql = "select  check_in, check_out, machine_name, weight, reps from equipment_log e " +
                "    join gym_checkin g on e.user_id = g.user_id " +
                "    join machine m on e.machine_id = m.id " +
                "    join app_user a on a.id = e.user_id where user_name=? " +
                "      and date between check_in and check_out";
        SqlRowSet results = template.queryForRowSet(logSql, userName);
        while (results.next()) {
            log.add(mapToRowWorkoutMetrics(results));
        }
        return log;
    }

    private WorkoutMetrics mapToRowWorkoutMetrics(SqlRowSet results) {
        WorkoutMetrics wm = new WorkoutMetrics();
        if(results.getTimestamp("check_in") != null)
            wm.setCheckIn(results.getTimestamp("check_in").toLocalDateTime());
        if(results.getTimestamp("check_out") != null)
        wm.setCheckOut(results.getTimestamp("check_out").toLocalDateTime());
        wm.setMachineName(results.getString("machine_name"));
        wm.setWeight(results.getInt("weight"));
        wm.setReps(results.getInt("reps"));
        return wm;
    }
}
