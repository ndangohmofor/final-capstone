package com.techelevator.dao;

import com.techelevator.model.User;
import com.techelevator.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class JdbcEditProfileDao implements EditProfileDao {

    private JdbcTemplate template;

    @Autowired
    public JdbcEditProfileDao(DataSource dataSource) {this.template = new JdbcTemplate(dataSource);}

    @Override
    public void updateProfile (String firstName, String lastName, String goal, long id) {
    String sqlUserUpdate = "UPDATE user_profile SET first_name = ?, last_name= ?, goal = ? WHERE user_id = ?";
    template.update(sqlUserUpdate, firstName, lastName, goal, id);
    }

    @Override
    public UserProfile displayProfileByUserId (long userId) {
        UserProfile userProfile = new UserProfile();
        String sqlProfile = "SELECT * FROM user_profile WHERE user_id = ?;";
        SqlRowSet results = template.queryForRowSet(sqlProfile, userId );
        if(results.next()){
            userProfile = mapToRowUserProfile(results);
        }
        return userProfile;
        //need to find out where userId is coming from
    }

    private UserProfile mapToRowUserProfile (SqlRowSet results) {
        UserProfile userProfile = new UserProfile();
        userProfile.setId(results.getLong("id"));
        userProfile.setFirstName(results.getString("first_name"));
        userProfile.setLastName(results.getString("last_name"));
        userProfile.setEmail(results.getString("email"));
        userProfile.setPhoto(results.getString("photo"));
        userProfile.setGoal(results.getString("goal"));
        userProfile.setUserId(results.getLong("user_id"));
        return userProfile;
    }

}
