package com.techelevator.dao;

import com.techelevator.model.EquipmentLog;

import java.time.LocalDateTime;
import java.util.List;

public interface EquipmentLogDao {

    public List<EquipmentLog> getEquipmentLogByUser(long userId);

    public void addExerciseToLog (long duration, LocalDateTime date, long reps, long weight,long userId, long machineId);
}
