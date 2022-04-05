package com.techelevator.controller;

import com.techelevator.authentication.AuthProvider;
import com.techelevator.dao.JdbcAccountDao;
import com.techelevator.dao.JdbcGymCheckinDao;
import com.techelevator.model.GymCheckin;
import com.techelevator.model.JdbcUserDao;
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
import java.time.LocalDateTime;

@Controller
public class CheckinController {

    @Autowired
    private JdbcGymCheckinDao jdbcGymCheckinDao;
    @Autowired
    private JdbcUserDao jdbcUserDao;
    @Autowired
    private AuthProvider auth;

    @RequestMapping(path="/checkin", method= RequestMethod.GET)
    public String displayCheckinPage(){
        return "checkin";
    }

    @RequestMapping(path="/checkin", method= RequestMethod.POST)
    public String createCheckin(ModelMap checkinModel, HttpSession session){

        //HOW TO ENSURE THAT A USER THAT HAS AN OPEN CHECKIN CANNOT CHECK IN AGAIN
        User user = (User) session.getAttribute("user");

        GymCheckin gymCheckin = new GymCheckin(LocalDateTime.now(), user.getId() , true);
        gymCheckin.setId(jdbcGymCheckinDao.checkIn(gymCheckin));

        checkinModel.put("checkin", gymCheckin);

        return  "/checkout";
    }

    @RequestMapping(value = "/checkout",method = RequestMethod.GET)
    public String displayCheckoutPage(){
        return "checkout";
    }

    @RequestMapping(value = "/checkout", method = RequestMethod.POST)
    public String checkOut(ModelMap checkoutModel, HttpSession session, @RequestParam long checkinID){
        User user = (User) session.getAttribute("user");

        jdbcGymCheckinDao.checkOut(checkinID);
        return "/private";
    }

    @RequestMapping(value = "/checkinOutAdmin",method = RequestMethod.GET)
    public String displayCheckinAdmin(){
        return "checkinOutAdmin";
    }
    @RequestMapping(value = "/checkinOutAdmin",method = RequestMethod.POST)
    public String checkinOutAdmin(@RequestParam String username, @RequestParam String checktype, @RequestParam LocalDateTime checkin, @RequestParam LocalDateTime checkout, ModelMap modelMap){

        GymCheckin gymCheckin = new GymCheckin();
        if(checktype.equals("checkin")){
            gymCheckin = new GymCheckin(LocalDateTime.now(), jdbcUserDao.getUserID(username), true);
            gymCheckin.setId(jdbcGymCheckinDao.checkIn(gymCheckin));
        } else if (checktype.equals("checkout")){
            jdbcGymCheckinDao.checkOut(gymCheckin.getId());
        }

        return "checkinOutAdmin";
    }
}
