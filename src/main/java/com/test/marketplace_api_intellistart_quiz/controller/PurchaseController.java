package com.test.marketplace_api_intellistart_quiz.controller;

import com.test.marketplace_api_intellistart_quiz.dto.PurchaseDto;
import com.test.marketplace_api_intellistart_quiz.entity.Purchase;
import com.test.marketplace_api_intellistart_quiz.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping("")
    public ResponseEntity<String> buyProduct(@RequestBody PurchaseDto purchaseDto) throws Exception {
        purchaseService.completePurchase(purchaseDto);
        String successfullyPurchaseMessage = "You successfully bought product";
        return new ResponseEntity<>(successfullyPurchaseMessage, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<Purchase>> getPurchases(@RequestParam(value = "productId") Optional<Long> productId,
                                                       @RequestParam(value = "userId") Optional<Long> userId) throws Exception {

        if (productId.isPresent() && userId.isPresent())
            return ResponseEntity.ok().body(purchaseService.getAllByProductIdAndUserId(productId.get(), userId.get()));
        if (productId.isPresent())
            return ResponseEntity.ok().body(purchaseService.getAllByProductId(productId.get()));
        if (userId.isPresent())
            return ResponseEntity.ok().body(purchaseService.getAllByUserId(userId.get()));

        return ResponseEntity.ok().body(purchaseService.getAllPurchases());
    }


}
