package com.project.booking.database.constant;

import com.project.booking.util.EnumDescription;
import lombok.Getter;

@Getter
public enum SecurityRole implements EnumDescription {
    SYSTEM, ADMIN, USER, ANONYMOUS;
}
