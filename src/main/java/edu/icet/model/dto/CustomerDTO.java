package edu.icet.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class CustomerDTO {
    //private String customerId;
    private String customerName;
    private String address;
    private String email;
    private String contactNo;
    private String nic;
}
