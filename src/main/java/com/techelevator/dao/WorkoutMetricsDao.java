package com.techelevator.dao;


import com.techelevator.model.WorkOutMetricsLog;


import java.util.List;

public interface WorkoutMetricsDao {

    public List<WorkOutMetricsLog> getWorkoutMetricsByUser(String userName);

    public List<WorkOutMetricsLog> getWorkoutMetricsByUser(Long userId);


}



