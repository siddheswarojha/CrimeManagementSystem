package com.sid.crimemanagement.api.user.services;

import com.sid.crimemanagement.api.administrator.dao.AdministratorRepository;
import com.sid.crimemanagement.api.crime.dao.CrimeRepository;
import com.sid.crimemanagement.api.crime.dto.CrimeAddRequest;
import com.sid.crimemanagement.api.crime.dto.CrimeRequest;
import com.sid.crimemanagement.api.user.dao.UserRepository;
import com.sid.crimemanagement.api.user.dto.UserModel;
import com.sid.crimemanagement.api.user.dto.UserModelRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServices {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CrimeRepository crimeRepository;


    public String registerCrime(String apiKey, CrimeAddRequest crimeAddRequest) {
        if(userRepository.countByApiKey(apiKey)<0){
            return "Invalid";
        }else{
            CrimeRequest crimeRequest = new CrimeRequest();
            crimeRequest.setCrimeDescription(crimeAddRequest.getCrimeDescription());
            crimeRequest.setCrimeLocation(crimeAddRequest.getCrimeLocation());
            crimeRequest.setDate(crimeAddRequest.getDate());
            crimeRequest.setHeadLine(crimeAddRequest.getHeadLine());
            crimeRequest.setUserReporter(userRepository.findUserByApiKey(apiKey));
            crimeRequest.setPoliceStationCode(crimeAddRequest.getPoliceStationCode());
            crimeRepository.save(crimeRequest);
            String key = UUID.randomUUID().toString();
            crimeRequest.setCrimeKey(key);
            return "Success";
        }


    }

    public String registerUser(UserModelRequest userModelRequest) {
        if(userRepository.countByEmail(userModelRequest.getEmail())>0){
            return "Invalid";
        }else{
            UserModel userModel = new UserModel();
            userModel.setName(userModelRequest.getName());
            userModel.setEmail(userModelRequest.getEmail());
            userModel.setGender(userModelRequest.getGender());
            userModel.setPassword(userModelRequest.getPassword());
            userModel.setAge(userModelRequest.getAge());
            userModel.setPhoneNumber(userModelRequest.getPhoneNumber());
            userModel.setAadhaarNumber(userModel.getAadhaarNumber());
            String key = UUID.randomUUID().toString();
            userModel.setApiKey(key);
            userRepository.save(userModel);
            return key;
        }
    }
}
