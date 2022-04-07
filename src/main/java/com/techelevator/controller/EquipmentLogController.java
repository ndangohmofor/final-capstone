package com.techelevator.controller;

import com.techelevator.dao.JdbcEquipmentLogDao;
import com.techelevator.model.EquipmentLog;
import com.techelevator.model.User;
import org.bouncycastle.math.raw.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
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


}
