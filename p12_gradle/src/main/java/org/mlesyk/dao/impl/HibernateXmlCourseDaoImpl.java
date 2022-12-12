package org.mlesyk.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.dialect.PostgreSQL95Dialect;
import org.mlesyk.model.xml.Course;

import java.util.List;

public class HibernateXmlCourseDaoImpl {

    private final SessionFactory sessionFactory;

    public HibernateXmlCourseDaoImpl() {

        Configuration configuration = new Configuration()
                .setProperty(AvailableSettings.URL, "jdbc:postgresql://localhost:5432/course")
                .setProperty(AvailableSettings.USER, "postgres")
                .setProperty(AvailableSettings.PASS, "password")
                .setProperty(AvailableSettings.DIALECT, PostgreSQL95Dialect.class.getName())
                .setProperty(AvailableSettings.SHOW_SQL, String.valueOf(true))
                .setProperty(AvailableSettings.HBM2DDL_AUTO, "update")
                .addClass(Course.class);
        sessionFactory = configuration.buildSessionFactory();
    }

    public Course store(Course course) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.getTransaction();
        try {
            tx.begin();
            session.saveOrUpdate(course);
            tx.commit();
            return course;
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }

    }

    public void delete(Long courseId) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.getTransaction();
        try {
            tx.begin();
            Course course = session.get(Course.class, courseId);
            session.delete(course);
            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public Course findById(Long courseId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Course.class, courseId);
        }
    }

    public List<Course> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("SELECT c FROM Course c", Course.class).list();
        }
    }
}
