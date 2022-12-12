package org.mlesyk.dao;

import org.mlesyk.model.Vehicle;

import java.util.Collection;
import java.util.List;

public interface VehicleDao {

    void insert(Vehicle vehicle);

    /*
     * The naive default implemenation is to call the single eleemnt
     * insert method.
     */
    default void insert(Collection<Vehicle> vehicles) {
        vehicles.forEach(this::insert);
    }

    void update(Vehicle vehicle);

    void delete(Vehicle vehicle);

    void deleteAll();

    Vehicle findByVehicleNo(String vehicleNo);

    List<Vehicle> findAll();

    default String getColor(String vehicleNo) {
        throw new IllegalStateException("Method is not implemented!");
    }

    default int countAll() {
        throw new IllegalStateException("Method is not implemented!");
    }


}
