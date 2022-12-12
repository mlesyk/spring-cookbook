package org.mlesyk.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.mlesyk.model.Course;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("courseDao")
public class HibernateTransactionalCourseDao {

    private final SessionFactory sessionFactory;

    public HibernateTransactionalCourseDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public Course store(Course course) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(course);
        return course;
    }

    @Transactional
    public void delete(Long courseId) {
        Session session = sessionFactory.getCurrentSession();
        Course course = session.get(Course.class, courseId);
        session.delete(course);
    }

    @Transactional(readOnly = true)
    public Course findById(Long courseId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Course.class, courseId);
    }

    @Transactional(readOnly = true)
    public List<Course> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Course", Course.class).list();
    }

}