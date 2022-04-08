package com.techelevator.dao;

import com.techelevator.model.EquipmentLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class JdbcWorkoutMetricsDao implements WorkoutMetricsDao {

    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

    @Autowired
    public JdbcWorkoutMetricsDao(DataSource dataSource) { this.jdbcTemplate = new JdbcTemplate(dataSource); }
    public JdbcWorkoutMetricsDao(){

    }


    @Override
    public EquipmentLog getWorkoutMetrics(EquipmentLog equipmentLog) {
        return null;
    }
}
