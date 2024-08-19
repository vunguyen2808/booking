package com.project.booking.endpoint.request;

import com.project.booking.util.AbstractJsonSerializable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AccountRegisterForm extends AbstractJsonSerializable {
    @NotBlank
    private String login;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String name;

    @NotNull
    private String password;
}
