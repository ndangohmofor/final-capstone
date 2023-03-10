package com.techelevator.controller;

import com.techelevator.authentication.AuthProvider;
import com.techelevator.dao.CreateAccountDao;
import com.techelevator.dao.WorkoutClassDao;
import com.techelevator.model.User;
import com.techelevator.model.WorkoutClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;


/**
 * AccountController
 */
@Controller
public class AccountController {
    private String[] admin = new String[]{"admin", "employee"};
    private String[] user = new String[]{"user"};


    @Autowired
    private AuthProvider auth;
    @Autowired
    private CreateAccountDao createAccountDao;

    @Autowired
    private WorkoutClassDao workoutClassDao;

    @RequestMapping(method = RequestMethod.GET, path = {"/", "/index", "/indexAdmin"})
    public String index(ModelMap modelHolder) {
        modelHolder.put("user", auth.getCurrentUser());
        List<WorkoutClass> workouts = workoutClassDao.getFirst5Classes();
        modelHolder.addAttribute("workouts", workouts);
        if (auth.userHasRole(admin)) {
            return "indexAdmin";
        }
        return "index";
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String login(ModelMap modelMap) {
        return "login";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String username, @RequestParam String password, RedirectAttributes flash, HttpSession session) {
        if (auth.signIn(username, password) && auth.userHasRole(admin)) {
            //creating session and adding user
            session.setAttribute("user", auth.getCurrentUser());
            /*String previousRoute = (session.getAttribute("previousRoute") == null) ? "privateAdmin" : session.getAttribute("previousRoute").toString();
            session.removeAttribute("previousRoute");*/
            return "redirect:/indexAdmin";
        }
        if (auth.signIn(username, password) && auth.userHasRole(user)) {
            //creating session and adding user
            session.setAttribute("user", auth.getCurrentUser());
            return "redirect:/createAccount";

        } else {
            flash.addFlashAttribute("message", "Login Invalid");
            return "redirect:/login";
        }
    }

    @RequestMapping(path = "/privateAdmin", method = RequestMethod.GET)
    public String displayAdminHome(ModelMap modelHolder) {
        List<WorkoutClass> workouts = workoutClassDao.getAllWorkoutClasses();
        modelHolder.addAttribute("workouts", workouts);
        return "privateAdmin";
    }

    @RequestMapping(path = "/logoff", method = RequestMethod.POST)
    public String logOff(HttpSession session) {
        //closing the session and removing user
        session.removeAttribute("user");
        auth.logOff();
        return "redirect:/";
    }

    @RequestMapping(value = {"/register", "/registerAdmin"}, method = RequestMethod.GET)
    public String register(ModelMap modelHolder, HttpSession session) {
        if (!modelHolder.containsAttribute("user")) {
            modelHolder.put("user", new User());
        }
        if (auth.userHasRole(admin)) {
            modelHolder.put("userAdmin",session.getAttribute("user"));
            return "registerAdmin";
        }
        return "register";
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String register(@Valid @ModelAttribute("user") User user, BindingResult result, RedirectAttributes flash) {
        if (result.hasErrors()) {
            flash.addFlashAttribute("user", user);
            flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "user", result);
            flash.addFlashAttribute("message", "Please fix the following errors:");
            return "redirect:/register";
        }
        auth.register(user.getUsername(), user.getPassword(), user.getRole());
        return "redirect:/";
    }

    @RequestMapping(path = "/registerAdmin", method = RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, RedirectAttributes flash) {
        if (result.hasErrors()) {
            flash.addFlashAttribute("user", user);
            flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "user", result);
            flash.addFlashAttribute("message", "Please fix the following errors:");
            return "redirect:/registerAdmin";
        }
        auth.register(user.getUsername(), user.getPassword(), user.getRole());
        flash.addFlashAttribute("message", user.getRole() + " created successfully");
        return "redirect:/registerAdmin";
    }


}
