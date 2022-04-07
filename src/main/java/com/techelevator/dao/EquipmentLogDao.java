package com.techelevator.dao;

import com.techelevator.model.EquipmentLog;

import java.util.List;

public interface EquipmentLogDao {

    public List<EquipmentLog> getEquipmentLogByUser(long userId);
}
