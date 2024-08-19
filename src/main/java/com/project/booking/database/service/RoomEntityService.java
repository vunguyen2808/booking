/*
package com.project.booking.database.service;

import com.project.booking.database.entity.RoomEntity;
import com.project.booking.database.repository.RoomEntityRepository;
import com.project.booking.endpoint.request.RoomCreateUpdateForm;
import com.project.booking.util.AbstractEntityService;
import com.project.booking.util.RestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Slf4j
@Service
public class RoomEntityService extends AbstractEntityService<RoomEntityRepository, RoomEntity, UUID> {

    public RoomEntityService(RoomEntityRepository repository) {
        super(repository);
    }

    @Transactional
    public RoomEntity create(RoomCreateUpdateForm form) {
        RoomEntity entity = new RoomEntity();
        entity.setName(form.getName());
        entity.setPrice(form.getPrice());
        entity.setType(form.getType());
        entity.setImage(form.getImage());
        repository.save(entity);
        return entity;
    }

    @Transactional
    public RoomEntity update(UUID id, RoomCreateUpdateForm form) {
        RoomEntity entity = repository.findById(id)
                .orElseThrow(() -> RestException.badRequest("Room not found"));
        entity.setName(form.getName());
        entity.setPrice(form.getPrice());
        entity.setType(form.getType());
        entity.setImage(form.getImage());
        repository.save(entity);
        return entity;
    }

    @Transactional
    public RoomEntity delete(UUID id) {
        RoomEntity entity = repository.findById(id)
                .orElseThrow(() -> RestException.badRequest("Room not found"));
        repository.delete(entity);
        return entity;
    }
}
*/
