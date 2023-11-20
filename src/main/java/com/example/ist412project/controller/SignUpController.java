package com.example.ist412project.controller;

import com.example.ist412project.model.UserInfoModel;
import com.example.ist412project.service.UserServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {

    private final UserServ userService;

    @Autowired
    public SignUpController(UserServ userService) {
        this.userService = userService;
    }

    // Mapping for displaying the sign-up form
    @GetMapping("/signup")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new UserInfoModel());
        return "SignUpForm"; // Return the Thymeleaf template for the sign-up form
    }

    // Mapping for processing the sign-up form
    @PostMapping("/signup")
    public String signUp(@ModelAttribute("user") UserInfoModel user) {

        // For simplicity, we're assuming the user service handles user creation
        userService.createUser(user);
        return "redirect:/login"; // Redirect to the login page or another page after successful registration
    }
}
