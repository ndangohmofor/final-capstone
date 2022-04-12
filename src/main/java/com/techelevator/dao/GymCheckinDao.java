package com.techelevator.dao;

import com.techelevator.model.GymCheckin;

import java.time.LocalDate;
import java.util.List;

public interface GymCheckinDao {
    List<LocalDate> getCheckInLogForUser(long userId);
    List<GymCheckin> getAllUserCheckInLog();

}
