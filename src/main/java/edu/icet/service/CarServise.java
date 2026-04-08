package edu.icet.service;

import edu.icet.model.dto.CarDTO;
import edu.icet.model.entity.Car;
import edu.icet.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarServise {

    final CarRepository carRepository;
    final ModelMapper modelMapper;

    public String addCar(CarDTO carDTO) {
        Car car = modelMapper.map(carDTO, Car.class);
        car.setCarId(genaratedId());
        car.setStates(true);
        carRepository.save(car);
        return "Car save successfully";
    }

    private String genaratedId() {
        return null;
    }
}
