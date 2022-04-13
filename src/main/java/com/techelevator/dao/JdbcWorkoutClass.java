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


    public List<WorkoutClass> getFirst5Classes() {
        String sql = "SELECT * FROM workout_class WHERE date >= now() ORDER BY date ASC LIMIT 5;";
        List<WorkoutClass> workoutClasses = jdbcTemplate.query(sql, new WorkoutRowMapper());
        return workoutClasses;
    }

    @Override
    public List<WorkoutClass> getAllWorkoutClasses() {
        String sql = "SELECT * FROM workout_class WHERE date >= now() ORDER BY date ASC;";
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
    public WorkoutClass getWorkoutClassById(Long workoutId) {
        String sql = "SELECT * FROM workout_class WHERE id = ?;";
        WorkoutClass workout = jdbcTemplate.queryForObject(sql, new WorkoutRowMapper(), workoutId);
        return workout;
    }

    @Override
    public void createWorkoutClass(WorkoutClass workoutClass) {
        String sql = "INSERT INTO workout_class (class_name, date, instructor, description, duration_in_minutes) VALUES (?, ?, ?, ?, ?);";
        /*Integer id = */jdbcTemplate.update(sql, workoutClass.getClassName(), workoutClass.getDate(), workoutClass.getInstructor(), workoutClass.getDescription(), workoutClass.getDurationMinutes());
        //return getWorkoutClassById(id);
    }

    @Override
    public void cancelWorkoutClass(Long classId) {
        String sql = "DELETE FROM workout_class WHERE id = ?;";
        jdbcTemplate.update(sql, classId);
    }

    @Override
    public List<WorkoutClass> myWorkoutClasses (Long userId){
        List<WorkoutClass> myWorkoutClasses = new ArrayList<>();
        String sql = "SELECT ID, CLASS_NAME, DATE, INSTRUCTOR, DESCRIPTION, DURATION_IN_MINUTES FROM workout_class wc JOIN workout_user wu on wc.id = wu.workout_id WHERE wu.user_id = ? ORDER BY DATE;";
        myWorkoutClasses = jdbcTemplate.query(sql, new WorkoutRowMapper(), userId);
        return myWorkoutClasses;
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
        workoutClass.setDurationMinutes(resultSet.getInt("duration_in_minutes"));
        return workoutClass;
    }
}