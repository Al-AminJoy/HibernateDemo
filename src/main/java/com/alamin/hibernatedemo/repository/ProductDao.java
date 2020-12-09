package com.alamin.hibernatedemo.repository;

import com.alamin.hibernatedemo.model.Product;

import java.util.List;

public interface ProductDao {
    public List<Product> allProduct();
    public Product save(Product product);

}
