package com.innova.controller;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.Locale;

@Controller
@Log4j2
public class ProductServicesController {

    // http://127.0.0.1:8080/client/controller/string
    @GetMapping("/client/controller/string")
    @ResponseBody
    public String getServicesStringProduct(){
        String URL="http://localhost:8080/rest/manueljson";
        RestTemplate restTemplate=new RestTemplate();
        String jsonData=restTemplate.getForObject(URL,String.class);
        log.info(jsonData.toUpperCase());
        //database veri eklemek
        return jsonData;
    }

}
