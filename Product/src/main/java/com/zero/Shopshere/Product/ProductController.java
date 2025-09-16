package com.zero.Shopshere.Product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService service;
    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<Product> getProducts() {
        return service.getAllProducts();
    }

    @GetMapping("/test")
    public String test() {
        log.info("testing logzz");
        return "Welcome world!";
    }
    @GetMapping("/testError")
    public String testError() {
        log.error("testing logzz,error!");
        return "Welcome world!Error";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody Product product) {
        return service.createProduct(product);
    }
}
