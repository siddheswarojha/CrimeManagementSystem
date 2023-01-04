package com.sid.crimemanagement.api.user.controller;

import com.sid.crimemanagement.api.crime.dto.CrimeAddRequest;
import com.sid.crimemanagement.api.user.dto.UserModelRequest;
import com.sid.crimemanagement.api.user.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pcrb/api/v1/user")
public class UserController {

    @Autowired
    private UserServices userServices;

//    @GetMapping("/{apiKey}")
//    public List<UserModel> getAllRegisteredUser(@PathVariable("apiKey") String apiKey){
//        return userServices.getAllRegisteredUser(apiKey);
//    }

    @PostMapping("/reportCrime/{userApiKey}")
    public String registerCrime(@PathVariable("userApiKey") String apiKey, @RequestBody CrimeAddRequest crimeAddRequest){
        return userServices.registerCrime(apiKey,crimeAddRequest);
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam UserModelRequest userModelRequest){
        return userServices.registerUser(userModelRequest);
    }


}
