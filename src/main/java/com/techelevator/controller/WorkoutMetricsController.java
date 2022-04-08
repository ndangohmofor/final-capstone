package com.techelevator.controller;

import com.techelevator.dao.JdbcEquipmentLogDao;
import com.techelevator.model.EquipmentLog;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class WorkoutMetricsController {

    @Autowired
    JdbcEquipmentLogDao equipmentLogDao;

    @RequestMapping(value="/workOutMetrics", method= RequestMethod.GET)
    public String getWorkOutMetricsPage(ModelMap modelHolder, HttpSession session){
        User user = (User) session.getAttribute("user");
        String viewName = "";
        if(user.getRole().equalsIgnoreCase("user")){
            List<EquipmentLog> logs = equipmentLogDao.getEquipmentLogByUser(user.getId());
            modelHolder.put("log", logs);
            viewName = "workOutMetrics";
        }else if(user.getRole().equalsIgnoreCase("Admin")){
            viewName = "workOutMetricsOfEmployee";
        }
        return viewName;
    }


    @RequestMapping(value="/workOutMetricsOfEmp", method= RequestMethod.POST)
    public String getWorkOutMetricsOfUser(ModelMap modelHolder, HttpSession session) {

        return "";
    }







    }
