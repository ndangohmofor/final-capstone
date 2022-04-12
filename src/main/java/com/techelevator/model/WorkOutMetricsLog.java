package com.techelevator.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkOutMetricsLog {

    private LocalDate workOutDate;
    private LocalDateTime gym_checkin;
    private LocalDateTime gym_checkout;
    private List<EquipmentLog> equipments;

    public WorkOutMetricsLog(){
          equipments = new ArrayList<EquipmentLog>();
    }

    public WorkOutMetricsLog(LocalDate workOutDate, LocalDateTime gym_checkin, LocalDateTime gym_checkout, List<EquipmentLog> equipments) {
        this.workOutDate = workOutDate;
        this.gym_checkin = gym_checkin;
        this.gym_checkout = gym_checkout;
        this.equipments = equipments;
    }

    public LocalDate getWorkOutDate() {
        return workOutDate;
    }

    public void setWorkOutDate(LocalDate workOutDate) {
        this.workOutDate = workOutDate;
    }

    public LocalDateTime getGym_checkin() {
        return gym_checkin;
    }

    public void setGym_checkin(LocalDateTime gym_checkin) {
        this.gym_checkin = gym_checkin;
    }

    public LocalDateTime getGym_checkout() {
        return gym_checkout;
    }

    public void setGym_checkout(LocalDateTime gym_checkout) {
        this.gym_checkout = gym_checkout;
    }

    public List<EquipmentLog> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<EquipmentLog> equipments) {
        this.equipments = equipments;
    }

    @Override
    public String toString() {
        return "WorkOutMetricsLog{" +
                "workOutDate=" + workOutDate +
                ", gym_checkin=" + gym_checkin +
                ", gym_checkout=" + gym_checkout +
                ", equipments=" + equipments +
                '}';
    }
}
