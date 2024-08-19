/*
package com.project.booking.database.entity;

import com.project.booking.database.constant.RoomType;
import com.project.booking.util.AbstractAuditingEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tbl_room")
public class RoomEntity extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price")
    private int price;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", length = 50, nullable = false)
    private RoomType type;

    @Column(name = "image")
    private String image;
}
*/
