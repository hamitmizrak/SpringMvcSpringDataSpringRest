package com.innova.controller;

import com.innova.dto.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.Locale;

@Controller
public class ProductController {

    // http://localhost:8080/client/controller/string
    @GetMapping("/client/controller/string")
    @ResponseBody
    public String getProductServicesString() {
        String URL = "http://localhost:8080/rest/manueljson";
        RestTemplate restTemplate = new RestTemplate();
        String jsonData = restTemplate.getForObject(URL, String.class);
        return "client resten veri aldı: "+jsonData;
    }


    // http://localhost:8080/client/controller/productdto
    @GetMapping("/client/controller/productdto")
    @ResponseBody
    public String getProductServicesDto() {
        String URL = "http://localhost:8080/rest/dynamicsjson";
        RestTemplate restTemplate = new RestTemplate();
        ProductDto productDto = restTemplate.getForObject(URL, ProductDto.class);
        return "client resten veri aldı: "+productDto.getProductName().toUpperCase();
    }



}
