package com.techelevator.dao;

public interface WorkoutSignUpDao {

    void signUpForWorkout(long userId, long workoutId);
    void cancelMyWorkoutReservation(long userId, long workoutId);
}
