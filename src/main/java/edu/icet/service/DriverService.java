package edu.icet.service;

import edu.icet.model.dto.CustomerDTO;
import edu.icet.model.dto.DriverDTO;
import edu.icet.model.entity.Driver;
import edu.icet.repository.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverService {

    final ModelMapper modelMapper;
    final DriverRepository driverRepository;

    public String addDriver(DriverDTO driverDTO) {
        Driver driver = modelMapper.map(driverDTO, Driver.class);
        driverRepository.save(driver);
        return "Driver Added successfully";
    }

    public String deleteDriver(String id) {
        driverRepository.deleteById(id);
        return "Deleted Successfully";
    }

    public List<DriverDTO> getAllDrivers() {
        List<Driver> all = driverRepository.findAll();
        List<DriverDTO> driverDTOS = new ArrayList<>();
        for (Driver driver : all){
            driverDTOS.add(modelMapper.map(driver, DriverDTO.class));
        }
        return driverDTOS;
    }
}
