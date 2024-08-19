package com.project.booking.database.repository;

import com.project.booking.database.entity.PurchaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PurchaseEntityRepository extends JpaRepository<PurchaseEntity, UUID> {
}
