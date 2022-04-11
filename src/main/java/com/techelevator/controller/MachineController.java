package com.techelevator.controller;

import com.techelevator.dao.JdbcMachineDao;
import com.techelevator.model.Machine;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class MachineController {

    @Autowired
    JdbcMachineDao jdbcMachineDao;


    User user = new User();

    @RequestMapping("/viewMachines")
    public String showMachines(@RequestParam(required = false) String machineName, /*@RequestParam int machineUsage*/ ModelMap map) /*throws UnauthorizedException*/ {

        if (machineName == null) {
            jdbcMachineDao.updateMachineUsage();
            List<Machine> machines = jdbcMachineDao.getMachines();
            /*List<Machine> usageOfMachine = jdbcMachineDao.updateMachineUsage(machineUsage);*/
            map.put("machines", machines);
            /*map.put("machineUsages", usageOfMachine);*/
        } else {
            map.put("machines", jdbcMachineDao.getMachinesByName(machineName));
        }
        /*if(user.getRole().equals("editor")){
            return "machineList";
        } else {
            throw new UnauthorizedException();
        }*/
        return "machineList";
    }

    @RequestMapping("/viewMachinesByType")
    public String getMachineByType(@RequestParam String machineType, ModelMap map) {
        map.put("machines", jdbcMachineDao.getMachinesByType(machineType));
        return "machineList";
    }

    @RequestMapping(value = "/addMachine", method = RequestMethod.GET)
    public String showAddMachineForm(@RequestParam String machineType, ModelMap model) {
        model.put("types", jdbcMachineDao.getMachinesByType(machineType));
        return "machineInput";
    }

    @RequestMapping(name = "/addMachine", method = RequestMethod.POST)
    public String addMachineForm(@RequestParam String machineName, @RequestParam String machineType, @RequestParam String machineReference, @RequestParam int machineUsage) {
        jdbcMachineDao.addMachine(machineName, machineType, machineReference, machineUsage);
        return "redirect:/viewMachines";
    }

    @RequestMapping(value = "/viewMachineInfo")
    public String viewMachineInfo(ModelMap model) {
        List<Machine> machines = jdbcMachineDao.getMachines();

        model.put("machines", machines);

        return "machineInfo";
    }



}
