package com.innova.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Locale;

@Controller
@Log4j2
public class SecurityController {


    //PUBLIC
    // http://localhost:8080/security/public
    @GetMapping("/security/public")
    public String getPublic(){
        return "/public/index";
    }

    //PRIVATE
    // http://localhost:8080/security/private
    @GetMapping("/security/private")
    public String getPrivate(){
        return "/private/index";
    }

    //SUCCESS
    // http://localhost:8080/security/success
    @GetMapping("/security/success")
    public String getSuccess(){
        return "/success";
    }


    //ADMIN
    // http://localhost:8080/security/admin
    @GetMapping("/security/admin")
    public String getAdmin(Model model){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String user="";
        if(authentication!=null){
            System.out.println(authentication.getName());
            user=authentication.getName();
        }
        model.addAttribute("system_user",user);
        return "/superadmin/secret";
    }


    // WRITER
    // http://localhost:8080/security/writer
    @GetMapping("/security/writer")
    public String getWriter(Model model){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String user="";
        if(authentication!=null){
            System.out.println(authentication.getName());
            user=authentication.getName();
        }
        model.addAttribute("system_user",user);
        return "/writer/writer";
    }



    // ROLES
    // http://localhost:8080/security/roles
    @GetMapping("/security/roles")
    @ResponseBody
    public String getRoles(){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String rols="";
        if(authentication!=null){
           for( GrantedAuthority grantedAuthority  :authentication.getAuthorities()){
               rols+=grantedAuthority.getAuthority();
           }
        }
        return "Sistemdeki Yetkili roles: "+rols;
    }


    // FarkliKullanicilar Aynı Sayfada Farkl kullanıcılar
    // http://localhost:8080/spesific_page
    @GetMapping("/spesific_page")
    public String getSpesific(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String user = "";
        if (authentication != null) {
            user = authentication.getName().toUpperCase();
        }
        model.addAttribute("system_user", user.toUpperCase());
        return "/aynisayfafarklikullanici/farklıkullanicilar";
    }


}
