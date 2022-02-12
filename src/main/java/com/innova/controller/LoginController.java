package com.innova.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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


    //LOGOUT
    @GetMapping("/logout")
    public String getLogout(HttpServletRequest request, HttpServletResponse response, Model model) {
        //sistemdeki kullanıcıyı almak için
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();

        if(authentication!=null){
            new SecurityContextLogoutHandler().logout(request,response,authentication);
            model.addAttribute("key_logout","Çıkış başarılı");
        }else{
            model.addAttribute("key_logout","Değil Çıkış ");
        }

        return "/logout";
    }
}
