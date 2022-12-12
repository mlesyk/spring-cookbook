package org.mlesyk.dao.impl;

import org.mlesyk.model.persistencexml.Course;

import javax.persistence.*;
import java.util.List;

public class JpaCourseDaoImpl {

    private EntityManagerFactory entityManagerFactory;

    public JpaCourseDaoImpl() {
        entityManagerFactory = Persistence.createEntityManagerFactory("course");
    }

    public Course store(Course course) {
        EntityManager manager = entityManagerFactory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();
        try {
            tx.begin();
            Course persisted = manager.merge(course);
            tx.commit();
            return persisted;
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        } finally {
            manager.close();
        }
    }

    public void delete(Long courseId) {
        EntityManager manager = entityManagerFactory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();
        try {
            tx.begin();
            Course course = manager.find(Course.class, courseId);
            manager.remove(course);
            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        } finally {
            manager.close();
        }
    }

    public Course findById(Long courseId) {
        EntityManager manager = entityManagerFactory.createEntityManager();
        try {
            return manager.find(Course.class, courseId);
        } finally {
            manager.close();
        }
    }

    public List<Course> findAll() {
        EntityManager manager = entityManagerFactory.createEntityManager();
        try {
            TypedQuery<Course> query = manager.createQuery("select course from Course course", Course.class);
            return query.getResultList();
        } finally {
            manager.close();
        }
    }
}
