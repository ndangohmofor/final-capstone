package com.techelevator.model;


import java.time.LocalDate;
import java.time.LocalDateTime;

public class GymCheckin {

  private long id;
  private LocalDateTime checkIn;
  private LocalDateTime checkOut;
  private long userId;
  private boolean isCheckedIn;

  public GymCheckin(LocalDateTime checkIn,long userId, boolean isCheckedIn) {
    this.checkIn = checkIn;
    this.userId = userId;
    this.isCheckedIn = isCheckedIn;
  }

  public GymCheckin(LocalDateTime checkIn, LocalDateTime checkOut, long userId, boolean isCheckedIn) {
    this.checkIn = checkIn;
    this.checkOut = checkOut;
    this.userId = userId;
    this.isCheckedIn = isCheckedIn;
  }

  public GymCheckin(){
  }

  public boolean isCheckedIn() {
    return isCheckedIn;
  }

  public void setCheckedIn(boolean checkedIn) {
    isCheckedIn = checkedIn;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public LocalDateTime getCheckIn() {
    return checkIn;
  }

  public void setCheckIn(LocalDateTime checkIn) {
    this.checkIn = checkIn;
  }


  public LocalDateTime getCheckOut() {
    return checkOut;
  }

  public void setCheckOut(LocalDateTime checkOut) {
    this.checkOut = checkOut;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

}
