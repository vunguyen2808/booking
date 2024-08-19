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
    private int total;
    private AccountInfo account;
    /*private RoomInfo room;*/

    public static PurchaseInfo from(PurchaseEntity entity) {
        if (entity == null) {
            return null;
        }
        PurchaseInfo info = new PurchaseInfo();
        info.setId(entity.getId());
        info.setCheckIn(entity.getCheckIn());
        info.setCheckOut(entity.getCheckOut());
        info.setTotal(entity.getTotal());
        info.setAccount(AccountInfo.from(entity.getAccount()));
        /*info.setRoom(RoomInfo.from(entity.getRoom()));*/
        return info;
    }
}
