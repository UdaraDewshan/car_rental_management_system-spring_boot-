package edu.icet.model.dto;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DriverDTO {
    @Id
    private String driverId;
    private String name;
    private String licenseNo;
    private boolean states;
}
