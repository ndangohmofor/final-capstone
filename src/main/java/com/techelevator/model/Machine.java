package com.techelevator.model;


public class Machine {

  private long id;
  private String machineName;
  private String machineType;
  private String machineReference;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getMachineName() {
    return machineName;
  }

  public void setMachineName(String machineName) {
    this.machineName = machineName;
  }


  public String getMachineType() {
    return machineType;
  }

  public void setMachineType(String machineType) {
    this.machineType = machineType;
  }


  public String getMachineReference() {
    return machineReference;
  }

  public void setMachineReference(String machineReference) {
    this.machineReference = machineReference;
  }

}
