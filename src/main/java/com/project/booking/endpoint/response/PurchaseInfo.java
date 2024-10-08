package com.project.booking.endpoint.response;

import com.project.booking.database.entity.PurchaseEntity;
import com.project.booking.util.AbstractJsonSerializable;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
public class PurchaseInfo extends AbstractJsonSerializable {
    private UUID id;
    private Instant checkIn;
    private Instant checkOut;
    private String roomType;
    private int total;
    private UUID account;
    /*private RoomInfo room;*/

    public static PurchaseInfo from(PurchaseEntity entity) {
        if (entity == null) {
            return null;
        }
        PurchaseInfo info = new PurchaseInfo();
        info.setId(entity.getId());
        info.setCheckIn(entity.getCheckIn());
        info.setCheckOut(entity.getCheckOut());
        info.setRoomType(entity.getRoomType());
        info.setTotal(entity.getTotal());
        info.setAccount(entity.getAccountId());
        /*info.setRoom(RoomInfo.from(entity.getRoom()));*/
        return info;
    }
}
