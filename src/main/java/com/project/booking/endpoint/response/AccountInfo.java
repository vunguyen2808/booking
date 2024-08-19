package com.project.booking.endpoint.response;

import com.project.booking.database.entity.AccountEntity;
import com.project.booking.util.AbstractJsonSerializable;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AccountInfo extends AbstractJsonSerializable {
    private UUID id;
    private String login;
    private String email;
    private String name;

    public static AccountInfo from(AccountEntity entity) {
        if (entity == null) {
            return null;
        }
        AccountInfo info = new AccountInfo();
        info.setId(entity.getId());
        info.setLogin(entity.getLogin());
        info.setEmail(entity.getEmail());
        info.setName(entity.getName());
        return info;
    }
}
