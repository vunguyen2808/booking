package com.project.booking.endpoint.request;

import com.project.booking.util.AbstractJsonSerializable;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountLoginForm extends AbstractJsonSerializable {
    @NotBlank
    private String loginOrEmail;

    @NotBlank
    private String password;

    private boolean remember;
}
