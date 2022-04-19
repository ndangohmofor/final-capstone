package com.techelevator.dao;

import com.techelevator.model.User;
import com.techelevator.model.WorkoutClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    @Override
    public List<User> searchWorkoutUsers(Long Id) {
        List<User> users = new ArrayList<>();
        String sql = "SELECT au.* FROM app_user au JOIN workout_user wu ON au.id = wu.user_id AND wu.workout_id = ?;";
        users = jdbcTemplate.query(sql, new UserRowMapper(), Id);
        return users;
    }
}

class UserRowMapper implements RowMapper<User>{

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setUsername(resultSet.getString("user_name"));
        user.setRole(resultSet.getString("role"));
        return user;
    }
}