package com.techelevator.controller;

import com.techelevator.authentication.AuthProvider;
import com.techelevator.dao.WorkoutClassDao;
import com.techelevator.dao.WorkoutSignUpDao;
import com.techelevator.model.WorkoutClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class WorkoutClassController {

    @Autowired
    private WorkoutClassDao workoutClassDao;

    @Autowired
    private WorkoutSignUpDao workoutSignUpDao;

    @Autowired
    private AuthProvider auth;

    @RequestMapping(path = "/workoutDetails", method = RequestMethod.GET)
    public String displayWorkoutDetails(@RequestParam int workoutId, ModelMap modelHolder) {
        WorkoutClass workout = workoutClassDao.getWorkoutClassById(workoutId);
        modelHolder.put("workout", workout);
        return "workoutDetails";
    }

    @RequestMapping(path = "/workoutSignUp", method = RequestMethod.GET)
    public String workoutSignUp(@RequestParam int workoutId, ModelMap modelHolder){
        WorkoutClass workout = workoutClassDao.getWorkoutClassById(workoutId);
        modelHolder.put("workout", workout);
        return "workoutSignup";
    }

    @RequestMapping(path = "/signUpConfirmation")
    public String signUpConfirmation(ModelMap modelHolder){
        return "signUpConfirmation";
    }

    @RequestMapping(path = "/workoutSignUpProcess")
    public String workoutSignUpProcess(@RequestParam int workoutId, HttpSession session, RedirectAttributes flash){
        if(auth.getCurrentUser() == null){
            flash.addFlashAttribute("message", "Please login to sign up for workout sessions");
            session.setAttribute("previousRoute", "workoutSignUpProcess?workoutId="+workoutId);
            return "redirect:/login";
        } else {
            workoutSignUpDao.signUpForWorkout(auth.getCurrentUser().getId(), workoutId);
        }
        return "redirect:/signUpConfirmation";
    }
}
