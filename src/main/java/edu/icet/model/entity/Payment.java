package edu.icet.model.entity;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Payment {
    private String paymentId;

    private String bookingId;

    private String paymentMethod;
    private double amount;
}
