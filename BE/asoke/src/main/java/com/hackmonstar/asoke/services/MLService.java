package com.hackmonstar.asoke.services;

import com.hackmonstar.asoke.models.GPS;
import com.hackmonstar.asoke.models.ML;
import com.hackmonstar.asoke.repositories.MLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MLService {
    @Autowired
    private MLRepository mlRepository;

    public Object fetchAll(){
        List<ArrayList> mlList = new ArrayList<>();
        for (ML ml: mlRepository.findAll()) {
            ArrayList<String> newML = new ArrayList<>();
            newML.add(ml.getGrid_lat().toString());
            newML.add(ml.getGrid_lng().toString());
            newML.add(ml.getDensity().toString());
            mlList.add(newML);
        }
        System.out.println(mlList);
        return mlList;
    }
}
