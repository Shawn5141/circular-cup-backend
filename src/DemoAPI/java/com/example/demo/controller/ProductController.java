package com.example.demo.controller;

import com.example.demo.Product;
import com.example.demo.ProductQueryParameter;
import com.example.demo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping (value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)

public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") String id){
        Product product = productService.getProduct(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product request) {
        Product product = productService.createProduct(request);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(product.getId())
                .toUri();

        return ResponseEntity.created(location).body(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> replaceProduct(
            @PathVariable("id") String id, @RequestBody Product request) {
        Product product = productService.replaceProduct(id, request);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") String id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping
    //Search items
    public ResponseEntity<List<Product>> getProducts(@ModelAttribute ProductQueryParameter param) {
        List<Product> products = productService.getProducts(param);
        return ResponseEntity.ok(products);
    }
}
