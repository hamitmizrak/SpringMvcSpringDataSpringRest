package com.innova.cors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CorsServices {

    // http://localhost:8080/cors
    @CrossOrigin
    @GetMapping("/cors")
    @ResponseBody
    public String mesaj() {
        return "Merhabalar nasılsınız";
    }
}
