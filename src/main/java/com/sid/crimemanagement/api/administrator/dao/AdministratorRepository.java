package com.sid.crimemanagement.api.administrator.dao;

import com.sid.crimemanagement.api.administrator.dto.AdministratorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorRepository extends JpaRepository<AdministratorModel,Long> {

}
