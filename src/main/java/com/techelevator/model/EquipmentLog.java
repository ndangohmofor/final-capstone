package com.techelevator.model;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class EquipmentLog {

  private long id;
  @NotNull (message = "Please provide duration of exercise")
  private Long duration;

  private LocalDateTime date;

  @NotNull (message = "Please provide number of reps")
  private Long reps;

  @NotNull (message = "Please add weight")
  private Long weight;

  private long userId;
  private long machineId;
  private String machineName;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public Long getDuration() {
    return duration;
  }

  public void setDuration(Long duration) {
    this.duration = duration;
  }


  public LocalDateTime getDate() {
    return date;
  }

  public void setDate(LocalDateTime date) {
    this.date = date;
  }


  public Long getReps() {
    return reps;
  }

  public void setReps(Long reps) {
    this.reps = reps;
  }


  public Long getWeight() {
    return weight;
  }

  public void setWeight(Long weight) {
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
  public String getCapitalizedMachineName() {
    return StringUtils.capitalize(machineName);
  }

  public void setMachineName(String machineName) {
    this.machineName = machineName;
  }
}
