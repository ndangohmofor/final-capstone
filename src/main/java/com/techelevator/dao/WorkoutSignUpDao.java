package com.techelevator.dao;

import com.techelevator.model.User;

import java.util.List;

public interface WorkoutSignUpDao {

    void signUpForWorkout(long userId, long workoutId);
    void cancelMyWorkoutReservation(Long userId, Long workoutId);
    List<User> searchWorkoutUsers(Long Id);
}
