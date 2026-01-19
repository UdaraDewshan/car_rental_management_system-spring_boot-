package edu.icet.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Driver {
    @Id
    private String driverId;
    private String name;
    private String licenseNo;
    private boolean states;
}
