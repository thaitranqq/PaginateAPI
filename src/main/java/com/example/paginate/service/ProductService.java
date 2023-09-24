package com.example.paginate.service;

import com.example.paginate.model.Product;
import com.example.paginate.repsonsive.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepo productRepo;
    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
    public List<Product> getAllProducts(){
        return productRepo.findAll().stream().collect(Collectors.toList());
    }
    public List<Product> getProductByPage(Pageable pageable){
        return productRepo.findAll(pageable).getContent();
    }
}
