package com.project.booking.endpoint.request;

import com.project.booking.database.constant.RoomType;
import com.project.booking.util.AbstractJsonSerializable;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RoomCreateUpdateForm extends AbstractJsonSerializable {
    @NotBlank
    private String name;

    @Min(0)
    private int price;

    @NotNull
    private RoomType type;

    private String image;
}
