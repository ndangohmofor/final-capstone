package com.techelevator.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class JdbcEditProfileDao implements EditProfileDao {

    private JdbcTemplate template;

    @Autowired
    public JdbcEditProfileDao(DataSource dataSource) {this.template = new JdbcTemplate(dataSource);}

    @Override
    public void updateProfile (String firstName, String lastName, String goal, long id) {
    String sqlUserUpdate = "UPDATE user_profile SET first_name = ?, last_name= ?, goal = ? WHERE user_id = ?";
    template.update(sqlUserUpdate, firstName, lastName, goal, id);
    }


}
