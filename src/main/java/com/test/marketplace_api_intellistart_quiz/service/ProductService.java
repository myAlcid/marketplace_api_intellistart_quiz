package com.test.marketplace_api_intellistart_quiz.service;

import com.test.marketplace_api_intellistart_quiz.entity.Product;
import com.test.marketplace_api_intellistart_quiz.exception.DataNotFoundException;

import java.util.List;

public interface ProductService {

    List<Product> getAll() throws DataNotFoundException;

    void addProduct(Product product);

    void deleteProduct(Long id) throws DataNotFoundException;
}
