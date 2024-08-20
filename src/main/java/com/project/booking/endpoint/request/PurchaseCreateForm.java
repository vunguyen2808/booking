package com.project.booking.endpoint.request;

import com.project.booking.util.AbstractJsonSerializable;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Builder
public class PurchaseCreateForm extends AbstractJsonSerializable {
    @NotNull
    private String checkIn;

    @NotNull
    private String checkOut;

    @NotNull
    private int total;

    @NotNull
    private UUID accountId;
}
