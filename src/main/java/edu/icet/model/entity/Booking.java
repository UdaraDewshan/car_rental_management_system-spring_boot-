package edu.icet.model.entity;

import java.util.Date;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Booking {
    @Id
    private String bookingId;

    @ManyToOne
    @JoinColumn(name ="user_id")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car carId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customerId;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driverId;

    private Date startDate;
    private Date endDate;
    private boolean withDriver;
    private Double totalPrice;

}
