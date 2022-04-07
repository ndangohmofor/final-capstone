package com.techelevator.controller;

import com.techelevator.authentication.AuthProvider;
import com.techelevator.dao.WorkoutClassDao;
import com.techelevator.model.WorkoutClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class WorkoutClassController {

    @Autowired
    private WorkoutClassDao workoutClassDao;

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
    public String workoutSignUpProcess(@RequestParam int workoutId, ModelMap modelHolder, RedirectAttributes flash){
        if(auth.getCurrentUser() == null){
            flash.addFlashAttribute("message", "Please login to continue");
            return "redirect:/login";
        } else {

        }
        return "redirect:/signUpConfirmation";
    }
}
