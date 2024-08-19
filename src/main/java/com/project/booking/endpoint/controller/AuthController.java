package com.project.booking.endpoint.controller;

import com.project.booking.endpoint.request.AccountLoginForm;
import com.project.booking.endpoint.request.AccountRegisterForm;
import com.project.booking.endpoint.response.AccountInfo;
import com.project.booking.endpoint.service.AuthService;
import com.project.booking.util.RestResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public RestResponse<AccountInfo> register(@Valid @RequestBody AccountRegisterForm form, HttpServletRequest request) {
        AccountInfo dto = authService.registerAccount(form);
        return RestResponse.success(dto);
    }

    @PostMapping("/login")
    public RestResponse<AccountInfo> login(@Valid @RequestBody AccountLoginForm form, HttpServletRequest request, HttpServletResponse response) {
        AccountInfo dto = authService.loginAccount(form);
        return RestResponse.success(dto);
    }
}
