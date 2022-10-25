package com.sid.crimemanagement.api.user.dto;


import com.sid.crimemanagement.api.crime.dto.CrimeRequest;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class UserModel extends AbstractPersistable<Long> {
    String name;
    String email;
    String password;
    String apiKey;
    String age;
    String aadhaarNumber;
    String gender;
    String phoneNumber;
    @OneToMany
    List<CrimeRequest> crimeRequest;
}
