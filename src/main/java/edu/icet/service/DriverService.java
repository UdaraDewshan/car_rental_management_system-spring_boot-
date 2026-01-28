package edu.icet.service;

import edu.icet.model.dto.DriverDTO;
import edu.icet.model.entity.Driver;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DriverService {

    final ModelMapper modelMapper;

    public String addDriver(DriverDTO driverDTO) {
        Driver driver = modelMapper.map(driverDTO, Driver.class);
        return null;
    }
}
