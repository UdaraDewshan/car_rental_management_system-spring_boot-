package edu.icet.service;

import edu.icet.model.dto.DriverDTO;
import edu.icet.model.entity.Driver;
import edu.icet.repository.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
}
