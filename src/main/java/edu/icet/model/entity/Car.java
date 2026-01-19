package edu.icet.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Car {
    @Id
    private String carId;
    private String brand;
    private String seatCapacity;
    private String model;
    private String fuelType;
    private double pricePerDay;
    private boolean states;
}
