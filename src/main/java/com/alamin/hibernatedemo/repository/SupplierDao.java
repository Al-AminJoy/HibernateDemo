package com.alamin.hibernatedemo.repository;

import com.alamin.hibernatedemo.model.Product;
import com.alamin.hibernatedemo.model.Supplier;

import java.util.List;

public interface SupplierDao {
    public List<Supplier> allSupplier();
    public Supplier save(Supplier supplier);
}
