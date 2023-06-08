package com.tst.userregistrationlogin.service.serviceimpl;

import com.tst.userregistrationlogin.model.Role;
import com.tst.userregistrationlogin.model.User;
import com.tst.userregistrationlogin.repository.UserRepository;
import com.tst.userregistrationlogin.service.UserService;
import com.tst.userregistrationlogin.web.dto.RegistrationDto;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User save(RegistrationDto registrationDto) {
        User user=new User(registrationDto.getFirstName(),
                            registrationDto.getLastName(),
                            registrationDto.getEmail(),
                            passwordEncoder.encode(registrationDto.getPassword()),
                Arrays.asList(new Role("ROLE_USER"))
                );
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByEmail(username);
        if(user==null){
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<?extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles
                .stream()
                .map(
                        role -> new SimpleGrantedAuthority(role.getName())
                )
                .collect(Collectors.toList());
    }
}
