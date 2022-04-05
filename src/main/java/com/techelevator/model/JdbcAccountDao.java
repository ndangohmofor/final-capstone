package com.techelevator.model;

import com.techelevator.authentication.PasswordHasher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class JdbcAccountDao implements AccountDao {


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcAccountDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);

    }

    @Override
    public long createAccount(Account account) {
      System.out.println("account object in dao is "+account);

        long newId = jdbcTemplate.queryForObject(
                "INSERT INTO user_profile(first_name,last_name,email,photo,goal,user_id) VALUES (?, ?, ?, ?,?,?) RETURNING id", Long.class,
                account.getFirstName(), account.getLastName(), account.getEmail(),
                account.getPhoto(), account.getGoal(), account.getUserId());

        return newId;
    }
}
