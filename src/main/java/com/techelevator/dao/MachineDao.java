package com.techelevator.dao;

import com.techelevator.model.Machine;

import java.util.List;

public interface MachineDao {
    List<Machine> getMachines();
    List<Machine> getMachinesByName(String machineName);
    List<Machine> getMachinesByType(String machineType);
    void updateMachineUsage();
    void addMachine(String machineName, String machineType, String machineReference);

}
