package edu.icet.model.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {
    private String customerId;
    private String customerName;
    private String address;
    private String email;
    private String contactNo;
    private String nic;
}
