package com.project.booking.database.repository;

import com.project.booking.database.entity.PurchaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PurchaseEntityRepository extends JpaRepository<PurchaseEntity, UUID> {

    List<PurchaseEntity> findByAccountId(UUID accountId);
}
