package org.mlesyk;

import org.mlesyk.dao.impl.HibernateAnnotatedCourseDaoImpl;
import org.mlesyk.dao.impl.HibernateXmlCourseDaoImpl;
import org.mlesyk.dao.impl.JpaCourseDaoImpl;

import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) {
        runJPAFlow();
//        runAnnotatedHibernateFlow();
//        runXmlHibernateFlow();

    }

    public static void runXmlHibernateFlow() {
        HibernateXmlCourseDaoImpl courseDao = new HibernateXmlCourseDaoImpl();

        org.mlesyk.model.xml.Course course = new org.mlesyk.model.xml.Course();
        course.setTitle("Core Spring");
        course.setBeginDate(new GregorianCalendar(2007, 8, 1).getTime());
        course.setEndDate(new GregorianCalendar(2007, 9, 1).getTime());
        course.setFee(1000);

        System.out.println("\nCourse before persisting");
        System.out.println(course);

        courseDao.store(course);

        System.out.println("\nCourse after persisting");
        System.out.println(course);

        Long courseId = course.getId();
        org.mlesyk.model.xml.Course courseFromDb = courseDao.findById(courseId);

        System.out.println("\nCourse fresh from database");
        System.out.println(courseFromDb);

        courseDao.delete(courseId);

        System.exit(0);
    }

    public static void runAnnotatedHibernateFlow() {
        HibernateAnnotatedCourseDaoImpl courseDao = new HibernateAnnotatedCourseDaoImpl();

        org.mlesyk.model.annotated.Course course = new org.mlesyk.model.annotated.Course();
        course.setTitle("Core Spring");
        course.setBeginDate(new GregorianCalendar(2007, 8, 1).getTime());
        course.setEndDate(new GregorianCalendar(2007, 9, 1).getTime());
        course.setFee(1000);

        System.out.println("\nCourse before persisting");
        System.out.println(course);

        courseDao.store(course);

        System.out.println("\nCourse after persisting");
        System.out.println(course);

        Long courseId = course.getId();
        org.mlesyk.model.annotated.Course courseFromDb = courseDao.findById(courseId);

        System.out.println("\nCourse fresh from database");
        System.out.println(courseFromDb);

        courseDao.delete(courseId);

        System.exit(0);
    }

    public static void runJPAFlow() {
        JpaCourseDaoImpl courseDao = new JpaCourseDaoImpl();

        org.mlesyk.model.persistencexml.Course course = new org.mlesyk.model.persistencexml.Course();
        course.setTitle("Core Spring");
        course.setBeginDate(new GregorianCalendar(2007, 8, 1).getTime());
        course.setEndDate(new GregorianCalendar(2007, 9, 1).getTime());
        course.setFee(1000);

        System.out.println("\nCourse before persisting");
        System.out.println(course);

        org.mlesyk.model.persistencexml.Course persisted = courseDao.store(course);

        System.out.println("\nCourse after persisting");
        System.out.println(persisted);

        Long courseId = persisted.getId();
        org.mlesyk.model.persistencexml.Course courseFromDb = courseDao.findById(courseId);

        System.out.println("\nCourse fresh from database");
        System.out.println(courseFromDb);

        courseDao.delete(courseId);

        System.exit(0);
    }
}
