package edu.icet.model.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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

    private String userId;
    private String carId;
    private String customerId;
    private String driverId;

    private Date startDate;
    private Date endDate;
    private boolean withDriver;
    private Double totalPrice;

}
