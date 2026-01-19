package edu.icet.service;

import edu.icet.model.dto.CustomerDTO;
import edu.icet.model.entity.Customer;
import edu.icet.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    final CustomerRepository customerRepository;
    final ModelMapper modelMapper;

    public String addCustomer(CustomerDTO customerDTO) {
        Customer customer = modelMapper.map(customerDTO, Customer.class);
        customer.setCustomerId(genarateId());
        customerRepository.save(customer);
        return "Customer saved successfully";
    }

    private String genarateId() {
        List<Customer> customers = customerRepository.findAll();
        String genarateId = "C001";
        int genId = 1;
        for (Customer customer : customers){
            if (customer.getCustomerId().equals(genarateId)){
                genId++;
                genarateId = String.format("C%03d",genId);
            }else{
                break;
            }
        }
        return genarateId;
    }


    public List<CustomerDTO> getAll() {
        List<Customer> all = customerRepository.findAll();
        ArrayList<CustomerDTO> customerDTOS = new ArrayList<>();

        for (Customer customer : all){
            CustomerDTO customerDTO = modelMapper.map(customer,CustomerDTO.class);
            customerDTOS.add(customerDTO);
        }
        return customerDTOS;
    }

    public String deleteCustomer(String id) {
        customerRepository.deleteById(id);
        return "delete Done";
    }

    public CustomerDTO searchCustomer(String id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer!=null){
            CustomerDTO customerDTO = modelMapper.map(customer,CustomerDTO.class);
            return customerDTO;
        }else{
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setCustomerName("no Data");
            return customerDTO;
        }
    }

    public String updateCustomer(CustomerDTO customerDTO, String id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer!=null){
            Customer customer1 = modelMapper.map(customerDTO, Customer.class);
            customer1.setCustomerId(id);
            customerRepository.save(customer1);
            return "Done";
        }
        return "Customer doesn't Exist..!";
    }
}
