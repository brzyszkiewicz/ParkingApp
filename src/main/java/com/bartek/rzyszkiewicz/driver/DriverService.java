package com.bartek.rzyszkiewicz.driver;


import java.util.List;

public interface DriverService {

    public Driver getDriverById(long id);
    public void addDriver(Driver driver);
    public List<Driver> getDrivers();

}
