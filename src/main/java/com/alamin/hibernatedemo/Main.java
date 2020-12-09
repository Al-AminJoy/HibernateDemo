package com.alamin.hibernatedemo;

import com.alamin.hibernatedemo.model.Product;
import com.alamin.hibernatedemo.model.Supplier;
import com.alamin.hibernatedemo.repository.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public Main() {
        Supplier supplier1=new Supplier(9,"Al-Amin","Khatamari");
        Supplier supplier2=new Supplier(8,"Joy","Nikunja");

        //SupplierDao supplierDao=new SupplierDaoMySQLImplementation();
       // supplierDao.save(supplier1);
       // supplierDao.save(supplier2);
       // List<Supplier> supplierList=supplierDao.allSupplier();
      //  supplierList.stream().forEach(System.out::println);
        GenericDao<Supplier,Integer> genericDao=new GenericDaoSQLImplementation<>(Supplier.class);
        genericDao.save(supplier1);
        genericDao.save(supplier2);
         List<Supplier> supplierList=genericDao.readAll();
          supplierList.stream().forEach(System.out::println);


        Product product1 = new Product(1, "One Plus", 50_000, 5,false,supplierList);
        Product product2 = new Product(35, "Casio", 20_000, 3,true,supplierList);
        //ProductDao productDao=new ProductDaoMySQLImplementation();
       // productDao.save(product);
        //productDao.save(product1);
       // List<Product> productList=productDao.allProduct();
       // productList.stream().forEach(System.out::println);
        GenericDao<Product,Long> productLongGenericDao=new GenericDaoSQLImplementation<>(Product.class);
        productLongGenericDao.save(product1);
        productLongGenericDao.save(product2);
         List<Product> productList=productLongGenericDao.readAll();
         productList.stream().forEach(System.out::println);
        System.out.println("Finding Single Product : ");
        Product product= productLongGenericDao.findByID(35L);
        System.out.println(product);
        System.out.println("Finding Updated Product : ");
        Product updatedProduct= productLongGenericDao.update(new Product(35, "One Plus", 60_000, 5,false,null));
        System.out.println(updatedProduct);
        System.out.println("Deleting Product : ");
        productLongGenericDao.delete(1L);



    }

    public static void main(String args[]) {
        new Main();
    }
}
