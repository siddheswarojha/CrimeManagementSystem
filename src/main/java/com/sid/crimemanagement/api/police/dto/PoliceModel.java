package com.sid.crimemanagement.api.police.dto;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class PoliceModel extends AbstractPersistable<Long> {
    String policeStationEmail;
    String policeStationCode;
    String policeStationName;
    String policeStationLocation;
}
