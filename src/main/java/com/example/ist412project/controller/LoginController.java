package com.example.ist412project.controller;

import com.example.ist412project.model.UserInfoModel;
import com.example.ist412project.service.UserServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LoginController {

    private final UserServ userService;

    @Autowired
    public LoginController(UserServ userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("user", new UserInfoModel());
        return "Login"; // Thymeleaf template name
    }

    @PostMapping("/login")
    public String loginSubmit(@RequestParam String userName, @RequestParam String password, Model model) {

        if (userService.validateUser(userName, password)) {
            // Successful login
            List<UserInfoModel> users = userService.getAllUsers();
            for (UserInfoModel other : users) {
                if (userName.equals(other.getUserName())) {
                    if (password.equals(other.getPassword())) {
                        return "redirect:/dashboard/user/" + other.getUserID();
                    }
                }
            }
            return "redirect:/login"; // Redirect
        } else {
            // Failed login, show an error message
            model.addAttribute("error", "Invalid username or password");
            return "redirect:/failure";
        }
    }

    @GetMapping("/forgotPassword")
    public String viewForgotPasswordPage(Model model)
    {
        UserInfoModel user = new UserInfoModel();
        model.addAttribute("user", user);
        return "Forgot";
    }

    @PostMapping("/checkUserEmail")
    public String checkUserEmail(@ModelAttribute("user") UserInfoModel user) {
        List<UserInfoModel> users = userService.getAllUsers();
        for (UserInfoModel other : users) {
            if (user.getEmail().equals(other.getEmail())) {
                //email user password reset
                return "redirect:/Forgot_sent";
            }
        }
        return "redirect:/Forgot_sent";
    }

    @GetMapping("/Forgot_sent")
    public String viewPasswordResetPage(Model model)
    {
        UserInfoModel user = new UserInfoModel();
        model.addAttribute("user", user);
        return "Forgot_sent";
    }
}
