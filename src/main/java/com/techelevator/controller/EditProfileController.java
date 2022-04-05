package com.techelevator.controller;

import com.techelevator.dao.EditProfileDao;
import com.techelevator.model.User;
import com.techelevator.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class EditProfileController {

    @Autowired
    EditProfileDao editProfileDao;

    @RequestMapping (path = "/updateProfile", method = RequestMethod.GET)
    public String displayUpdateForm() {
        return "updateProfile";
    }

    @RequestMapping (path = "/updateProfile", method = RequestMethod.POST)
    public String submitUpdateProfile(@RequestParam String firstName, @RequestParam String lastName,
                                      @RequestParam String goal, HttpSession session) {
        User user = (User) session.getAttribute("user");
        editProfileDao.updateProfile(firstName,lastName,goal, user.getId());

        return "redirect:/updateConfirmation";
        //need to add workout profile
    }

    @RequestMapping ("/updateConfirmation")
    public String displayUpdateConfirmation () {
        return "updateConfirmation";
    }

    @RequestMapping (path = "/profile", method = RequestMethod.GET)
    public String viewProfile (ModelMap modelMap, HttpSession session) {
        User user = (User) session.getAttribute("user");
        UserProfile userProfile = editProfileDao.displayProfileByUserId(user.getId());
        modelMap.put("profile", userProfile);
        return "displayProfile";
    }

}
