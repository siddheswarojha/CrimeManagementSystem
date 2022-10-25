package com.sid.crimemanagement.api.crime.dto;

import lombok.Getter;

import java.util.Date;

@Getter
public class CrimeAddRequest {
    String headLine;
    Date date;
    String crimeDescription;
    String crimeLocation;
    String timeOfIncident;
    String userReporter;
    String policeStationCode;
}
