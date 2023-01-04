package com.sid.crimemanagement.api.police.controller;


import com.sid.crimemanagement.api.crime.dto.CrimeRequest;
import com.sid.crimemanagement.api.police.dto.PoliceModelRequest;
import com.sid.crimemanagement.api.police.services.PoliceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pcrb/api/v1/police")
public class PoliceController {

    @Autowired
    private PoliceServices policeServices;

    @GetMapping("{policeStationCode}/")
    public List<CrimeRequest> getAllCrimeData(@PathVariable("policeStationCode") String policeStationCode){
        return policeServices.getAllCrimeData(policeStationCode);
    }

    @PostMapping("/register")
    public String registerPolice(PoliceModelRequest policeModelRequest){
        return policeServices.registerPolice(policeModelRequest);
    }
}
