package com.amitu.elkdemo.elkdemo.controller;

import com.amitu.elkdemo.elkdemo.service.ELKService;
import com.fasterxml.jackson.databind.JsonNode;
import org.json.simple.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(value = "/api")
public class ELKController {

    // Initializing instance of Logger for Controller
    private static final Logger log = LoggerFactory.getLogger(ELKController.class);

    private final ELKService service;

    public ELKController(ELKService service) {
        this.service = service;
    }

    @GetMapping(value = "/hello")
    public String helloWorld() {
        log.info("Inside Hello World Function");
        String response = "Hello World! " + new Date();
        log.info("Response => {}",response);
        return response;
    }

    @GetMapping(value = "/Food-Details")
    public JSONArray foodDetails() {
        log.info("Inside Food Detail Function");
        return service.getAllFoodDetails();
    }
}
