package edu.icet.model.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Driver {
    private String driverId;
    private String name;
    private String licenseNo;
    private boolean states;
}
