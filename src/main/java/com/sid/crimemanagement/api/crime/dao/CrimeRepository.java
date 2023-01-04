package com.sid.crimemanagement.api.crime.dao;

import com.sid.crimemanagement.api.crime.dto.CrimeRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CrimeRepository extends JpaRepository<CrimeRequest,Long> {
    long countByCrimeKey(String crimeKey);
    CrimeRequest findAllByCrimeKey(String crimeKey);
}
