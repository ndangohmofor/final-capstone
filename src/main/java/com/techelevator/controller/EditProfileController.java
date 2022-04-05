package com.techelevator.controller;

import com.techelevator.dao.EditProfileDao;
import com.techelevator.model.UserProfile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EditProfileController {

    EditProfileDao editProfileDao;

    @RequestMapping (path = "/updateProfile", method = RequestMethod.GET)
    public String displayUpdateForm() {
        return "updateProfile";
    }

    @RequestMapping (path = "/updateProfile", method = RequestMethod.POST)
    public String submitUpdateProfile(@RequestParam String firstName, @RequestParam String lastName,
                                      @RequestParam String goal, @RequestParam long userId) {
        UserProfile userProfile = new UserProfile();
        userProfile.setUserId(userId);
        userProfile.setFirstName(firstName);
        userProfile.setLastName(lastName);
        userProfile.setGoal(goal);
        editProfileDao.updateProfile(firstName,lastName,goal,userId);

        return "redirect:/updateConfirmation";
    }

}
