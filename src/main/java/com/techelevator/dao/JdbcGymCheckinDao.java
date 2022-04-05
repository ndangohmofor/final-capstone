package com.techelevator.dao;

import com.techelevator.model.GymCheckin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcGymCheckinDao implements GymCheckinDao {


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcGymCheckinDao(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Long checkIn(GymCheckin checkIn) {

        String sqlInsertCheckin = "INSERT INTO gym_checkin(check_in, is_checked_in, user_id) VALUES (?, ? , ?) returning id";
        Long id = jdbcTemplate.queryForObject(sqlInsertCheckin, Long.class, checkIn.getCheckIn(), checkIn.isCheckedIn() , checkIn.getUserId());

        return id;
    }

    public void checkOut(GymCheckin checkIn) {
        String sqlUpdateCheckOut = "UPDATE gym_checkin set check_out = ?, is_checked_in = ? where id = ?;";
        jdbcTemplate.update(sqlUpdateCheckOut, LocalDate.now(), false, checkIn.getId());
    }


    @Override
    public List<GymCheckin> getCheckInLogForUser (int userId) {
        List<GymCheckin> userCheckins = new ArrayList<>();
        String sqlSelectAllUserCheckins = "SELECT * FROM gym_checkin where user_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sqlSelectAllUserCheckins, userId);
        while (result.next()){
            userCheckins.add(mapRowToGymCheckin(result));
        }
        return userCheckins;
    }

    public List<GymCheckin> getAllUserCheckInLog() {
        List<GymCheckin> allCheckins = new ArrayList<>();
        String sqlSelectAllCheckins = "SELECT * FROM gym_checkin";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sqlSelectAllCheckins);
        while (result.next()){
            allCheckins.add(mapRowToGymCheckin(result));
        }
        return allCheckins;
    }

    private GymCheckin mapRowToGymCheckin(SqlRowSet result){
        GymCheckin checkInLog = new GymCheckin();
        checkInLog.setId(result.getLong("id"));
        checkInLog.setUserId(result.getLong("user_id"));
        checkInLog.setCheckIn(result.getDate("check_in").toLocalDate());
        checkInLog.setCheckIn(result.getDate("check_out").toLocalDate());
        checkInLog.setCheckedIn(result.getBoolean("is_checked_in"));
        return checkInLog;
    }

}
