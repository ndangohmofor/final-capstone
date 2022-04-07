package com.techelevator.dao;

import com.techelevator.model.EquipmentLog;

public interface EquipmentLogDao {

    public EquipmentLog getEquipmentLogByUser(long userId);
}
