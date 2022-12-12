package org.mlesyk.conf;

import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.dialect.PostgreSQL95Dialect;
import org.mlesyk.dao.CourseDao;
import org.mlesyk.dao.HibernateCourseDao;
import org.mlesyk.dao.JpaCourseDao;
import org.mlesyk.model.Course;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import javax.persistence.EntityManagerFactory;
import java.util.Properties;

@Configuration
public class AppConfiguration {

    @Bean
    public CourseDao hibernateCourseDao(SessionFactory sessionFactory) {
        return new HibernateCourseDao(sessionFactory);
    }


    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setHibernateProperties(hibernateProperties());
        sessionFactoryBean.setAnnotatedClasses(Course.class);
        return sessionFactoryBean;
    }

    private Properties hibernateProperties() {

        Properties properties = new Properties();
        properties.setProperty(AvailableSettings.URL, "jdbc:postgresql://localhost:5432/course");
        properties.setProperty(AvailableSettings.USER, "postgres");
        properties.setProperty(AvailableSettings.PASS, "password");
        properties.setProperty(AvailableSettings.DIALECT, PostgreSQL95Dialect.class.getName());
        properties.setProperty(AvailableSettings.SHOW_SQL, String.valueOf(true));
        properties.setProperty(AvailableSettings.HBM2DDL_AUTO, "update");
        return properties;
    }


    @Bean
    @Primary
    public CourseDao jpaCourseDao(EntityManagerFactory entityManagerFactory) {
        return new JpaCourseDao(entityManagerFactory);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {

        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource);
        emf.setPackagesToScan("org.mlesyk.model");
        emf.setJpaVendorAdapter(jpaVendorAdapter());
        return emf;
    }

    private JpaVendorAdapter jpaVendorAdapter() {

        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setShowSql(true);
        jpaVendorAdapter.setGenerateDdl(true);
        jpaVendorAdapter.setDatabasePlatform(PostgreSQL95Dialect.class.getName());
        return jpaVendorAdapter;
    }


    @Bean
    public DataSource dataSource() {

        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setUsername("postgres");
        dataSource.setPassword("password");
        dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/course");
        dataSource.setMinimumIdle(2);
        dataSource.setMaximumPoolSize(5);
        return dataSource;
    }
}
