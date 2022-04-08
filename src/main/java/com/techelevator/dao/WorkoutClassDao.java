package com.techelevator.dao;

import com.techelevator.model.WorkoutClass;

import java.time.LocalDateTime;
import java.util.List;

public interface WorkoutClassDao {

    List<WorkoutClass> getAllWorkoutClasses();
    List<WorkoutClass> getWorkoutClassByName(String workoutClassName);
    List<WorkoutClass> getWorkoutClassByDate(LocalDateTime workoutClassDate);
    WorkoutClass getWorkoutClassById(Long workoutId);
    void createWorkoutClass(WorkoutClass workoutClass);
    void cancelWorkoutClass(Long id);
    List<WorkoutClass> getFirst5Classes();

}
