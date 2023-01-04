package com.sid.crimemanagement.api.police.dao;


import com.sid.crimemanagement.api.police.dto.PoliceModel;
import com.sid.crimemanagement.api.police.dto.PoliceModelRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoliceRepository extends JpaRepository<PoliceModel, Long> {
    long countByPoliceStationEmail(String policeStationEmail);
    long countByPoliceStationCode(String policeStationCode);


}
