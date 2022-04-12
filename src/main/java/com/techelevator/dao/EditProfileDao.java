package com.techelevator.dao;

import com.techelevator.model.UserProfile;

public interface EditProfileDao {

    public void updateProfile (String firstName, String lastName, String goal,String email, long id, byte[] photo);

    public UserProfile displayProfileByUserId (long userId);

    public byte[] getProfileImage (long userId) ;
}
