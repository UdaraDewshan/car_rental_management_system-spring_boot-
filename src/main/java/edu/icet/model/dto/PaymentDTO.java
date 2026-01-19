package edu.icet.model.dto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaymentDTO {
    private String paymentId;

    private String bookingId;

    private String paymentMethod;
    private double amount;
}
