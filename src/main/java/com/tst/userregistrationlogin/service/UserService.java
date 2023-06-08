package com.tst.userregistrationlogin.service;


import com.tst.userregistrationlogin.model.User;
import com.tst.userregistrationlogin.web.dto.RegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    User save(RegistrationDto registrationDto);

    List<User> getAllUsers();
}
