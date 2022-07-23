package com.test.marketplace_api_intellistart_quiz.controller;

import com.test.marketplace_api_intellistart_quiz.entity.Product;
import com.test.marketplace_api_intellistart_quiz.exception.DataNotFoundException;
import com.test.marketplace_api_intellistart_quiz.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public ResponseEntity<List<Product>> getAllProducts() throws DataNotFoundException {
        return ResponseEntity.ok().body(productService.getAll());
    }

    @PostMapping("")
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        productService.addProduct(product);
        String successfullyAddingProductMessage = "You successfully added product";
        return new ResponseEntity<>(successfullyAddingProductMessage, HttpStatus.CREATED);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable(value = "productId") Long productId) throws DataNotFoundException {
        productService.deleteProduct(productId);
        String successfullyDeletingProductMessage = "You successfully deleted product";
        return ResponseEntity.ok().body(successfullyDeletingProductMessage);
    }

}
