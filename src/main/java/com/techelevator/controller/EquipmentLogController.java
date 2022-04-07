package com.techelevator.controller;

import com.techelevator.dao.JdbcEquipmentLogDao;
import com.techelevator.model.EquipmentLog;
import com.techelevator.model.User;
import org.bouncycastle.math.raw.Mod;
import org.jboss.logging.Param;
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

@Controller
public class EquipmentLogController {

    @Autowired
    JdbcEquipmentLogDao equipmentLogDao;

    @RequestMapping (value = "/exerciseLog", method = RequestMethod.GET)
    public String displayExerciseLog (HttpSession session, ModelMap modelMap){
        User user = (User) session.getAttribute("user");
        List<EquipmentLog> el = equipmentLogDao.getEquipmentLogByUser(user.getId());
        modelMap.put("log", el);

        return "equipmentLog";
    }

    @RequestMapping (path = "/exerciseInput", method = RequestMethod.GET)
    public String displayExerciseInputForm (HttpSession session){
        return "exerciseInputForm";
    }

    @RequestMapping (path = "/exerciseInput", method = RequestMethod.POST)
    public String submitExerciseInputForm (@Valid @ModelAttribute("log") EquipmentLog log, HttpSession session,
                                           @RequestParam String machineName, @RequestParam long duration, @RequestParam long weight, @RequestParam long reps,
                                           BindingResult result, RedirectAttributes flash){
        if (result.hasErrors()) {
            flash.addFlashAttribute("log", log);
            flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "log", result);
            flash.addFlashAttribute("message", "Please fix the following errors:");
            return "redirect:/exerciseInputForm";
        }
        User user = (User) session.getAttribute("user");

        return "redirect:/exerciseLog";
    }


}