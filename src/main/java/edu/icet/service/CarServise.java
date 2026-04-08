package edu.icet.service;

import edu.icet.model.dto.CarDTO;
import edu.icet.model.entity.Car;
import edu.icet.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

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
        List<Car> cars = carRepository.findAll();
        String generatedId = "CAR-001";
        int genId= 1;
        for (Car car : cars){
            if (car.getCarId().equals(generatedId)){
                genId++;
                generatedId = String.format("CAR-%03d",genId);
            }else {
                break;
            }
        }
        return generatedId;
    }
}
