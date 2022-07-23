package com.test.marketplace_api_intellistart_quiz.service.impl;

import com.test.marketplace_api_intellistart_quiz.entity.Product;
import com.test.marketplace_api_intellistart_quiz.exception.DataNotFoundException;
import com.test.marketplace_api_intellistart_quiz.repository.ProductRepository;
import com.test.marketplace_api_intellistart_quiz.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAll() throws DataNotFoundException {
        List<Product> allProducts = productRepository.findAll();

        if (allProducts.size() == 0) {
            throw new DataNotFoundException("Products not found");
        }
        return allProducts;
    }

    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) throws DataNotFoundException {
        Product product = productRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Product not found"));
        productRepository.delete(product);
    }
}
