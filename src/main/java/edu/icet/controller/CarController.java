package edu.icet.controller;

import edu.icet.model.dto.CarDTO;
import edu.icet.service.CarServise;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/car")
@CrossOrigin
public class CarController {

    final CarServise carServise;

    @PostMapping("/add")
    public String addCar(@RequestBody CarDTO carDTO){
        return carServise.addCar(carDTO);
    }

    @GetMapping("getAll")
    public List<CarDTO> getAllCars(){
        return carServise.getAllCars();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCar(@PathVariable("id") String id) {
        return carServise.deleteCar(id);
    }

}
