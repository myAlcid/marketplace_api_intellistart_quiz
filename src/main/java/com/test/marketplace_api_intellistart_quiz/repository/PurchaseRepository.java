package com.test.marketplace_api_intellistart_quiz.repository;

import com.test.marketplace_api_intellistart_quiz.entity.Product;
import com.test.marketplace_api_intellistart_quiz.entity.Purchase;
import com.test.marketplace_api_intellistart_quiz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    List<Purchase> findAllByUser(User user);

    List<Purchase> findAllByProduct(Product product);

    List<Purchase> findAllByProductAndUser(Product product, User user);
}
