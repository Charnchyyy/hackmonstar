package com.hackmonstar.asoke.controllers;


import com.hackmonstar.asoke.services.MLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@CrossOrigin
@RestController
public class MLController {
    @Autowired
    private MLService mlService;

    @GetMapping(value = "/ml")
    public ResponseEntity<?> getAll(){
        Object result = mlService.fetchAll();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }



}
