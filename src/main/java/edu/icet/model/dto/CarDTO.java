package edu.icet.model.dto;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class CarDTO {
    @Id
    private String carId;
    private String brand;
    private String seatCapacity;
    private String model;
    private String fuelType;
    private double pricePerDay;
    private boolean states;
}
