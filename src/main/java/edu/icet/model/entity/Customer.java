package edu.icet.model.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {
    private String customerId;
    private String customer_name;
    private String address;
    private String email;
    private String contact_no;
    private String nic;
}
