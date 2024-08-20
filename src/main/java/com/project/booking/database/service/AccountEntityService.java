package com.project.booking.database.service;

import com.project.booking.database.entity.AccountEntity;
import com.project.booking.database.repository.AccountEntityRepository;
import com.project.booking.endpoint.request.AccountCreateUpdateForm;
import com.project.booking.util.AbstractEntityService;
import com.project.booking.util.RestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class AccountEntityService extends AbstractEntityService<AccountEntityRepository, AccountEntity, UUID> {
    private final PasswordEncoder passwordEncoder;

    public AccountEntityService(AccountEntityRepository repository, PasswordEncoder passwordEncoder) {
        super(repository);
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public AccountEntity create(AccountCreateUpdateForm form) {
        if (repository.existsByLogin(form.getLogin()))
            throw RestException.badRequest("User login already exists");

        if (repository.existsByEmail(form.getEmail()))
            throw RestException.badRequest("User email already exists");

        if (form.getPassword() == null)
            form.setPassword(UUID.randomUUID().toString());

        AccountEntity entity = new AccountEntity();
        entity.setLogin(form.getLogin());
        entity.setEmail(form.getEmail());
        entity.setName(form.getName());
        entity.setPassword(passwordEncoder.encode(form.getPassword()));
        repository.save(entity);

        return entity;
    }

    @Transactional
    public AccountEntity update(UUID id, AccountCreateUpdateForm form) {
        AccountEntity entity = repository.findById(id).orElseThrow(() -> RestException.badRequest("Account not found"));

        if (form.getPassword() == null)
            form.setPassword(UUID.randomUUID().toString());

        entity.setName(form.getName());
        entity.setPassword(passwordEncoder.encode(form.getPassword()));
        repository.save(entity);

        return entity;
    }

    public Optional<AccountEntity> findByLoginAndEmail(String login, String email) {
        return repository.findByLoginAndEmail(login, email);
    }

    public Optional<AccountEntity> findByLoginOrEmail(String userLoginOrEmail) {
        return repository.findByLoginOrEmail(userLoginOrEmail, userLoginOrEmail);
    }
}
