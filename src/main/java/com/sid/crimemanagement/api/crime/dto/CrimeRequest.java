package com.sid.crimemanagement.api.crime.dto;

import com.sid.crimemanagement.api.user.dto.UserModel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
@Getter
@Setter
public class CrimeRequest extends AbstractPersistable<Long> {

    String crimeKey;
    String headLine;
    Date date;
    String crimeDescription;
    String crimeLocation;
    String timeOfIncident;
    @OneToOne
    UserModel userReporter;
    String policeStationCode;
}
