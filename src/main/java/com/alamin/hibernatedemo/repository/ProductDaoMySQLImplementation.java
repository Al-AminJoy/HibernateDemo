package com.alamin.hibernatedemo.repository;

import com.alamin.hibernatedemo.model.Product;
import com.alamin.hibernatedemo.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class ProductDaoMySQLImplementation implements ProductDao{

    @Override
    public List<Product> allProduct() {
        Session session= HibernateUtil.getSessionFactory().openSession();
        Query query=session.createQuery("From Product", Product.class);
        List<Product> result=query.getResultList();
        return result;
    }

    @Override
    public Product save(Product product) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(product);
        session.getTransaction().commit();
        return product;
    }
}
