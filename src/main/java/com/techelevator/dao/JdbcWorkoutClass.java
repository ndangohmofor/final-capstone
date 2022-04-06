package com.techelevator.dao;

import com.techelevator.model.WorkoutClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcWorkoutClass implements WorkoutClassDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcWorkoutClass(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<WorkoutClass> getAllWorkoutClasses() {
        String sql = "SELECT * FROM workout_class ORDER BY date ASC LIMIT 5;";
        List<WorkoutClass> workoutClasses = jdbcTemplate.query(sql, new WorkoutRowMapper());
        return workoutClasses;
    }

    @Override
    public List<WorkoutClass> getWorkoutClassByName(String workoutClassName) {
        String sql = "SELECT * FROM workout_class WHERE class_name ilike ?;";
        List<WorkoutClass> workoutClasses = jdbcTemplate.query(sql, new WorkoutRowMapper(), workoutClassName);
        return workoutClasses;
    }

    @Override
    public List<WorkoutClass> getWorkoutClassByDate(LocalDateTime workoutClassDate) {
        String sql = "SELECT * FROM workout_class WHERE date >= ?;";
        List<WorkoutClass> workoutClasses = jdbcTemplate.query(sql, new WorkoutRowMapper(), workoutClassDate);
        return workoutClasses;
    }

    @Override
    public int createWorkoutClass(String name, LocalDateTime date, String instructor, String description, int duration) {
        String sql = "INSERT INTO workout_class (class_name, date, instructor, description, duration_in_minutes) VALUES (?, ?, ?, ?, ?) RETURNING id;";
        return jdbcTemplate.update(sql, new WorkoutRowMapper(), name, date, instructor, description, duration);
    }

    @Override
    public void cancelWorkoutClass(int classId) {
        String sql = "DELETE FROM workout_class WHERE id = ?;";
        jdbcTemplate.update(sql, new WorkoutRowMapper(), classId);
    }
}

class WorkoutRowMapper implements RowMapper<WorkoutClass> {

    @Override
    public WorkoutClass mapRow(ResultSet resultSet, int i) throws SQLException {
        WorkoutClass workoutClass = new WorkoutClass();
        workoutClass.setId(resultSet.getLong("id"));
        workoutClass.setClassName(resultSet.getString("class_name"));
        workoutClass.setDate(resultSet.getTimestamp("date").toLocalDateTime());
        workoutClass.setInstructor(resultSet.getString("instructor"));
        workoutClass.setDescription(resultSet.getString("description"));
        workoutClass.setDuration_minutes(resultSet.getInt("duration_in_minutes"));
        return workoutClass;
    }
}