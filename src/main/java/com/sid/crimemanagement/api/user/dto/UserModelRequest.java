package com.sid.crimemanagement.api.user.dto;

import lombok.Getter;

@Getter
public class UserModelRequest {
    String name;
    String email;
    String password;
    String age;
    String aadhaarNumber;
    String gender;
    String phoneNumber;
    String apiKey;
}
