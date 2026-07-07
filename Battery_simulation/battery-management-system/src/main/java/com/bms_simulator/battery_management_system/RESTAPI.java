package com.bms_simulator.battery_management_system;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class RESTAPI {

    @GetMapping("/getReading")
    public String getData(@RequestParam String param) {
        return new String();
    }

    @PostMapping("/sendReading")
    public float[][] postData(@RequestBody float[][] entity) {
        // TODO: process POST request
        System.out.println(entity);
        return entity;
    }

}
