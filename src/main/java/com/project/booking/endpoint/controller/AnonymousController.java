package com.project.booking.endpoint.controller;

import com.project.booking.endpoint.request.AccountCreateUpdateForm;
import com.project.booking.endpoint.request.PurchaseCreateForm;
import com.project.booking.endpoint.response.AccountInfo;
import com.project.booking.endpoint.response.PurchaseInfo;
import com.project.booking.endpoint.service.AnonymousService;
import com.project.booking.util.RestResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api/anonymous")
public class AnonymousController {
    private final AnonymousService anonymousService;

    public AnonymousController(AnonymousService anonymousService) {
        this.anonymousService = anonymousService;
    }

    /*@PostMapping("/room")
    public RestResponse<RoomInfo> createRoom(@Valid @RequestBody RoomCreateUpdateForm form) {
        RoomInfo dto = anonymousService.createRoom(form);
        return RestResponse.success(dto);
    }*/

    /*@PutMapping("/room/{id}")
    public RestResponse<RoomInfo> updateRoom(@PathVariable UUID id, @Valid @RequestBody RoomCreateUpdateForm form) {
        RoomInfo dto = anonymousService.updateRoom(id, form);
        return RestResponse.success(dto);
    }*/

    /*@DeleteMapping("/room/{id}")
    public RestResponse<RoomInfo> deleteRoom(@PathVariable UUID id) {
        RoomInfo dto = anonymousService.deleteRoom(id);
        return RestResponse.success(dto);
    }*/

    @PostMapping("/purchase")
    public RestResponse<PurchaseInfo> createPurchase(@Valid @RequestBody PurchaseCreateForm form) {
        PurchaseInfo dto = anonymousService.createPurchase(form);
        return RestResponse.success(dto);
    }

    @DeleteMapping("/purchase/{id}")
    public RestResponse<PurchaseInfo> deletePurchase(@PathVariable UUID id) {
        PurchaseInfo dto = anonymousService.deletePurchase(id);
        return RestResponse.success(dto);
    }

    //NOTE: Management
    @GetMapping("/account/{id}")
    public RestResponse<AccountInfo> infoAccount(@PathVariable UUID id) {
        AccountInfo dto = anonymousService.infoAccount(id);
        return RestResponse.success(dto);
    }

    @PutMapping("/account/{id}")
    public RestResponse<AccountInfo> changePassword(@PathVariable UUID id, AccountCreateUpdateForm form) {
        AccountInfo dto = anonymousService.changePassword(id, form);
        return RestResponse.success(dto);
    }

    /*@GetMapping("/room/{id}")
    public RestResponse<RoomInfo> findRoom(@PathVariable UUID id) {
        RoomInfo dto = anonymousService.findRoom(id);
        return RestResponse.success(dto);
    }*/

    /*@GetMapping("/room")
    public RestResponse<List<RoomInfo>> findAllRoom() {
        List<RoomInfo> dto = anonymousService.findAllRoom();
        return RestResponse.success(dto);
    }*/

    @GetMapping("/purchase/{id}")
    public RestResponse<PurchaseInfo> findPurchase(@PathVariable UUID id) {
        PurchaseInfo dto = anonymousService.findPurchase(id);
        return RestResponse.success(dto);
    }

    @GetMapping("/purchase/account/{accountId}")
    public RestResponse<List<PurchaseInfo>> findAllPurchaseByAccountId(@PathVariable UUID accountId) {
        List<PurchaseInfo> dto = anonymousService.findAllPurchaseByAccountId(accountId);
        return RestResponse.success(dto);
    }

    @GetMapping("/purchase")
    public RestResponse<List<PurchaseInfo>> findAllPurchase() {
        List<PurchaseInfo> dto = anonymousService.findAllPurchase();
        return RestResponse.success(dto);
    }
}
