package com.tst.userregistrationlogin.service.serviceimpl;

import com.tst.userregistrationlogin.model.Role;
import com.tst.userregistrationlogin.model.User;
import com.tst.userregistrationlogin.repository.UserRepository;
import com.tst.userregistrationlogin.service.UserService;
import com.tst.userregistrationlogin.web.dto.RegistrationDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User save(RegistrationDto registrationDto) {
        User user=new User(registrationDto.getFirstName(),
                            registrationDto.getLastName(),
                            registrationDto.getEmail(),
                            registrationDto.getPassword(),
                Arrays.asList(new Role("ROLE_USER"))
                );
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
