package com.techelevator.controller;

import com.techelevator.authentication.AuthProvider;
import com.techelevator.dao.JdbcGymCheckinDao;
import com.techelevator.model.GymCheckin;
import com.techelevator.model.User;
import org.bouncycastle.math.raw.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.time.LocalDate;

@Controller
public class CheckinController {

    @Autowired
    private JdbcGymCheckinDao jdbcGymCheckinDao;
    @Autowired
    private AuthProvider auth;

    @RequestMapping(path="/checkin", method= RequestMethod.GET)
    public String displayCheckinPage(){
        return "checkin";
    }

    @RequestMapping(path="/checkin", method= RequestMethod.POST)
    public String createCheckin(ModelMap checkinModel, HttpSession session){


        User user = (User) session.getAttribute("user");
        //flash.addFlashAttribute("user", user);
        //userModel.put("user", auth.getCurrentUser());
        GymCheckin gymCheckin = new GymCheckin(LocalDate.now(), user.getId() , true); //how to get user id?
        jdbcGymCheckinDao.checkIn(gymCheckin);
        gymCheckin.setId(jdbcGymCheckinDao.checkIn(gymCheckin));

        checkinModel.put("checkin", gymCheckin);

        return  "redirect:/checkout"; //i want to hide the checkin button or present the user from checking in again.
    }

    @RequestMapping(value = "/checkout",method = RequestMethod.GET)
    public String displayCheckoutPage(){
        return "checkout";
    }
}
