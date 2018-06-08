package com.pls.me.hire.Touk.Driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DriverServiceImplementation implements DriverService {

    @Autowired
    private DriverRepository driverRepository;

    public Driver getDriverById(long id) {
        return driverRepository.getOne(id);
    }

    public void addDriver(Driver driver) {
        driverRepository.save(driver);
    }

    public List<Driver> getDrivers() {
        return driverRepository.findAll();
    }
}
