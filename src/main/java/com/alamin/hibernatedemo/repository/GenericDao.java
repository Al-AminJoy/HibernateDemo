package com.alamin.hibernatedemo.repository;

import com.alamin.hibernatedemo.model.Product;
import com.alamin.hibernatedemo.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public interface GenericDao<TYPE,ID> {
    List<TYPE> readAll();
    TYPE findByID(ID id);
    TYPE save(TYPE type);
    TYPE update(TYPE type);
    void delete(ID id);
}
