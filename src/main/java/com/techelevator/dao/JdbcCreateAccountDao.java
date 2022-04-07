package com.techelevator.dao;

import com.techelevator.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class JdbcCreateAccountDao implements CreateAccountDao {


    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public JdbcCreateAccountDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    public JdbcCreateAccountDao(){

    }

    @Override
    public long createAccount(Account account) {

        long newId = jdbcTemplate.queryForObject(
                "INSERT INTO user_profile(first_name,last_name,email,photo,goal,user_id) VALUES (?, ?, ?, ?,?,?) RETURNING id", Long.class,
                account.getFirstName(), account.getLastName(), account.getEmail(),
                account.getPhoto(), account.getGoal(), account.getUserId());

        return newId;
    }

    public long checkAccountExists(long userId) {
        String sql = "SELECT user_id FROM user_profile WHERE user_id = ?;";
        long id = 0;
        try{
            id = jdbcTemplate.queryForObject(sql, Long.class, userId);
        }catch(Exception e){
            id = 0;
        }
        return id;
    }
}






