package org.mlesyk.conf;

import com.zaxxer.hikari.HikariDataSource;
import org.mlesyk.dao.VehicleDao;
import org.mlesyk.dao.impl.JdbcTemplateVehicleDaoImpl;
import org.mlesyk.dao.impl.JdbcVehicleDaoImpl;
import org.postgresql.Driver;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

@Configuration
public class AppConfiguration {

    @Bean
    public VehicleDao jdbcVehicleDao(DataSource dataSource) {
        return new JdbcVehicleDaoImpl(dataSource);
    }

    @Bean
    @Primary
    public VehicleDao jdbcTemplateVehicleDao(DataSource dataSource) {
        JdbcTemplateVehicleDaoImpl dao = new JdbcTemplateVehicleDaoImpl();
        dao.setDataSource(dataSource);
        return dao;
    }

    @Bean
    @Primary
    public DataSource pooledDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setUsername("postgres");
        dataSource.setPassword("password");
        dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/vehicle");
        dataSource.setMinimumIdle(2);
        dataSource.setMaximumPoolSize(5);
        return dataSource;
    }

    @Bean
    public DataSource simpleDataSource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(Driver.class);
        dataSource.setUrl("jdbc:postgresql://localhost:5432/vehicle");
        dataSource.setUsername("postgres");
        dataSource.setPassword("password");
        return dataSource;

    }
}
