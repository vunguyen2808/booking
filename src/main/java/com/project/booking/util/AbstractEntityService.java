package com.project.booking.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
public abstract class AbstractEntityService<J extends JpaRepository<T, ID>, T, ID> {
    protected static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyDDDHH");
    protected final J repository;

    protected AbstractEntityService(J repository) {
        this.repository = repository;
    }

    public Optional<T> findById(ID id) {
        return Optional.ofNullable(id).flatMap(repository::findById);
    }

    public List<T> findAll() {
        return repository.findAll();
    }

    public Page<T> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Transactional
    public T save(T entity) {
        return repository.save(entity);
    }

    @Transactional
    public T delete(T entity) {
        repository.delete(entity);
        return entity;
    }

    protected String generateUid() {
        LocalTime localTime = LocalTime.now().withHour(0);//.withMinute(0);
        String nanoTime = Long.toString(localTime.toNanoOfDay(), Character.MAX_RADIX).toUpperCase();
        return DATE_FORMAT.format(Date.from(Instant.now())).concat(nanoTime);
    }
}
