package com.project.booking.endpoint.service;

import com.project.booking.database.entity.AccountEntity;
import com.project.booking.database.service.AccountEntityService;
import com.project.booking.endpoint.request.AccountCreateUpdateForm;
import com.project.booking.endpoint.request.AccountLoginForm;
import com.project.booking.endpoint.request.AccountRegisterForm;
import com.project.booking.endpoint.response.AccountInfo;
import com.project.booking.util.RestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuthService {
    private final PasswordEncoder passwordEncoder;
    private final AccountEntityService accountEntityService;

    public AuthService(PasswordEncoder passwordEncoder, AccountEntityService accountEntityService) {
        this.passwordEncoder = passwordEncoder;
        this.accountEntityService = accountEntityService;
    }

    public AccountInfo registerAccount(AccountRegisterForm form) {
        AccountEntity account = accountEntityService.findByLoginAndEmail(form.getLogin(), form.getEmail())
                .orElse(null);
        if (account == null) {
            account = accountEntityService.create(AccountCreateUpdateForm.builder()
                    .login(form.getLogin())
                    .email(form.getEmail())
                    .name(form.getName())
                    .password(form.getPassword())
                    .build());
        }
        return AccountInfo.from(account);
    }

    public AccountInfo loginAccount(AccountLoginForm form) {
        AccountEntity account = accountEntityService.findByLoginOrEmail(form.getLoginOrEmail()).orElse(null);
        if (account == null || !passwordEncoder.matches(form.getPassword(), account.getPassword())) {
            throw RestException.badRequest("Invalid login or password");
        }
        return AccountInfo.from(account);
    }
}
