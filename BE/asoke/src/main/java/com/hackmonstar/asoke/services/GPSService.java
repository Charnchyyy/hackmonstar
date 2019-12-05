package com.hackmonstar.asoke.services;

import com.hackmonstar.asoke.models.GPS;
import com.hackmonstar.asoke.models.responders.BaseResponder;
import com.hackmonstar.asoke.models.responders.GPSResponder;
import com.hackmonstar.asoke.repositories.GPSRepository;
import com.hackmonstar.asoke.utilities.Constants;
import com.hackmonstar.asoke.utilities.ResponderHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GPSService {
    @Autowired
    private GPSRepository gpsRepository;

    public Object fetchAll(){
        return (List<GPS>) gpsRepository.findAll();
    }

    public List<GPS> fetchAllTaxi(){
//        List<GPS> gpsList = gpsRepository.findTaxi();
//        ResponderHelper responderHelper = new ResponderHelper(new BaseResponder());
//        if(gpsList != null) {
//            responderHelper.setSuccess(Constants.OK,gpsList);
//        }
//        return responderHelper.getResponders();
        return gpsRepository.findTaxi();
    }

    public Object fetchTaxi(String meter){
        return (List<GPS>) gpsRepository.findTaxiByMeter(meter);
    }
}
