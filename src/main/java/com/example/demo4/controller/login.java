package com.example.demo4.controller;

import com.example.demo4.Model.User;
import com.example.demo4.Repository.UserRepository;
import com.example.demo4.Service.UserService;

import com.example.demo4.global.GlobalData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@AllArgsConstructor

public class login {
    private  final UserRepository userRepository;
    private final UserService userService;

    @GetMapping("/signup")
    public String getSignup(Model model){
        model.addAttribute("user",new User());
        return "signup1";
    }

    @PostMapping("/signup")
    public String postSignup(Model model, User user){
        userService.addUser(user);
        model.addAttribute("user",new User());
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String getLogin(Model model){
        GlobalData.cart.clear();
        model.addAttribute("user",new User());
        return "login1";
    }

    @PostMapping("/login")
    public String postLogin(Model model, User user){
        System.out.println("here?");
        if (userService.loginValidate(user)){
//            return "redirect:/index";
            return "redirect:/shop";
        }
        model.addAttribute("user",new User());
        return "redirect:/login";
    }


}

