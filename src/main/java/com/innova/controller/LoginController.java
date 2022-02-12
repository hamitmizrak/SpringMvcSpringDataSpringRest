package com.innova.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    // http://localhost:8080/security/public
    // http://localhost:8080/security/private

    //LOGIN
    @GetMapping("/login")
    public String getLogin(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("key_message", "username veya password hataalı");
        } else {
            model.addAttribute("key_message", "lütfen bilgileri giriniz");
        }
        return "/login";
    }
}
