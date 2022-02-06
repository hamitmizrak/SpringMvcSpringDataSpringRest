package com.innova.services;

import com.innova.dto.ProductDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonServices {

    // http://localhost:8080/rest/manueljson
    @GetMapping("/rest/manueljson")
    public String getManuelJson(){
        return "{\"adisoyadi\": \"HamitMizrak\"}";
    }

    // http://localhost:8080/rest/dynamicsjson
    @GetMapping("/rest/dynamicsjson")
    public ProductDto getDynamicsJson(){
        ProductDto productDto=ProductDto.builder().productId(0L).productName("Product adı 44").productPrice(55).build();
        return productDto;
    }


    // http://localhost:8080/rest/mediatype
    @GetMapping(value = "/rest/mediatype",produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductDto getDProduces(){
        ProductDto productDto=ProductDto.builder().productId(0L).productName("Product adı 77").productPrice(77).build();
        return productDto;
    }

    // http://localhost:8080/rest/pathvariable/kalem44
    @GetMapping(value = "/rest/pathvariable/{urunadi}")
    public ProductDto getDProduces(@PathVariable("urunadi") String urunAdi){
        ProductDto productDto=ProductDto.builder().productId(0L).productName(urunAdi).productPrice(77).build();
        return productDto;
    }


    // http://localhost:8080/rest/list/
    @GetMapping(value = "/rest/list/")
    public List<ProductDto>  getProductList(){
        List<ProductDto> productDtoList=new ArrayList<>();
        productDtoList.add(ProductDto.builder().productId(0L).productName("urunAdi1").productPrice(11).build());
        productDtoList.add(ProductDto.builder().productId(0L).productName("urunAdi2").productPrice(22).build());
        productDtoList.add(ProductDto.builder().productId(0L).productName("urunAdi3").productPrice(33).build());
        productDtoList.add(ProductDto.builder().productId(0L).productName("urunAdi4").productPrice(44).build());
        return productDtoList;
    }



}
