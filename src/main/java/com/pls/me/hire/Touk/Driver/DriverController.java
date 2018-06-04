package com.pls.me.hire.Touk.Driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class DriverController {

    @Autowired
    private DriverServiceImplementation driverService;

    @RequestMapping("/{driverId}") // Get driver details such as user type and Name
    public Driver getDriverById(@PathVariable long driverId){
        return driverService.getDriverById(driverId);
    }

    @RequestMapping("/drivers") // get all drivers
    public List<Driver> getDrivers(){
        return driverService.getDrivers();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/driver") // Create new driver
    public void addDriver(@RequestBody Driver driver){
        driverService.addDriver(driver);
    }

}
