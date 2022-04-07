package com.techelevator.dao;

import com.techelevator.model.UserProfile;

public interface EditProfileDao {

    public void updateProfile (String firstName, String lastName, String goal, long id);

    public UserProfile displayProfileByUserId (long userId);

    public byte[] getProfileImage (long userId) ;
}
