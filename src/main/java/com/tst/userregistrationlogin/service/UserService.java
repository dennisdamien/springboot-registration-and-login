package com.tst.userregistrationlogin.service;


import com.tst.userregistrationlogin.model.User;
import com.tst.userregistrationlogin.web.dto.RegistrationDto;

public interface UserService {

    User save(RegistrationDto registrationDto);
}
