package com.VoterApplication.VoterRegistration.DAO;

import com.VoterApplication.VoterRegistration.Entity.RegistrationEntity;
import com.VoterApplication.VoterRegistration.models.VoterRegistrationResponseBody;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegistrationRepository  extends JpaRepository<RegistrationEntity, String>
{

   Optional<RegistrationEntity> findByAadharNumber(String aadharNumber);
}
