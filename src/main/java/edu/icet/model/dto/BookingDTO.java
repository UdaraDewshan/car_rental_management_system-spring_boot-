package edu.icet.model.dto;

import java.util.Date;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class BookingDTO {
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
