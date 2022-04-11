package com.techelevator.model;

import org.springframework.util.StringUtils;

import java.time.LocalDateTime;

public class WorkoutMetrics {

    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private String machineName;
    private int weight;
    private int reps;

    public WorkoutMetrics(LocalDateTime checkIn, LocalDateTime checkOut, String machineName, int weight, int reps) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.machineName = machineName;
        this.weight = weight;
        this.reps = reps;
    }

    public WorkoutMetrics() {
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

    public String getMachineName() {
        return machineName;
    }

    public String getCapitalizedMachineName() { return StringUtils.capitalize(machineName); }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    @Override
    public String toString() {
        return "WorkoutMetrics{" +
                "checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", machineName='" + machineName + '\'' +
                ", weight=" + weight +
                ", reps=" + reps +
                '}';
    }
}
