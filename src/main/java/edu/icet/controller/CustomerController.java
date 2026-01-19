package edu.icet.controller;

import edu.icet.model.dto.CustomerDTO;
import edu.icet.model.entity.Customer;
import edu.icet.service.CustomerService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    final CustomerService customerService;

    @PostMapping("/add")
    public String addCustomer(@RequestBody CustomerDTO customerDTO){
        return customerService.addCustomer(customerDTO);
    }


    @GetMapping("/getAll")
    public List<CustomerDTO> getAll(){
        return customerService.getAll();
    }



}
