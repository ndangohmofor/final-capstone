package com.techelevator.dao;

import com.techelevator.model.WorkoutClass;

import java.time.LocalDateTime;
import java.util.List;

public interface WorkoutClassDao {

    List<WorkoutClass> getAllWorkoutClasses();
    List<WorkoutClass> getWorkoutClassByName(String workoutClassName);
    List<WorkoutClass> getWorkoutClassByDate(LocalDateTime workoutClassDate);

    int createWorkoutClass(String name, LocalDateTime date, String instructor, String description, int duration);
    void cancelWorkoutClass(int id);

}
