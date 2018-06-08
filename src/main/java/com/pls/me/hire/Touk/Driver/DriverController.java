package com.pls.me.hire.Touk.Driver;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class DriverController {

    @Autowired
    private DriverServiceImplementation driverService;

    @RequestMapping(value = "/driver/{driverId}", method = RequestMethod.GET)
    @ApiOperation("Returns driver's details")
    public Driver getDriverById(@ApiParam("ID of the driver to be obtained") @PathVariable long driverId){
        return driverService.getDriverById(driverId);
    }

    @RequestMapping(value = "/drivers", method = RequestMethod.GET)
    @ApiOperation("Returns all drivers")
    public List<Driver> getDrivers(){
        return driverService.getDrivers();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/driver")
    @ApiOperation("Creates new driver")
    public void addDriver(@ApiParam("Details of the driver to be created")@RequestBody Driver driver){
        driverService.addDriver(driver);
    }

}
