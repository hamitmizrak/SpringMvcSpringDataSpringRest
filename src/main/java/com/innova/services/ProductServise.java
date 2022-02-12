package com.innova.services;

import com.innova.dto.ProductDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@Log4j2
public class ProductServise {

    // http://localhost:8080/rest/xml
    @GetMapping(value = "/rest/xml",produces = MediaType.APPLICATION_XML_VALUE)
    public List<ProductDto> getXmlList(){
        List<ProductDto> productDtoList=new ArrayList<>();
        productDtoList.add(ProductDto.builder().productId(0L).productName("ürün 1").productPrice(5000).build());
        productDtoList.add(ProductDto.builder().productId(0L).productName("ürün 2").productPrice(6000).build());
        productDtoList.add(ProductDto.builder().productId(0L).productName("ürün 3").productPrice(7000).build());
        return productDtoList;
    }


    // http://localhost:8080/rest/json
    @GetMapping(value = "/rest/json",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductDto> getJsonList(){
        List<ProductDto> productDtoList=new ArrayList<>();
        productDtoList.add(ProductDto.builder().productId(0L).productName("ürün 1").productPrice(5000).build());
        productDtoList.add(ProductDto.builder().productId(0L).productName("ürün 2").productPrice(6000).build());
        productDtoList.add(ProductDto.builder().productId(0L).productName("ürün 3").productPrice(7000).build());
        return productDtoList;
    }

    ///////////////////////
    //POST
    @PostMapping("/post/basic")
    public void postVoid( @RequestBody ProductDto productDto){
        log.info(productDto);
        //database
    }

    //POST
    @PostMapping("/post/productdto")
    public ProductDto postProduct( @RequestBody ProductDto productDto){
        log.info(productDto);
        //database
        return  productDto;
    }

}
