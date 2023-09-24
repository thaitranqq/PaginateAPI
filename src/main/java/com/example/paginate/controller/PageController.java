package com.example.paginate.controller;

import com.example.paginate.model.PageRequest;
import com.example.paginate.model.Product;
import com.example.paginate.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/page")
public class PageController {
    private final ProductService productService;
    @Autowired
    public PageController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProductByPage(@RequestParam("limit") int limit,
                                          @RequestParam("offset") int offset){
        Pageable pageable = new PageRequest(limit,offset);
        return productService.getProductByPage(pageable);
    }
}
