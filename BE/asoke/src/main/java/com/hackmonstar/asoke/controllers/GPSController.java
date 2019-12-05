package com.hackmonstar.asoke.controllers;

import com.hackmonstar.asoke.models.GPS;
import com.hackmonstar.asoke.models.responders.BaseResponder;
import com.hackmonstar.asoke.services.GPSService;
import com.hackmonstar.asoke.utilities.Constants;
import com.hackmonstar.asoke.utilities.ResponderHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Controller
@CrossOrigin
@RestController
public class GPSController {

    @Autowired
    private GPSService gpsService;

    ResponderHelper responderHelper = new ResponderHelper(new BaseResponder());

    @GetMapping(value = "/gps")
    public ResponseEntity<?> getAll(){
        Object result = gpsService.fetchAll();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/taxi")
    public ResponseEntity<?> getAllTaxi(){
        List<GPS> result = gpsService.fetchAllTaxi();
        System.out.println("result" + result);
        return new ResponseEntity<>(result, HttpStatus.OK);
//        return gpsService.fetchAllTaxi();

    }

    @GetMapping(value = "/gps/taxi/{meter}")
    public ResponseEntity<?> getTaxi(@PathVariable String meter){
        System.out.println(meter + " test");
        Object result = gpsService.fetchTaxi(meter);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
