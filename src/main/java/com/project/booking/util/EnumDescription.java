package com.project.booking.util;

public interface EnumDescription {
    default String getDescription(){
        return this.getClass().getSimpleName() + "." + this.name() + ".description";
    }

    String name();
}
