package com.sid.crimemanagement.api.user.dao;

import com.sid.crimemanagement.api.user.dto.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    long countByApiKey(String userApiKey);

    UserModel findUserByApiKey(String apiKey);

    long countByEmail(String email);


}
