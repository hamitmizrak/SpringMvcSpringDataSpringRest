package com.innova.services;

import com.innova.dto.ProductDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@Log4j2
public class PostmanServices {

    //GETMAPPING
    //UNUTMA: Sadece @GetMapping Browserda çalışır.
    // http://localhost:8080/api/rest/postman/dynamicsjson
    @GetMapping("/rest/postman/dynamicsjson")
    public ProductDto getDynamicsJson() {
        ProductDto productDto = ProductDto.builder().productId(0L).productName("Product adı 44").productPrice(55).build();
        return productDto;
    }

    // http://localhost:8080/api/rest/postman/dynamicsjson2/44
    @GetMapping("/rest/postman/dynamicsjson2/{id}")
    public ProductDto getDynamicsJson2(@PathVariable(name = "id") Long id) {
        ProductDto productDto = ProductDto.builder().productId(id).productName("Product adı 44").productPrice(55).build();
        return productDto;
    }


    // http://localhost:8080/api/rest/postman/list/
    @GetMapping(value = "/rest/postman/list/")
    public List<ProductDto> getProductList() {
        List<ProductDto> productDtoList = new ArrayList<>();
        productDtoList.add(ProductDto.builder().productId(0L).productName("urunAdi1").productPrice(11).build());
        productDtoList.add(ProductDto.builder().productId(0L).productName("urunAdi2").productPrice(22).build());
        productDtoList.add(ProductDto.builder().productId(0L).productName("urunAdi3").productPrice(33).build());
        productDtoList.add(ProductDto.builder().productId(0L).productName("urunAdi4").productPrice(44).build());
        return productDtoList;
    }

    /////////////////////////////////////////////
    //  NOT:405 almamak için Postmande deneyelim
    //  POST
    //  There was an unexpected error (type=Method Not Allowed, status=405).
    //  Request method 'GET' not supported
    //  org.springframework.web.HttpRequestMethodNotSupportedException: Request method 'GET' not supported
    //  http://localhost:8080/api/rest/post/postman
    @PostMapping(value = "/rest/post/postman")
    public ProductDto postProduct(ProductDto productDto) {
        ProductDto productDto1 = productDto;
        log.info(productDto1);
        return productDto1;
    }


    /////////////////////////////////////////////
    //  PUT
    //  http://localhost:8080/api/rest/put/postman
    @PutMapping("/rest/put/postman")
    public void updateProduct(ProductDto productDto) {
        ProductDto productDto2 = productDto;
        log.info(productDto2);
    }

    //  DELETE
    //  http://localhost:8080/api/rest/delete/postman/4
    @DeleteMapping("/rest/delete/postman/{id}")
    public void deleteProduct(@PathVariable(name = "id") Long id) {
        log.info(id + " id silindi");
    }

}
