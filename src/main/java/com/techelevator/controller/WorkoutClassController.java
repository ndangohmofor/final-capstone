package com.techelevator.controller;

import com.techelevator.authentication.AuthProvider;
import com.techelevator.dao.WorkoutClassDao;
import com.techelevator.dao.WorkoutSignUpDao;
import com.techelevator.model.User;
import com.techelevator.model.WorkoutClass;
import org.bouncycastle.math.raw.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
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

    private String[] admin = new String[]{"admin", "employee"};
    private String[] user = new String[]{"user"};

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
    public String workoutSignUp(@RequestParam Long workoutId, ModelMap modelHolder) {
        WorkoutClass workout = workoutClassDao.getWorkoutClassById(workoutId);
        modelHolder.put("workout", workout);
        return "workoutSignup";
    }

    @RequestMapping(path = "/signUpConfirmation")
    public String signUpConfirmation(ModelMap modelHolder) {
        return "signUpConfirmation";
    }

    @RequestMapping(path = "/workoutSignUpProcess")
    public String workoutSignUpProcess(@RequestParam Long workoutId, HttpSession session, RedirectAttributes flash, ModelMap modelHolder) {
        WorkoutClass workout = workoutClassDao.getWorkoutClassById(workoutId);
        if (auth.getCurrentUser() == null) {
            flash.addFlashAttribute("message", "Please login to sign up for workout sessions");
            session.setAttribute("previousRoute", "workoutSignUpProcess?workoutId=" + workoutId);
            return "redirect:/login";
        } else {
            try {
                workoutSignUpDao.signUpForWorkout(auth.getCurrentUser().getId(), workoutId);
            } catch (DuplicateKeyException e){
                flash.addFlashAttribute("message", "You are already signed up for this class");
                flash.addAttribute("workoutId", workoutId);
                return "redirect:/workoutSignUp";
            }
        }
        modelHolder.put("workout", workout);
        modelHolder.put("user", auth.getCurrentUser());
        return "signUpConfirmation";
    }

    @RequestMapping(path = "/scheduleClassAdmin")
    public String scheduleWorkoutClass(ModelMap modelHolder, RedirectAttributes flash) {
        List<WorkoutClass> workoutClasses = workoutClassDao.getAllWorkoutClasses();
        modelHolder.put("workouts", workoutClasses);
        if (auth.userHasRole(admin)) {
            return "workoutClassScheduler";
        }
        flash.addFlashAttribute("message", "Please login as an admin to proceed");
        return "redirect:/login";
    }

    @RequestMapping(path = "/addWorkoutClass", method = RequestMethod.GET)
    public String addWorkoutClass(ModelMap modelHolder, RedirectAttributes flash) {
        if (!modelHolder.containsAttribute("workout")) {
            modelHolder.put("workout", new WorkoutClass());
        }
        if (auth.userHasRole(admin)) {
            return "addWorkoutClass";
        }
        flash.addFlashAttribute("message", "Please login as an admin to proceed");
        return "redirect:/login";
    }

    @RequestMapping(path = "/addWorkoutClass", method = RequestMethod.POST)
    public String addWorkoutClassProcessor(@Valid @ModelAttribute WorkoutClass workoutClass, BindingResult result, RedirectAttributes flash) {
        flash.addFlashAttribute("workout", workoutClass);
        workoutClassDao.createWorkoutClass(workoutClass);

        if (result.hasErrors()) {
            flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "workout", result);
            flash.addFlashAttribute("workout", workoutClass);

            return "redirect:/addWorkoutClass";
        }

        flash.addFlashAttribute("message", "Classes successfully created");
        return "redirect:/scheduleClassAdmin";
    }

    @RequestMapping(path = "/workoutCancel")
    public String cancelWorkoutProcessor(@RequestParam Long workoutId, ModelMap modelHolder, RedirectAttributes flash) {
        modelHolder.put("workout", workoutClassDao.getWorkoutClassById(workoutId));
        if (auth.userHasRole(admin)) {
            return "workoutCancel";
        }
        flash.addFlashAttribute("message", "Please login as an admin to proceed");
        return "redirect:/login";
    }

    @RequestMapping(path = "/workoutCancelProcess")
    public String cancelWorkoutClass(@RequestParam Long workoutId, ModelMap modelHolder, RedirectAttributes flash) {
        if (auth.userHasRole(admin)) {
            WorkoutClass workoutClass = workoutClassDao.getWorkoutClassById(workoutId);
            try {
                workoutClassDao.cancelWorkoutClass(workoutId);
                flash.addFlashAttribute("message", "Successfully cancelled workout class " + workoutClass.getClassName());
                return "redirect:/scheduleClassAdmin";
            } catch (DataIntegrityViolationException e){
                flash.addFlashAttribute("message", "Cannot delete a class with enrolled users. Please confirm removal of enrolled users");
                modelHolder.put("workout", workoutClass);
                return "redirect:/confirmWorkoutCancellation";
            }
        }
        flash.addFlashAttribute("message", "Please login as an admin to proceed");
        return "redirect:/login";
    }

    @RequestMapping(path = "confirmWorkoutCancellation")
    public String confirmWorkoutCancellation(RedirectAttributes flash, ModelMap modelHolder){
        return "confirmWorkoutCancellation";
    }


    @RequestMapping(path = "allWorkoutClasses")
    public String viewAllWorkoutClasses(ModelMap modelHolder) {
        List<WorkoutClass> workouts = workoutClassDao.getAllWorkoutClasses();
        modelHolder.put("workouts", workouts);
        return "allWorkoutClasses";
    }

    @RequestMapping(path = "myWorkoutClasses")
    public String myWorkoutClasses(HttpSession session, ModelMap modelHolder, RedirectAttributes flash){
        if(auth.isLoggedIn()){
            User user = (User) session.getAttribute("user");
            List<WorkoutClass> myWorkouts = workoutClassDao.myWorkoutClasses(user.getId());
            modelHolder.put("workouts", myWorkouts);
            return "myWorkoutClasses";
        }
        flash.addFlashAttribute("message", "Please sign in to view your workout classes");
        return "redirect:/login";
    }

    @RequestMapping(path = "cancelWorkout")
    public String cancelWorkout(Long workoutId, ModelMap modelHolder, RedirectAttributes flash){
        if (auth.isLoggedIn()){
            WorkoutClass workout = workoutClassDao.getWorkoutClassById(workoutId);
            modelHolder.put("workout", workout);
            return "cancelWorkout";
        }
        flash.addFlashAttribute("message", "Please sign in to cancel your workout classes");
        return "redirect:/login";
    }

    @RequestMapping(path = "workoutDelete")
    public String deleteWorkoutReservation(Long workoutId, RedirectAttributes flash, HttpSession session){
        if (auth.isLoggedIn()){
            User user = (User) session.getAttribute("user");
            workoutSignUpDao.cancelMyWorkoutReservation(user.getId(), workoutId);
            flash.addFlashAttribute("message", "Your reservation was canceled successfully");
            return "redirect:/myWorkoutClasses";
        }
        flash.addFlashAttribute("message", "Please sign in to cancel your workout classes");
        return "redirect:/login";
    }

    @RequestMapping(path = "workoutClassMembers")
    public String showWorkoutClassMembers(@RequestParam Long workoutId, RedirectAttributes flash, ModelMap modelHolder){
        List<User> users = workoutSignUpDao.searchWorkoutUsers(workoutId);
        WorkoutClass workoutClass = workoutClassDao.getWorkoutClassById(workoutId);
        if (user.length > 0){
            modelHolder.put("users", users);
            modelHolder.put("workout", workoutClass);
        } else {
            flash.addFlashAttribute("message", "No users are currently enrolled in this class");
        }
        return "workoutClassMembers";
    }
}
