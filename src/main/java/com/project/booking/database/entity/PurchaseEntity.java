package com.project.booking.database.entity;

import com.project.booking.util.AbstractAuditingEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tbl_purchase")
public class PurchaseEntity extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "check_in")
    private Instant checkIn;

    @Column(name = "check_out")
    private Instant checkOut;

    @Column(name = "total")
    private int total;

    @Column(name = "accountId")
    private UUID accountId;

    /*@OneToOne(fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "room_id")
    private RoomEntity room;*/
}
