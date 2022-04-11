package com.techelevator.controller;

import com.techelevator.dao.JdbcEquipmentLogDao;
import com.techelevator.dao.JdbcWorkoutMetricsDao;
import com.techelevator.dao.WorkoutMetricsDao;
import com.techelevator.model.EquipmentLog;
import com.techelevator.model.User;
import com.techelevator.model.WorkoutMetrics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class WorkoutMetricsController {

    @Autowired
    JdbcWorkoutMetricsDao workoutMetricsDao;

    @RequestMapping(value = "/workOutMetrics", method = RequestMethod.GET)
    public String getWorkOutMetricsPage(ModelMap modelHolder, HttpSession session) {
        System.out.println("getWorkOutMetricsPage -- GET method ");
        User user = (User) session.getAttribute("user");
        List<WorkoutMetrics> logs = workoutMetricsDao.getWorkoutMetricsByUser(user.getUsername());
        modelHolder.put("log", logs);
        return  "workOutMetrics";
    }


    @RequestMapping(value = "/workOutMetricsOfEmp", method = RequestMethod.GET)
    public String getWorkOutMetricsOfUser(ModelMap modelHolder, HttpSession session) {
      System.out.println("this is workOutMetricsOfEmp -- GET method");
        return "workOutMetricsOfEmployee";
    }

    @RequestMapping(value = "/workOutMetricsOfEmp", method = RequestMethod.POST)
    public String getWorkOutMetricsOfEmployee(@RequestParam String username, ModelMap modelHolder, HttpSession session) {
        System.out.println("workOutMetricsOfEmp -- POSt "+username);
        List<WorkoutMetrics> logs = workoutMetricsDao.getWorkoutMetricsByUser(username);
        modelHolder.put("log", logs);
        System.out.println("this is workOutMetricsOfEmp -- POST method data : "+logs.size()+" and "+logs);
        return "workOutMetricsOfEmployee";
    }


}
