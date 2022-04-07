package com.techelevator.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class JdbcWorkoutSignUpDao implements WorkoutSignUpDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcWorkoutSignUpDao(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void signUpForWorkout(long userId, long workoutId) {
        String sql = "INSERT INTO workout_user (workout_id, user_id) VALUES (?, ?);";
        jdbcTemplate.update(sql, userId, workoutId);
    }

    @Override
    public void cancelMyWorkoutReservation(long userId, long workoutId) {
        String sql = "DELETE FROM workout_user WHERE workout_id = ? AND user_id = ?;";
        jdbcTemplate.update(sql, userId, workoutId);
    }
}
