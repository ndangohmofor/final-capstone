package com.techelevator.controller;

import com.techelevator.authentication.AuthProvider;
import com.techelevator.dao.JdbcEquipmentLogDao;
import com.techelevator.dao.JdbcWorkoutMetricsDao;
import com.techelevator.dao.WorkoutMetricsDao;
import com.techelevator.model.EquipmentLog;
import com.techelevator.model.User;
import com.techelevator.model.WorkOutMetricsLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class WorkoutMetricsController {

    @Autowired
    private AuthProvider auth;

    @Autowired
    JdbcWorkoutMetricsDao workoutMetricsDao;

    @RequestMapping(value = "/workOutMetrics", method = RequestMethod.GET)
    public String getWorkOutMetricsPage(ModelMap modelHolder, HttpSession session, RedirectAttributes flash) {
        if (auth.isLoggedIn()) {
            System.out.println("getWorkOutMetricsPage -- GET method ");
            User user = (User) session.getAttribute("user");
            List<WorkOutMetricsLog> logs = workoutMetricsDao.getWorkoutMetricsByUser(user.getId());
            modelHolder.put("log", logs);

            return "workOutMetrics";
        }
        flash.addFlashAttribute("message", "Please login to view your workout metrics");
        return "redirect:/login";
    }


    @RequestMapping(value = "/workOutMetricsOfEmp", method = RequestMethod.GET)
    public String getWorkOutMetricsOfUser(ModelMap modelHolder, HttpSession session) {
        System.out.println("this is workOutMetricsOfEmp -- GET method");
        return "workOutMetricsOfEmployee";
    }

    @RequestMapping(value = "/workOutMetricsOfEmp", method = RequestMethod.POST)
    public String getWorkOutMetricsOfEmployee(@RequestParam String username, ModelMap modelHolder, HttpSession session, RedirectAttributes flash) {
        System.out.println("workOutMetricsOfEmp -- POSt " + username);
        List<WorkOutMetricsLog> logs = workoutMetricsDao.getWorkoutMetricsByUser(username);
        if (logs == null) {
            flash.addFlashAttribute("message", "Username not found");
            return "redirect:workOutMetricsOfEmployee";
        }
        modelHolder.put("log", logs);
        System.out.println("this is workOutMetricsOfEmp -- POST method data : " + logs.size() + " and " + logs);
        return "workOutMetricsOfEmployee";
    }

    @RequestMapping(path = "workOutMetricsOfEmployee")
    public String searchEmpByName(){
        return "workOutMetricsOfEmployee";
    }

}
