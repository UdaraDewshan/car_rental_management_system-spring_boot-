package edu.icet.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDTO {
    private String userId;
    private String userName;
    private String email;
    private String phoneNumber;
    private String password;
    private String role;
}