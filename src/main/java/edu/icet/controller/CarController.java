package edu.icet.controller;

import edu.icet.model.dto.CarDTO;
import edu.icet.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/car")
@CrossOrigin
public class CarController {

    final CarService carService;

    @PostMapping("/add")
    public String addCar(@RequestBody CarDTO carDTO){
        return carService.addCar(carDTO);
    }

    @GetMapping("getAll")
    public List<CarDTO> getAllCars(){
        return carService.getAllCars();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCar(@PathVariable("id") String id) {
        return carService.deleteCar(id);
    }

    @GetMapping("/search/{id}")
    public CarDTO searchCar(@PathVariable("id") String id){
        return carService.searchCar(id);
    }

    @PostMapping("/update/{id}")
    public String updateCar(@RequestBody CarDTO carDTO, @PathVariable("id") String id) {
        return carService.updateCar(carDTO, id);
    }

}
