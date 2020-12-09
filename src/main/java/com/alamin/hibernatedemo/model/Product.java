package com.alamin.hibernatedemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    private long id;
    private String name;
    private double pricePerUnit;
    private double unitInStock;
    private boolean discontinued;
    @ManyToMany
    private List<Supplier> supplierList;

}
