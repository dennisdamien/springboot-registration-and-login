package com.tst.userregistrationlogin.web;


import com.tst.userregistrationlogin.service.UserService;
import com.tst.userregistrationlogin.web.dto.RegistrationDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@AllArgsConstructor
@RequestMapping("/registration")
public class UserController {

    private UserService userService;

    @ModelAttribute("user")
    public RegistrationDto registrationDto(){
        return new RegistrationDto();
    }

    @GetMapping
    public String registrationForm(){
        return "registration";
    }

    @PostMapping
    public String userRegistration(@ModelAttribute ("user") RegistrationDto registrationDto, RedirectAttributes redirectAttribute){
        userService.save(registrationDto);
        redirectAttribute.addFlashAttribute("success","success");
        return "redirect:/registration";
    }
}
