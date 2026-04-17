package edu.icet.controller;

import edu.icet.model.dto.CustomerDTO;
import edu.icet.model.dto.DriverDTO;
import edu.icet.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/driver")
public class DriverController {

    final DriverService driverService;

    @PostMapping("/add")
    public String addCustomer(@RequestBody DriverDTO driverDTO){
        return driverService.addDriver(driverDTO);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDriver(@PathVariable("id") String id){
        return driverService.deleteDriver(id);
    }

    @GetMapping("/getAll")
    public List<DriverDTO> getAllDrivers(){
        return driverService.getAllDrivers();
    }




}
