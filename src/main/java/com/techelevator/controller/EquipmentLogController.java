package com.techelevator.controller;

import com.techelevator.authentication.AuthProvider;
import com.techelevator.authentication.UnauthorizedException;
import com.techelevator.dao.JdbcEquipmentLogDao;
import com.techelevator.model.EquipmentLog;
import com.techelevator.model.User;
import org.bouncycastle.math.raw.Mod;
import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class EquipmentLogController {

    @Autowired
    JdbcEquipmentLogDao equipmentLogDao;

    @Autowired
    private AuthProvider auth;

    @RequestMapping (value = "/exerciseLog", method = RequestMethod.GET)
    public String displayExerciseLog (HttpSession session, ModelMap modelMap, RedirectAttributes flash){
        if (auth.userHasRole(new String[] { "admin", "user" })) {
            User user = (User) session.getAttribute("user");
            List<EquipmentLog> el = equipmentLogDao.getEquipmentLogByUser(user.getId());
            modelMap.put("log", el);

            return "equipmentLog";
        } else {
            flash.addFlashAttribute("message", "Please login to View  Exercise Log");
            return "redirect:/login";
        }
    }

    @RequestMapping (path = "/exerciseInput", method = RequestMethod.GET)
    public String displayExerciseInputForm (HttpSession session) throws UnauthorizedException {
        if (auth.userHasRole(new String[] { "admin", "user" })) {
            return "exerciseInputForm";
        } else {
            throw new UnauthorizedException();
        }

    }

    @RequestMapping (path = "/exerciseInput", method = RequestMethod.POST)
    public String submitExerciseInputForm (@Valid @ModelAttribute("log") EquipmentLog log, HttpSession session,
                                           @RequestParam  long duration, @RequestParam long weight, @RequestParam long reps, @RequestParam long machineId,
                                           BindingResult result, RedirectAttributes flash){
        if (result.hasErrors()) {
            flash.addFlashAttribute("log", log);
            flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "log", result);
            flash.addFlashAttribute("message", "Please fix the following errors:");
            return "redirect:/exerciseInputForm";
        }
        LocalDateTime dateTime = LocalDateTime.now();
        User user = (User) session.getAttribute("user");
        equipmentLogDao.addExerciseToLog(duration,dateTime,reps,weight,user.getId(),machineId);
        return "redirect:/exerciseLog";
    }

    @RequestMapping (value = "/workoutAdmin", method = RequestMethod.GET)
    public String searchExerciseLogAdmin (HttpSession session) throws UnauthorizedException {
        if (auth.userHasRole(new String[] { "admin"})) {
            User user = (User) session.getAttribute("user");
            return "equipmentLogAdmin";
        } else {
            throw new UnauthorizedException();
        }
    }


    @RequestMapping (value = "/workoutAdminSearch", method = RequestMethod.GET)
    public String displayExerciseLogAdmin (HttpSession session, ModelMap modelMap, RedirectAttributes flash, @RequestParam String input){
        User user = (User) session.getAttribute("user");
        List<EquipmentLog> el = equipmentLogDao.getUserLogsByName(input);
//        modelMap.put("log", el);
        if (el.isEmpty()) {
            flash.addFlashAttribute("message", "There is no Member with the last name: " + input);
            return "redirect:/workoutAdmin";
        } else {
            modelMap.put("message", "Results for: " + input);
            modelMap.put("log", el);

            return "equipmentLogAdmin";
        }
    }

}
