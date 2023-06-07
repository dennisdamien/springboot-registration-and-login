package com.tst.userregistrationlogin.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationDto {

    private String firstName;

    private String lastName;

    private String email;

    private String password;
}
