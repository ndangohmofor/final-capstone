package com.techelevator.controller;

import com.techelevator.dao.JdbcWorkoutClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WorkoutClassController {
    @Autowired
    private JdbcWorkoutClass jdbcWorkoutClass;


}
