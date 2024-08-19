/*
package com.project.booking.endpoint.response;

import com.project.booking.database.constant.RoomType;
import com.project.booking.database.entity.RoomEntity;
import com.project.booking.util.AbstractJsonSerializable;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class RoomInfo extends AbstractJsonSerializable {
    private UUID id;
    private String name;
    private int price;
    private RoomType type;
    private String image;

    public static RoomInfo from(RoomEntity entity) {
        if (entity == null) {
            return null;
        }
        RoomInfo info = new RoomInfo();
        info.setId(entity.getId());
        info.setName(entity.getName());
        info.setPrice(entity.getPrice());
        info.setType(entity.getType());
        info.setImage(entity.getImage());
        return info;
    }
}
*/
