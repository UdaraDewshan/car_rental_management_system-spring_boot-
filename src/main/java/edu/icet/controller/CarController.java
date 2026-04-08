package edu.icet.controller;

import edu.icet.model.dto.CarDTO;
import edu.icet.service.CarServise;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

}
