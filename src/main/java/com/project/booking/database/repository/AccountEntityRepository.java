package com.project.booking.database.repository;

import com.project.booking.database.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AccountEntityRepository extends JpaRepository<AccountEntity, UUID> {

    boolean existsByLogin(String login);

    boolean existsByEmail(String email);

    Optional<AccountEntity> findByLoginAndEmail(String login, String email);

    Optional<AccountEntity> findByLoginOrEmail(String login, String email);

}
