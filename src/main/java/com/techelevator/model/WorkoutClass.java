package com.techelevator.model;


import java.time.LocalDateTime;

public class WorkoutClass {

  private long id;
  private String className;
  private LocalDateTime date;
  private String instructor;
  private String description;

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getDuration_minutes() {
    return duration_minutes;
  }

  public void setDuration_minutes(int duration_minutes) {
    this.duration_minutes = duration_minutes;
  }

  private int duration_minutes;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
  }


  public LocalDateTime getDate() {
    return date;
  }

  public void setDate(LocalDateTime date) {
    this.date = date;
  }


  public String getInstructor() {
    return instructor;
  }

  public void setInstructor(String instructor) {
    this.instructor = instructor;
  }

}
