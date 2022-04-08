package com.techelevator.controller;

import com.techelevator.authentication.AuthProvider;
import com.techelevator.dao.WorkoutClassDao;
import com.techelevator.dao.WorkoutSignUpDao;
import com.techelevator.model.WorkoutClass;
import org.bouncycastle.math.raw.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class WorkoutClassController {

    @Autowired
    private WorkoutClassDao workoutClassDao;

    @Autowired
    private WorkoutSignUpDao workoutSignUpDao;

    @Autowired
    private AuthProvider auth;

    @RequestMapping(path = "/workoutDetails", method = RequestMethod.GET)
    public String displayWorkoutDetails(@RequestParam Long workoutId, ModelMap modelHolder) {
        WorkoutClass workout = workoutClassDao.getWorkoutClassById(workoutId);
        modelHolder.put("workout", workout);
        return "workoutDetails";
    }

    @RequestMapping(path = "/workoutSignUp", method = RequestMethod.GET)
    public String workoutSignUp(@RequestParam Long workoutId, ModelMap modelHolder){
        WorkoutClass workout = workoutClassDao.getWorkoutClassById(workoutId);
        modelHolder.put("workout", workout);
        return "workoutSignup";
    }

    @RequestMapping(path = "/signUpConfirmation")
    public String signUpConfirmation(ModelMap modelHolder){
        return "signUpConfirmation";
    }

    @RequestMapping(path = "/workoutSignUpProcess")
    public String workoutSignUpProcess(@RequestParam Long workoutId, HttpSession session, RedirectAttributes flash, ModelMap modelHolder){
        WorkoutClass workout = workoutClassDao.getWorkoutClassById(workoutId);
        if(auth.getCurrentUser() == null){
            flash.addFlashAttribute("message", "Please login to sign up for workout sessions");
            session.setAttribute("previousRoute", "workoutSignUpProcess?workoutId="+workoutId);
            return "redirect:/login";
        } else {
            workoutSignUpDao.signUpForWorkout(auth.getCurrentUser().getId(), workoutId);
        }
        modelHolder.put("workout", workout);
        modelHolder.put("user", auth.getCurrentUser());
        return "signUpConfirmation";
    }

    @RequestMapping(path = "/scheduleClassAdmin")
    public String scheduleWorkoutClass(ModelMap modelHolder){
        List<WorkoutClass> workoutClasses = workoutClassDao.getAllWorkoutClasses();
        modelHolder.put("workouts", workoutClasses);
        return "workoutClassScheduler";
    }

    @RequestMapping(path = "/addWorkoutClass", method = RequestMethod.GET)
    public String addWorkoutClass(ModelMap modelHolder){
        if(!modelHolder.containsAttribute("workout")){
            modelHolder.put("workout", new WorkoutClass());
        }
        return "addWorkoutClass";
    }

    @RequestMapping(path = "/addWorkoutClass", method = RequestMethod.POST)
    public String addWorkoutClassProcessor(@Valid @ModelAttribute WorkoutClass workoutClass, BindingResult result, RedirectAttributes flash){
        flash.addFlashAttribute("workout", workoutClass);
        workoutClassDao.createWorkoutClass(workoutClass);

        if(result.hasErrors()){
            flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "workout", result);
            flash.addFlashAttribute("workout", workoutClass);

            return "redirect:/addWorkoutClass";
        }

        flash.addFlashAttribute("message", "Classes successfully created");
        return "redirect:/scheduleClassAdmin";
    }

    @RequestMapping(path = "/workoutCancel")
    public String cancelWorkoutProcessor(@RequestParam Long workoutId, ModelMap modelHolder){
        modelHolder.put("workout", workoutClassDao.getWorkoutClassById(workoutId));
        return "workoutCancel";
    }

    @RequestMapping(path = "/workoutCancelProcess")
    public String cancelWorkoutClass(@RequestParam Long workoutId, ModelMap modelHolder, RedirectAttributes flash){
        WorkoutClass workoutClass = workoutClassDao.getWorkoutClassById(workoutId);
        flash.addFlashAttribute("message", "Successfully cancelled workout class " + workoutClass.getClassName());
        workoutClassDao.cancelWorkoutClass(workoutId);
        return "redirect:/scheduleClassAdmin";
    }
}
