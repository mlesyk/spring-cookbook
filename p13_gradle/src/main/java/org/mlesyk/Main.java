package org.mlesyk;

import org.mlesyk.conf.AppConfiguration;
import org.mlesyk.dao.CourseDao;
import org.mlesyk.dao.HibernateCourseDao;
import org.mlesyk.dao.HibernateTransactionalCourseDao;
import org.mlesyk.dao.JpaCourseDao;
import org.mlesyk.model.Course;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) {
//        runHibernateSpringFlow();
        runJPASpringFlow();
    }

    public static void runJPASpringFlow() {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        JpaCourseDao courseDao = (JpaCourseDao)context.getBean(CourseDao.class);

        Course course = new Course();
        course.setTitle("Core Spring");
        course.setBeginDate(new GregorianCalendar(2007, 8, 1).getTime());
        course.setEndDate(new GregorianCalendar(2007, 9, 1).getTime());
        course.setFee(1000);

        System.out.println("\nCourse before persisting");
        System.out.println(course);

        Course persisted = courseDao.store(course);

        System.out.println("\nCourse after persisting");
        System.out.println(persisted);

        Long courseId = persisted.getId();
        Course courseFromDb = courseDao.findById(courseId);

        System.out.println("\nCourse fresh from database");
        System.out.println(courseFromDb);

        courseDao.delete(courseId);

        ((ConfigurableApplicationContext) context).stop();
    }

    public static void runHibernateSpringFlow() {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        HibernateCourseDao courseDao = (HibernateCourseDao) context.getBean(CourseDao.class);

        Course course = new Course();
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
        Course courseFromDb = courseDao.findById(courseId);

        System.out.println("\nCourse fresh from database");
        System.out.println(courseFromDb);

        courseDao.delete(courseId);

        ((ConfigurableApplicationContext) context).stop();


    }
}
