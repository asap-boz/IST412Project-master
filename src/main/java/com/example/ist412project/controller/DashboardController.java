package com.example.ist412project.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.ist412project.service.UserService;
import com.example.ist412project.model.UserInfo;
import java.util.List;


@Controller
public class DashboardController {
    private static final Logger log = LoggerFactory.getLogger(DashboardController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/viewDashboardPage")
    public String viewDashboardPage(Model model)
    {
        return "dashboard";
    }

    @GetMapping("/dashboard/user/{id}")
    public String viewAccountDashboardPage(@PathVariable (value = "id") long id, Model model) {
        // get user from service
        UserInfo user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "dashboard";
    }

    @GetMapping("/home")
    public String viewHomePage(Model model) {

        return "index";

    }

    @GetMapping("/comingSoon")
    public String viewConstructionPage(Model model) {

        return "index";

    }
}

