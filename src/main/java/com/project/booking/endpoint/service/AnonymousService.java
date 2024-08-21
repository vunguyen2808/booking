package com.project.booking.endpoint.service;

import com.project.booking.database.entity.AccountEntity;
import com.project.booking.database.entity.PurchaseEntity;
import com.project.booking.database.service.AccountEntityService;
import com.project.booking.database.service.PurchaseEntityService;
import com.project.booking.endpoint.request.AccountPwUpdateForm;
import com.project.booking.endpoint.request.PurchaseCreateForm;
import com.project.booking.endpoint.response.AccountInfo;
import com.project.booking.endpoint.response.PurchaseInfo;
import com.project.booking.util.RestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class AnonymousService {
    private final AccountEntityService accountEntityService;
    private final PurchaseEntityService purchaseEntityService;

    public AnonymousService(AccountEntityService accountEntityService, PurchaseEntityService purchaseEntityService) {
        this.accountEntityService = accountEntityService;
        this.purchaseEntityService = purchaseEntityService;
    }

    //NOTE: Account
    public AccountInfo infoAccount(UUID id) {
        AccountEntity entity = accountEntityService.findById(id)
                .orElseThrow(() -> RestException.badRequest("Account not found"));
        return AccountInfo.from(entity);
    }

    public AccountInfo changePassword(UUID id, AccountPwUpdateForm form) {
        AccountEntity entity = accountEntityService.update(id, form);
        return AccountInfo.from(entity);
    }

    //NOTE: Room
    /*public RoomInfo createRoom(RoomCreateUpdateForm form) {
        RoomEntity entity = roomEntityService.create(form);
        return RoomInfo.from(entity);
    }*/

    /*public RoomInfo updateRoom(UUID id, RoomCreateUpdateForm form) {
        RoomEntity entity = roomEntityService.update(id, form);
        return RoomInfo.from(entity);
    }*/

    /*public RoomInfo deleteRoom(UUID id) {
        RoomEntity entity = roomEntityService.delete(id);
        return RoomInfo.from(entity);
    }*/

    //NOTE: Purchase
    public PurchaseInfo createPurchase(PurchaseCreateForm form) {
        PurchaseEntity entity = purchaseEntityService.create(form);
        return PurchaseInfo.from(entity);
    }

    public PurchaseInfo deletePurchase(UUID id) {
        PurchaseEntity entity = purchaseEntityService.delete(id);
        return PurchaseInfo.from(entity);
    }

    //NOTE: List
    /*public RoomInfo findRoom(UUID id) {
        RoomEntity entity = roomEntityService.findById(id)
                .orElseThrow(() -> RestException.badRequest("Room not found"));
        return RoomInfo.from(entity);
    }*/

    /*public List<RoomInfo> findAllRoom() {
        List<RoomEntity> list = roomEntityService.findAll();
        return list.stream().map(RoomInfo::from).toList();
    }*/

    public PurchaseInfo findPurchase(UUID id) {
        PurchaseEntity entity = purchaseEntityService.findById(id)
                .orElseThrow(() -> RestException.badRequest("Purchase not found"));
        return PurchaseInfo.from(entity);
    }

    public List<PurchaseInfo> findAllPurchaseByAccountId(UUID id) {
        List<PurchaseEntity> list = purchaseEntityService.findAllPurchaseByAccountId(id);
        return list.stream().map(PurchaseInfo::from).toList();
    }

    public List<PurchaseInfo> findAllPurchase() {
        List<PurchaseEntity> list = purchaseEntityService.findAll();
        return list.stream().map(PurchaseInfo::from).toList();
    }
}
