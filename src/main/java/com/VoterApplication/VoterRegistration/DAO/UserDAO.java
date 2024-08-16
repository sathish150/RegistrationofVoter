package com.VoterApplication.VoterRegistration.DAO;

import com.VoterApplication.VoterRegistration.Entity.UserEntity;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<UserEntity, Id> {
}
