package edu.icet.controller;

import edu.icet.model.dto.CustomerDTO;
import edu.icet.model.dto.DriverDTO;
import edu.icet.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


public class DriverController {

    @Autowired
    DriverService driverService = new DriverService();

    @PostMapping("/add")
    public String addCustomer(@RequestBody DriverDTO driverDTO){
        return driverService.addDriver(driverDTO);
    }

}
