package com.tst.userregistrationlogin.service;


import com.tst.userregistrationlogin.model.User;
import com.tst.userregistrationlogin.web.dto.RegistrationDto;

import java.util.List;

public interface UserService {

    User save(RegistrationDto registrationDto);

    List<User> getAllUsers();
}
