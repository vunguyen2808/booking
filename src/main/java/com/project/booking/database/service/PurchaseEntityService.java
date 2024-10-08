package com.project.booking.database.service;

import com.project.booking.database.entity.PurchaseEntity;
import com.project.booking.database.repository.PurchaseEntityRepository;
import com.project.booking.endpoint.request.PurchaseCreateForm;
import com.project.booking.util.AbstractEntityService;
import com.project.booking.util.RestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class PurchaseEntityService extends AbstractEntityService<PurchaseEntityRepository, PurchaseEntity, UUID> {

    public PurchaseEntityService(PurchaseEntityRepository repository) {
        super(repository);
    }

    @Transactional
    public PurchaseEntity create(PurchaseCreateForm form) {
        LocalDate localCheckIn = LocalDate.parse(form.getCheckIn());
        Instant checkIn = localCheckIn.atStartOfDay(ZoneId.of("UTC")).toInstant();

        LocalDate localCheckOut = LocalDate.parse(form.getCheckOut());
        Instant checkOut = localCheckOut.atStartOfDay(ZoneId.of("UTC")).toInstant();

        PurchaseEntity entity = new PurchaseEntity();
        entity.setCheckIn(checkIn);
        entity.setCheckOut(checkOut);
        entity.setRoomType(form.getRoomType());
        entity.setTotal(form.getTotal());
        entity.setAccountId(form.getAccountId());
        /*entity.setRoom(roomEntityRepository.findById(form.getRoomId())
                .orElseThrow(() -> RestException.badRequest("Room not found")));*/
        repository.save(entity);
        return entity;
    }

    @Transactional
    public PurchaseEntity delete(UUID id) {
        PurchaseEntity entity = repository.findById(id)
                .orElseThrow(() -> RestException.badRequest("Room not found"));

        Instant now = Instant.now();
        if (now.isBefore(entity.getCheckIn()) && now.isAfter(entity.getCheckOut()))
            throw RestException.badRequest("Can not delete room");

        repository.delete(entity);
        return entity;
    }

    public List<PurchaseEntity> findAllPurchaseByAccountId(UUID id) {
        return repository.findByAccountId(id);
    }
}
