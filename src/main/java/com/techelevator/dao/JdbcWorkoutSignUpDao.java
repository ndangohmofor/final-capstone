package com.techelevator.dao;

import com.techelevator.model.WorkoutClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcWorkoutSignUpDao implements WorkoutSignUpDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcWorkoutSignUpDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void signUpForWorkout(long userId, long workoutId) {
        String sql = "INSERT INTO workout_user (workout_id, user_id) VALUES (?, ?);";
        jdbcTemplate.update(sql, workoutId, userId);
    }

    @Override
    public void cancelMyWorkoutReservation(Long userId, Long workoutId) {
        String sql = "DELETE FROM workout_user WHERE user_id = ? AND workout_id = ?;";
        jdbcTemplate.update(sql, userId, workoutId);
    }
}
