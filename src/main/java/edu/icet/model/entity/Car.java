package edu.icet.model.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Car {
    private String carId;
    private String brand;
    private String seatCapacity;
    private String model;
    private String fuelType;
    private double pricePerDay;
    private boolean states;
}
