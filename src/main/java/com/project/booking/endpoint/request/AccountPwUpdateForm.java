package com.project.booking.endpoint.request;

import com.project.booking.util.AbstractJsonSerializable;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AccountPwUpdateForm extends AbstractJsonSerializable {
    @NotBlank
    private String password;
}
