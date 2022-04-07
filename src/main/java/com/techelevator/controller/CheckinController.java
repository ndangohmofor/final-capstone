package com.techelevator.controller;

import com.techelevator.authentication.AuthProvider;
//import com.techelevator.dao.JdbcAccountDao;
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
    public String displayCheckinPage(ModelMap model, HttpSession session, RedirectAttributes flash, ModelMap checkinLogModel){
        User user = (User) session.getAttribute("user");
        checkinLogModel.put("checkinLog",jdbcGymCheckinDao.getCheckInLogForUser(user.getId()));

        if((jdbcGymCheckinDao.getNumberOfCheckins(user.getId()) >= 1)) {
            flash.addFlashAttribute("message", "You have an open checkin. Please checkout before checking in again.");
            GymCheckin gymCheckin = jdbcGymCheckinDao.getCheckinObject(user.getId());
            model.put("checkin", gymCheckin);
            return "checkout";
        }
        return "checkin";
    }

    @RequestMapping(path="/checkin", method= RequestMethod.POST)
    public String createCheckin(ModelMap checkin, HttpSession session, RedirectAttributes flash ){

        //HOW TO ENSURE THAT A USER THAT HAS AN OPEN CHECKIN CANNOT CHECK IN AGAIN
        User user = (User) session.getAttribute("user");

        if((jdbcGymCheckinDao.getNumberOfCheckins(user.getId()) >= 1)){
            flash.addFlashAttribute("message", "You have an open checkin. Please checkout before checking in again.");
        } else {
            GymCheckin gymCheckin = new GymCheckin(LocalDateTime.now(), user.getId(), true);
            gymCheckin.setId(jdbcGymCheckinDao.checkIn(gymCheckin));
            checkin.put("checkin", gymCheckin);
        }

        flash.addAttribute("message","Checkin was successful! Don't forget to checkout once you are finished with your workout.");
        return "checkout";
        //get help because redirect is not allowing the checkout to occur...
        // server cannot or will not process the request due to something that is perceived to be a client error
    }

    @RequestMapping(value = "/checkout",method = RequestMethod.GET)
    public String displayCheckoutPage(){
        return "checkout";
    }

    @RequestMapping(value = "/checkout", method = RequestMethod.POST)
    public String checkOut(ModelMap checkoutModel, HttpSession session, @RequestParam long checkinID,RedirectAttributes flash){
        User user = (User) session.getAttribute("user");

        if((jdbcGymCheckinDao.getNumberOfCheckins(user.getId()) < 1)){
            flash.addFlashAttribute("message", "You do not have an open checkin.");
        } else {
            jdbcGymCheckinDao.checkOut(checkinID);
            flash.addFlashAttribute("message", "Checkout was successful!");
        }

        return "redirect:/checkin";
    }

    @RequestMapping(value = "/checkinOutAdmin",method = RequestMethod.GET)
    public String displayCheckinAdmin(ModelMap modelMap, ModelMap checkinMapper){
        modelMap.put("users",jdbcUserDao.getAllUsers());
        checkinMapper.put("checkins",jdbcGymCheckinDao.getCheckedInUsers());
        return "checkinOutAdmin";
    }
    @RequestMapping(value = "/checkinOutAdmin",method = RequestMethod.POST)
    public String checkinOutAdmin(@RequestParam String username, @RequestParam String checktype,RedirectAttributes flash){


        GymCheckin gymCheckin;
        if((checktype.equals("checkin")) && (jdbcGymCheckinDao.getNumberOfCheckins(jdbcUserDao.getUserID(username)) < 1)){
            gymCheckin = new GymCheckin(LocalDateTime.now(), jdbcUserDao.getUserID(username), true);
            gymCheckin.setId(jdbcGymCheckinDao.checkIn(gymCheckin));
            flash.addFlashAttribute("message","Checkin was successful!");
        } else if ((checktype.equals("checkin")) && (jdbcGymCheckinDao.getNumberOfCheckins(jdbcUserDao.getUserID(username)) >= 1)){
            flash.addFlashAttribute("message", "User already has an open checkin. Please checkout before checking the user in again.");
        } else if ((checktype.equals("checkout"))&& (jdbcGymCheckinDao.getNumberOfCheckins(jdbcUserDao.getUserID(username)) == 1) ){
            long checkinId = jdbcGymCheckinDao.getCheckinId(jdbcUserDao.getUserID(username));
            jdbcGymCheckinDao.checkOut(checkinId);
            flash.addFlashAttribute("message","Checkout was successful!");
        } else {
            flash.addFlashAttribute("message", "User does not have an open checkin.");
        }

        return "redirect:/checkinOutAdmin";

    }
}
