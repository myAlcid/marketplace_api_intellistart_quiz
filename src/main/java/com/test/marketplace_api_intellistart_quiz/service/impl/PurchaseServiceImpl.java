package com.test.marketplace_api_intellistart_quiz.service.impl;

import com.test.marketplace_api_intellistart_quiz.dto.PurchaseDto;
import com.test.marketplace_api_intellistart_quiz.entity.Product;
import com.test.marketplace_api_intellistart_quiz.entity.Purchase;
import com.test.marketplace_api_intellistart_quiz.entity.User;
import com.test.marketplace_api_intellistart_quiz.exception.DataNotFoundException;
import com.test.marketplace_api_intellistart_quiz.exception.NotEnoughMoneyException;
import com.test.marketplace_api_intellistart_quiz.repository.ProductRepository;
import com.test.marketplace_api_intellistart_quiz.repository.PurchaseRepository;
import com.test.marketplace_api_intellistart_quiz.repository.UserRepository;
import com.test.marketplace_api_intellistart_quiz.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void completePurchase(PurchaseDto purchaseDto) throws DataNotFoundException, NotEnoughMoneyException {
        User user = userRepository.findById(purchaseDto.getUserId())
                .orElseThrow(() -> new DataNotFoundException("User not found"));
        Product product = productRepository.findById(purchaseDto.getProductId())
                .orElseThrow(() -> new DataNotFoundException("Product not found"));

        Double oldAmountOfMoney = user.getAmountOfMoney();
        Double newAmountOfMoney = oldAmountOfMoney - product.getPrice();

        if (newAmountOfMoney < 0) throw new NotEnoughMoneyException("Not enough money");

        user.setAmountOfMoney(newAmountOfMoney);

        Purchase purchase = new Purchase(null, user, product);

        purchaseRepository.save(purchase);
    }

    @Override
    public List<Purchase> getAllByUserId(Long userId) throws DataNotFoundException {
        User user = userRepository.findById(userId).
                orElseThrow(() -> new DataNotFoundException("User not found"));
        return purchaseRepository.findAllByUser(user);
    }

    @Override
    public List<Purchase> getAllByProductId(Long productId) throws DataNotFoundException {
        Product product = productRepository.findById(productId).
                orElseThrow(() -> new DataNotFoundException("Product not found"));
        return purchaseRepository.findAllByProduct(product);
    }

    @Override
    public List<Purchase> getAllByProductIdAndUserId(Long productId, Long userId) throws DataNotFoundException {
        Product product = productRepository.findById(productId).
                orElseThrow(() -> new DataNotFoundException("Product not found"));
        User user = userRepository.findById(userId).
                orElseThrow(() -> new DataNotFoundException("User not found"));
        return purchaseRepository.findAllByProductAndUser(product, user);
    }

    @Override
    public List<Purchase> getAllPurchases() {
        return purchaseRepository.findAll();
    }
}
