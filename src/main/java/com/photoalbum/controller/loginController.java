package com.photoalbum.controller;

import com.photoalbum.model.Users;
import com.photoalbum.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class loginController {

    @Autowired
    UserService userService;


    @GetMapping("/home")
    public String home(Model model,
                       HttpSession session) {
        Users user = (Users) session.getAttribute("user");
        if (user != null) {
            model.addAttribute("user", user);
        }else {

            return "redirect:/login";
        }
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @PostMapping("/loginEvent")
    public String loginEvent(@RequestParam("username") String username,
                             @RequestParam("password") String password,
                             HttpSession session) {

        Users isValidUser = userService.findByUserNameAndPassword(username, password);
        if (isValidUser != null) {
            session.setAttribute("user", isValidUser);
            return "redirect:/home";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/login";
    }

}

