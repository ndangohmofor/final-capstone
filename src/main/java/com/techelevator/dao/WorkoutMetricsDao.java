package com.techelevator.dao;

import com.techelevator.model.EquipmentLog;
import com.techelevator.model.WorkoutMetrics;

import java.util.List;

public interface WorkoutMetricsDao {

    public List<WorkoutMetrics> getWorkoutMetricsByUser(String userName);



}
