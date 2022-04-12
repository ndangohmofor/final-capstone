package com.techelevator.dao;

import com.techelevator.model.GymCheckin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Time;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
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


    public void checkOut(long checkinID) {
        String sqlUpdateCheckOut = "UPDATE gym_checkin set check_out = ?, is_checked_in = ? where id = ?;";
        jdbcTemplate.update(sqlUpdateCheckOut, LocalDateTime.now(), false, checkinID);
    }


    @Override
    public List<LocalDate> getCheckInLogForUser (long userId) {
        List<LocalDate> userCheckins = new ArrayList<>();
        String sqlSelectAllUserCheckins = "SELECT cast(check_in as date) as visit_date from gym_checkin where user_id = ? limit 10";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sqlSelectAllUserCheckins, userId);
        while (result.next()){
            userCheckins.add(result.getDate("visit_date").toLocalDate());
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

    public long getCheckinId (long userID){

        String sqlSelectActiveCheckin = "SELECT id from gym_checkin where is_checked_in = true and user_id = ? limit 1";
        long checkinId = jdbcTemplate.queryForObject(sqlSelectActiveCheckin, Long.class, userID);
        return  checkinId;
    }

    public Period getTimeSinceJoined(Long userId){
        String sqlSelectTimeSinceJoined = "SELECT check_in FROM gym_checkin where user_id = ? order by check_in asc limit 1 ";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sqlSelectTimeSinceJoined, userId);
        Period period;
        if (result.next()){
           period = Period.between((result.getDate("check_in").toLocalDate()), LocalDate.now());
            return period;
        }
        return Period.ZERO;
    }

    public String[] getAvgCheckinTimes(Long userId){
        /*String sqlAvgSessionTime = "SELECT avg(check_out - check_in) as average_session from gym_checkin where user_id = ?";*/
        String sqlAvgSessionTime = "select concat(extract(hours from avg(check_out - check_in)), ':', extract(minutes from avg(check_out-check_in))) as average_session from gym_checkin where user_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sqlAvgSessionTime, userId);
        String sessionResult;
        int hours;
        int minutes;
        String[] time = new String[2];
        if(result.next()){
            sessionResult = result.getString("average_session");
            time = sessionResult.split(":");
            return time;
        }

        return null;
    }

    public GymCheckin getCheckinObject (long userID){
        GymCheckin gymCheckin = new GymCheckin();
        String sqlSelectAllCheckins = "SELECT * FROM gym_checkin where user_id = ? and is_checked_in = true";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sqlSelectAllCheckins, userID);
        while (result.next()){
            gymCheckin = mapRowToGymCheckin(result);
        }

        return gymCheckin;
    }

    public List<Long> getCheckedInUsers(){
        List<Long> checkedinUsers = new ArrayList<>();
        String sqlSelectAllCheckins = "SELECT user_id FROM gym_checkin where is_checked_in = true";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sqlSelectAllCheckins);
        while (result.next()){
            checkedinUsers.add(result.getLong("user_id"));
        }
        return checkedinUsers;
    }

    private GymCheckin mapRowToGymCheckin(SqlRowSet result){
        GymCheckin checkInLog = new GymCheckin();
        checkInLog.setId(result.getLong("id"));
        checkInLog.setUserId(result.getLong("user_id"));
        checkInLog.setCheckIn(result.getTimestamp("check_in").toLocalDateTime());
        if(result.getDate("check_out") == null) {
            checkInLog.setCheckOut(null);
        } else {
            checkInLog.setCheckOut(result.getTimestamp("check_out").toLocalDateTime());
        }
        checkInLog.setCheckedIn(result.getBoolean("is_checked_in"));
        return checkInLog;
    }

    public int getNumberOfCheckins(long userId){
        int numOfCheckins = 0;

        String sqlCountCheckins = "SELECT count(id) as id_count from gym_checkin where user_id = ? and is_checked_in = true";
        SqlRowSet result= jdbcTemplate.queryForRowSet(sqlCountCheckins, userId);
        if(result.next()){
            numOfCheckins = result.getInt("id_count");
        }
        return numOfCheckins;
    }
}
