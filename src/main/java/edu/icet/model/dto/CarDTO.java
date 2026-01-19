package edu.icet.model.dto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class CarDTO {
    private String carId;
    private String brand;
    private String seatCapacity;
    private String model;
    private String fuelType;
    private double pricePerDay;
    private boolean states;
}
