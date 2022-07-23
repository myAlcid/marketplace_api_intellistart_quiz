package com.test.marketplace_api_intellistart_quiz.service;

import com.test.marketplace_api_intellistart_quiz.dto.PurchaseDto;
import com.test.marketplace_api_intellistart_quiz.entity.Purchase;

import java.util.List;

public interface PurchaseService {

    void completePurchase(PurchaseDto purchaseDto) throws Exception;

    List<Purchase> getAllByUserId(Long userId) throws Exception;

    List<Purchase> getAllByProductId(Long productId) throws Exception;

    List<Purchase> getAllByProductIdAndUserId(Long productId, Long userId) throws Exception;

    List<Purchase> getAllPurchases();

}
