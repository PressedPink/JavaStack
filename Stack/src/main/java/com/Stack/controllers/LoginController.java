package com.Stack.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Stack.models.LoginModel;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/login")

public class LoginController {

    @GetMapping("/")
    public String displayLoginForm(Model model) {
        model.addAttribute("loginModel", new LoginModel());
        return "loginForm.html";
    }

    @PostMapping("/processLogin")
    public String processLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            // Validation failed; return to the login form with error messages
            return "loginForm.html";
        }
        return "loginResults.html";
    }
}
