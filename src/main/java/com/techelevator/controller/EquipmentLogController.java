package com.techelevator.controller;

import com.techelevator.authentication.AuthProvider;
import com.techelevator.authentication.UnauthorizedException;
import com.techelevator.dao.JdbcEquipmentLogDao;
import com.techelevator.model.EquipmentLog;
import com.techelevator.model.User;
import com.techelevator.model.UserProfile;
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
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class EquipmentLogController {

    @Autowired
    JdbcEquipmentLogDao equipmentLogDao;

    @Autowired
    private AuthProvider auth;

    @RequestMapping(value = "/exerciseLog", method = RequestMethod.GET)
    public String displayExerciseLog(HttpSession session, ModelMap modelMap, RedirectAttributes flash) {
        if (auth.userHasRole(new String[]{"admin", "user"})) {
            User user = (User) session.getAttribute("user");
            List<EquipmentLog> el = equipmentLogDao.getEquipmentLogByUser(user.getId());
            modelMap.put("log", el);

            return "equipmentLog";
        } else {
            flash.addFlashAttribute("message", "Please login to access this page");
            return "redirect:/login";
        }
    }

    @RequestMapping(value = "/exerciseInputForm", method = RequestMethod.GET)
    public String displayWorkoutInputForm(ModelMap modelHolder, HttpSession session) {
        if (!modelHolder.containsAttribute("log")) {
            modelHolder.put("log", new EquipmentLog());
        }
        return "exerciseInputForm";
    }

    @RequestMapping(path = "/exerciseInputForm", method = RequestMethod.POST)
    public String displayWorkoutInputForm(@Valid @ModelAttribute EquipmentLog equipmentLog, BindingResult result, RedirectAttributes flash, HttpSession session) {
        if (result.hasErrors()) {
            flash.addFlashAttribute("log", equipmentLog);
            flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "log", result);
            flash.addFlashAttribute("message", "Please fill in the boxes:");
            return "redirect:/exerciseInputForm";
        } else {
            User user = (User) session.getAttribute("user");
            LocalDateTime dateTime = LocalDateTime.now();
            equipmentLogDao.addExerciseToLog(equipmentLog.getDuration(), dateTime, equipmentLog.getReps(), equipmentLog.getWeight(), user.getId(), equipmentLog.getMachineId());
            flash.addFlashAttribute("message", "Workout Added");
            return "redirect:/exerciseLog";
        }
    }

    @RequestMapping(value = "/workoutAdmin", method = RequestMethod.GET)
    public String searchExerciseLogAdmin(HttpSession session) throws UnauthorizedException {
        if (auth.userHasRole(new String[]{"admin"})) {
            User user = (User) session.getAttribute("user");
            return "equipmentLogAdmin";
        } else {
            throw new UnauthorizedException();
        }
    }


    @RequestMapping(value = "/workoutAdminSearch", method = RequestMethod.GET)
    public String displayExerciseLogAdmin(HttpSession session, ModelMap modelMap, RedirectAttributes flash, @RequestParam String input) {
        User user = (User) session.getAttribute("user");
        List<EquipmentLog> el = equipmentLogDao.getUserLogsByName(input);
        if (el.isEmpty()) {
            flash.addFlashAttribute("message", "There is no workouts for member: " + input);
            return "redirect:/workoutAdmin";
        } else {
            modelMap.put("message", "Results for: " + input);
            modelMap.put("log", el);

            return "equipmentLogAdmin";
        }
    }

}
