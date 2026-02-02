package edu.icet.controller;

import edu.icet.model.dto.DriverDTO;
import edu.icet.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/driver")
public class DriverController {

    final DriverService driverService;

    @PostMapping("/add")
    public String addCustomer(@RequestBody DriverDTO driverDTO){
        return driverService.addDriver(driverDTO);
    }

    @GetMapping("/delete/{id}")
    public String deleteDriver(@PathVariable("id") String id){
        return driverService.deleteDriver(id);
    }


}
