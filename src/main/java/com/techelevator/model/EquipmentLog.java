package com.techelevator.model;


import java.time.LocalDate;
import java.time.LocalDateTime;

public class EquipmentLog {

  private long id;
  private long duration;
  private LocalDateTime date;
  private long reps;
  private long weight;
  private long userId;
  private long machineId;
  private String machineName;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getDuration() {
    return duration;
  }

  public void setDuration(long duration) {
    this.duration = duration;
  }


  public LocalDateTime getDate() {
    return date;
  }

  public void setDate(LocalDateTime date) {
    this.date = date;
  }


  public long getReps() {
    return reps;
  }

  public void setReps(long reps) {
    this.reps = reps;
  }


  public long getWeight() {
    return weight;
  }

  public void setWeight(long weight) {
    this.weight = weight;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public long getMachineId() {
    return machineId;
  }

  public void setMachineId(long machineId) {
    this.machineId = machineId;
  }

  public String getMachineName() {
    return machineName;
  }

  public void setMachineName(String machineName) {
    this.machineName = machineName;
  }

}
