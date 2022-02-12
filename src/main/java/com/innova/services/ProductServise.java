package com.innova.services;

import com.innova.dto.ProductDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@RestController
@Log4j2
public class ProductServise {

//    @GetMapping ==> Select
//    @PostMapping ==> Insert
//    @PutMapping ===> update
//    @DeleteMApping ==> delete

    // http://localhost:8080/rest/xml
    @GetMapping(value = "/rest/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public List<ProductDto> getXmlList() {
        List<ProductDto> productDtoList = new ArrayList<>();
        productDtoList.add(ProductDto.builder().productId(0L).productName("ürün 1").productPrice(5000).build());
        productDtoList.add(ProductDto.builder().productId(0L).productName("ürün 2").productPrice(6000).build());
        productDtoList.add(ProductDto.builder().productId(0L).productName("ürün 3").productPrice(7000).build());
        return productDtoList;
    }


    // http://localhost:8080/rest/json
    @GetMapping(value = "/rest/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductDto> getJsonList() {
        List<ProductDto> productDtoList = new ArrayList<>();
        productDtoList.add(ProductDto.builder().productId(0L).productName("ürün 1").productPrice(5000).build());
        productDtoList.add(ProductDto.builder().productId(0L).productName("ürün 2").productPrice(6000).build());
        productDtoList.add(ProductDto.builder().productId(0L).productName("ürün 3").productPrice(7000).build());
        return productDtoList;
    }

    ///////////////////////
    //POST
    @PostMapping("/post/basic")
    public void postVoid(@RequestBody ProductDto productDto) {
        log.info(productDto);
        //database
    }

    //POST
    @PostMapping("/post/productdto")
    public ProductDto postProduct(@RequestBody ProductDto productDto) {
        log.info(productDto);
        //database
        return productDto;
    }


    ///////////////////////
    //PUT
    @PutMapping("/put/productdto")
    public ProductDto putProduct(@RequestBody ProductDto productDto) {
        log.info(productDto);
        //database
        return productDto;
    }


    ///////////////////////
    //DELETE
    @DeleteMapping("/delete/productdto/{id}")
    public void deleteProduct(@PathVariable(name = "id") Long id) {
        log.info("silindi....  RestController " + id);
        //database
    }


    /////////
    // STATUS CODE OK
    // http://localhost:8080/rest/status1
    @GetMapping("/rest/status1")
    public ResponseEntity<ProductDto>  getStatus1() {
        ProductDto productDto = ProductDto.builder().productId(0L).productName("telefon 1").productPrice(6000).build();
        //Datamız varsa bir sıkıntı yoksa  ==> OK,

        // return new ResponseEntity<>(productDto, HttpStatus.OK);
        // return  ResponseEntity.status(HttpStatus.OK).body(productDto);
        // return ResponseEntity.ok().body(productDto);
        return ResponseEntity.ok(productDto);
    }

    // http://localhost:8080/rest/status2/notfound/0
    @GetMapping("/rest/status2/notfound/{id}")
    public ResponseEntity<?>  getStatus2(@PathVariable(name = "id") Long id){
        ProductDto productDto = ProductDto.builder().productId(id).productName("telefon 2").productPrice(7000).build();
        if(productDto.getProductId()==0){
           // return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Kayıt Bulunamadı ..."); //404
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(id+ " id'li Kayıt Bulundu ... "); //200

    }


    // http://localhost:8080/rest/status2/badrequest/0
    @GetMapping("/rest/status2/badrequest/{id}")
    public ResponseEntity<?>  getStatus3(@PathVariable(name = "id") Long id){
        ProductDto productDto = ProductDto.builder().productId(id).productName("telefon 2").productPrice(7000).build();
        if(productDto.getProductId()==0){
            return ResponseEntity.badRequest().build(); //400
        }
        return ResponseEntity.status(HttpStatus.OK).body(id+ " id'li Kayıt Bulundu ... "); //200
    }

    // http://localhost:8080/rest/status2/ok4/4
    @GetMapping("/rest/status2/ok4/{id}")
    public ResponseEntity<?>  getStatus4(@PathVariable(name = "id") Long id){
        ProductDto productDto = ProductDto.builder().productId(id).productName("telefon 3").productPrice(8000).build();
        return
                (ResponseEntity<?>) ResponseEntity
                        .status(HttpStatus.OK)
                        .contentType(new MediaType("application","json", Charset.forName("UTF-8")))
                        .body(" Tamamdır");
    }

}
