package org.mlesyk.dao.impl;

import org.mlesyk.dao.VehicleDao;
import org.mlesyk.model.Vehicle;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JdbcTemplateVehicleDaoImpl extends JdbcDaoSupport implements VehicleDao {

    private static final String INSERT_SQL = "INSERT INTO VEHICLE (COLOR, WHEEL, SEAT, VEHICLE_NO) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_SQL = "UPDATE VEHICLE SET COLOR=?,WHEEL=?,SEAT=? WHERE VEHICLE_NO=?";
    private static final String SELECT_ALL_SQL = "SELECT * FROM VEHICLE";
    private static final String SELECT_ONE_SQL = "SELECT * FROM VEHICLE WHERE VEHICLE_NO = ?";
    private static final String SELECT_COLOR_SQL = "SELECT COLOR FROM VEHICLE WHERE VEHICLE_NO = ?";
    private static final String COUNT_ALL_SQL = "SELECT COUNT(*) FROM VEHICLE";
    private static final String DELETE_SQL = "DELETE FROM VEHICLE WHERE VEHICLE_NO=?";
    private static final String DELETE_ALL_SQL = "DELETE FROM VEHICLE";

    @Override
    public void insert(Vehicle vehicle) {
        getJdbcTemplate().update(INSERT_SQL, ps -> {
            prepareStatement(ps, vehicle);
        });
    }

    @Override
    public void insert(Collection<Vehicle> vehicles) {
        getJdbcTemplate().batchUpdate(INSERT_SQL, vehicles, vehicles.size(), this::prepareStatement);
    }

    @Override
    public void update(Vehicle vehicle) {

    }

    @Override
    public void delete(Vehicle vehicle) {

    }

    @Override
    public void deleteAll() {
        getJdbcTemplate().update(DELETE_ALL_SQL);
    }

    @Override
    public Vehicle findByVehicleNo(String vehicleNo) {
        return getJdbcTemplate().queryForObject(SELECT_ONE_SQL, new VehicleRowMapper(), vehicleNo);
    }

    @Override
    public List<Vehicle> findAll() {
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(SELECT_ALL_SQL);
        return rows.stream().map(row -> {
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleNo((String) row.get("VEHICLE_NO"));
            vehicle.setColor((String) row.get("COLOR"));
            vehicle.setWheel((Integer) row.get("WHEEL"));
            vehicle.setSeat((Integer) row.get("SEAT"));
            return vehicle;
        }).collect(Collectors.toList());
    }

    @Override
    public String getColor(String vehicleNo) {
        return getJdbcTemplate().queryForObject(SELECT_COLOR_SQL, String.class, vehicleNo);
    }

    @Override
    public int countAll() {
        return getJdbcTemplate().queryForObject(COUNT_ALL_SQL, Integer.class);
    }

    private void prepareStatement(PreparedStatement ps, Vehicle vehicle) throws SQLException {
        ps.setString(1, vehicle.getColor());
        ps.setInt(2, vehicle.getWheel());
        ps.setInt(3, vehicle.getSeat());
        ps.setString(4, vehicle.getVehicleNo());
    }

    private Vehicle toVehicle(ResultSet rs) throws SQLException {
        return new Vehicle(rs.getString("VEHICLE_NO"),
                rs.getString("COLOR"), rs.getInt("WHEEL"),
                rs.getInt("SEAT"));
    }

    private class VehicleRowMapper implements RowMapper<Vehicle> {
        @Override
        public Vehicle mapRow(ResultSet rs, int rowNum) throws SQLException {
            return toVehicle(rs);
        }
    }
}
