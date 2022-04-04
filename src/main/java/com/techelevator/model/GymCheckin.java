package com.techelevator.model;


public class GymCheckin {

  private long id;
  private java.sql.Timestamp checkIn;
  private java.sql.Timestamp checkOut;
  private long userId;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public java.sql.Timestamp getCheckIn() {
    return checkIn;
  }

  public void setCheckIn(java.sql.Timestamp checkIn) {
    this.checkIn = checkIn;
  }


  public java.sql.Timestamp getCheckOut() {
    return checkOut;
  }

  public void setCheckOut(java.sql.Timestamp checkOut) {
    this.checkOut = checkOut;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

}
