package com.alamin.hibernatedemo.repository;

import com.alamin.hibernatedemo.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;

public class GenericDaoSQLImplementation<TYPE,ID> implements GenericDao<TYPE,ID> {
    private Class<TYPE> aClass;

    public GenericDaoSQLImplementation(Class<TYPE> aClass) {
        this.aClass = aClass;
    }

    @Override
    public List<TYPE> readAll() {
        Session session= HibernateUtil.getSessionFactory().openSession();
        Query query=session.createQuery("From "+aClass.getSimpleName(), aClass);
         List<TYPE> result=query.getResultList();
        return result;
    }

    @Override
    public TYPE findByID(ID id) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        TYPE type=(TYPE) session.load(aClass, (Serializable) id);

        return  type;
    }

    @Override
    public TYPE save(TYPE type) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(type);
        session.getTransaction().commit();
        return type;
    }

    @Override
    public TYPE update(TYPE type) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.update(type);
        return type;
    }

    @Override
    public void delete(ID id) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        TYPE type=(TYPE) session.load(aClass, (Serializable) id);

        if(type!=null){
            session.beginTransaction();
            session.delete(type);
            session.getTransaction().commit();
            //System.out.println(type);
        }
    }
}
