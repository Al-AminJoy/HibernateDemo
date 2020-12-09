package com.alamin.hibernatedemo.repository;

import com.alamin.hibernatedemo.model.Product;
import com.alamin.hibernatedemo.model.Supplier;
import com.alamin.hibernatedemo.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class SupplierDaoMySQLImplementation implements SupplierDao{

    @Override
    public List<Supplier> allSupplier() {
        Session session= HibernateUtil.getSessionFactory().openSession();
        Query query=session.createQuery("From Supplier", Supplier.class);
        List<Supplier> result=query.getResultList();
        return result;
    }

    @Override
    public Supplier save(Supplier supplier) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(supplier);
        session.getTransaction().commit();
        return supplier;
    }
}
