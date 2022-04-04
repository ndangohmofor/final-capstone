package com.techelevator.model;


public class WorkoutClass {

  private long id;
  private String className;
  private java.sql.Timestamp date;
  private String instructor;


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


  public java.sql.Timestamp getDate() {
    return date;
  }

  public void setDate(java.sql.Timestamp date) {
    this.date = date;
  }


  public String getInstructor() {
    return instructor;
  }

  public void setInstructor(String instructor) {
    this.instructor = instructor;
  }

}
