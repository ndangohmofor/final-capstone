package com.techelevator.controller;

import com.techelevator.dao.JdbcMachineDao;
import com.techelevator.model.Machine;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

public class MachineController {


    private JdbcMachineDao jdbcMachineDao;

    @RequestMapping( "/viewMachines")
    public String showMachines(@RequestParam(required = false) String machineName, ModelMap map){
        if(machineName == null) {
            List<Machine> machines = new ArrayList<>();
            map.put("machines", machines);
        } else {
            map.put("machines", jdbcMachineDao.getMachinesByName(machineName));
        }
        return "machineList";

    }



}
