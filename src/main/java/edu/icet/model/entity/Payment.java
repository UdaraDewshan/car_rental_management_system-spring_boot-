package edu.icet.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Payment {
    @Id
    private String paymentId;

    @OneToOne
    @JoinColumn(name = "booking_id")
    private Booking bookingId;

    private String paymentMethod;
    private double amount;
}
