package com.sid.crimemanagement.api.police.services;

import com.sid.crimemanagement.api.crime.CrimeException;
import com.sid.crimemanagement.api.crime.dao.CrimeRepository;
import com.sid.crimemanagement.api.crime.dto.CrimeRequest;
import com.sid.crimemanagement.api.police.dao.PoliceRepository;
import com.sid.crimemanagement.api.police.dto.PoliceModel;
import com.sid.crimemanagement.api.police.dto.PoliceModelRequest;
import com.sid.crimemanagement.api.police.exception.PoliceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PoliceServices {
    @Autowired
    private PoliceRepository policeRepository;
    @Autowired
    private CrimeRepository crimeRepository;


    public String registerPolice(PoliceModelRequest policeModelRequest) {
        if(policeRepository.countByPoliceStationEmail(policeModelRequest.getPoliceStationEmail())>0){
            return "Invalid";
        }else{
            PoliceModel policeModel = new PoliceModel();
            policeModel.setPoliceStationEmail(policeModelRequest.getPoliceStationEmail());
            policeModel.setPoliceStationName(policeModelRequest.getPoliceStationName());
            policeModel.setPoliceStationLocation(policeModelRequest.getPoliceStationLocation());
            String key = UUID.randomUUID().toString();
            policeModel.setPoliceStationCode(key);
            policeRepository.save(policeModel);
            return key;
        }
    }

    public List<CrimeRequest> getAllCrimeData(String policeStationCode) {
        if(policeRepository.countByPoliceStationCode(policeStationCode)<0){
           throw new PoliceException();

        }
        return crimeRepository.findAll();
    }

    public CrimeRequest getCrimeReport(String policeStationCode, String crimeKey) {
        if(policeRepository.countByPoliceStationCode(policeStationCode)<0){
            throw new PoliceException();

        }else {
            if(crimeRepository.countByCrimeKey(crimeKey)<0){
                throw new CrimeException();
            }else{
                 return crimeRepository.findAllByCrimeKey(crimeKey);
            }
        }
    }
}
