package com.project.booking.database.entity;

import com.project.booking.util.AbstractAuditingEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tbl_account")
public class AccountEntity extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    /*@Enumerated(EnumType.STRING)
    @Column(name = "role", length = 50, nullable = false)
    private SecurityRole role;*/

    /*@Enumerated(EnumType.STRING)
    @Column(name = "status", length = 50, nullable = false)
    private ActiveStatus status;*/
}
