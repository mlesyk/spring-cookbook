package org.mlesyk;

import org.mlesyk.conf.AppConfiguration;
import org.mlesyk.dao.VehicleDao;
import org.mlesyk.model.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static Logger log = LoggerFactory.getLogger("Main");

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
//        runPlainJdbc(context);
        runJdbcTemplate(context);
    }

    public static void runJdbcTemplate(ApplicationContext context) {
        log.info("Start Jdbc template flow");
        VehicleDao vehicleDao = context.getBean(VehicleDao.class);
        vehicleDao.deleteAll();
        Vehicle vehicle1 = new Vehicle("TEM0001", "Red", 4, 4);
        Vehicle vehicle2 = new Vehicle("TEM0002", "Blue", 4, 2);
        Vehicle vehicle3 = new Vehicle("TEM0003", "White", 2, 1);
        vehicleDao.insert(Arrays.asList(vehicle1, vehicle2, vehicle3));
        List<Vehicle> vehicles = vehicleDao.findAll();
        log.info("All vehicles: " + vehicles);
        log.info("Vehicles count: " + vehicleDao.countAll());

        String vehicleBlueColor = vehicleDao.getColor("TEM0002");
        log.info("Color : " + vehicleBlueColor);

        Vehicle vehicle11 = vehicleDao.findByVehicleNo("TEM0001");
        log.info("vehicle1 = " + vehicle11);
    }

    public static void runPlainJdbc(ApplicationContext context) {
        log.info("Start plain Jdbc flow");
        VehicleDao vehicleDao = context.getBean(VehicleDao.class);

        vehicleDao.deleteAll();
        Vehicle vehicle = new Vehicle("TEM0001", "Red", 4, 4);
        vehicleDao.insert(vehicle);

        vehicle = vehicleDao.findByVehicleNo("TEM0001");
        log.info(vehicle.toString());

        vehicle.setColor("Blue");
        vehicle.setSeat(2);
        vehicleDao.update(vehicle);
        vehicle = vehicleDao.findByVehicleNo("TEM0001");
        log.info(vehicle.toString());

        Vehicle vehicle2 = new Vehicle("TEM0002", "White", 2, 1);
        vehicleDao.insert(vehicle2);
        List<Vehicle> vehicles = vehicleDao.findAll();
        log.info(vehicles.toString());

    }
}
