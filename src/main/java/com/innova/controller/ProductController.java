package com.innova.controller;

import com.innova.dto.ProductDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Locale;

@Controller
@Log4j2
public class ProductController {

    // http://localhost:8080/client/controller/string
    @GetMapping("/client/controller/string")
    @ResponseBody
    public String getProductServicesString() {
        String URL = "http://localhost:8080/rest/manueljson";
        RestTemplate restTemplate = new RestTemplate();
        String jsonData = restTemplate.getForObject(URL, String.class); //String
        return "client resten veri aldı: "+jsonData;
    }


    // http://localhost:8080/client/controller/productdto
    @GetMapping("/client/controller/productdto")
    @ResponseBody
    public String getProductServicesDto() {
        String URL = "http://localhost:8080/rest/dynamicsjson";
        RestTemplate restTemplate = new RestTemplate();
        ProductDto productDto = restTemplate.getForObject(URL, ProductDto.class); //object
        return "client resten veri aldı: "+productDto.getProductName().toUpperCase();
    }


    // http://localhost:8080/client/controller/productdto/special/Deneme44
    @GetMapping("/client/controller/productdto/special/{urun_adi}")
    @ResponseBody
    public String getProductServicesResponseEntity(@PathVariable("urun_adi") String urunAdi) {
        String URL = "http://localhost:8080/rest/pathvariable/"+urunAdi;
        RestTemplate restTemplate = new RestTemplate();
        ProductDto productDto = restTemplate.getForObject(URL, ProductDto.class);
        //Kontrol
        ResponseEntity<ProductDto> responseEntity=restTemplate.exchange(URL, HttpMethod.GET, HttpEntity.EMPTY,ProductDto.class);
        ProductDto productDto2=responseEntity.getBody();
        return "client resten veri aldı: "+productDto2;
    }


    // http://localhost:8080/client/controller/productdto/specialList/
    @GetMapping("/client/controller/productdto/specialList/")
    @ResponseBody
    public List<ProductDto>  getProductServicesResponseEntityList() {
        String URL = "http://localhost:8080/rest/list/";
        RestTemplate restTemplate = new RestTemplate();
        //Anonymous Class
        ResponseEntity<List<ProductDto>> responseEntity=restTemplate.exchange(URL, HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<List<ProductDto>>() {});
        List<ProductDto> list=responseEntity.getBody();
        for (ProductDto temp:list){
            log.info(temp);
        }
        //Database kaydetmek ,dosyaya kaydetmek
        return list;
    }

    //XML
    // http://localhost:8080/client/controller/productdto/xml
    @GetMapping("/client/controller/productdto/xml")
    @ResponseBody
    public List<ProductDto>  getXmlProductServicesResponseEntityList() {
        String URL = "http://localhost:8080/rest/xml";
        RestTemplate restTemplate = new RestTemplate();
        //Anonymous Class
        ResponseEntity<List<ProductDto>> responseEntity=restTemplate.exchange(URL, HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<List<ProductDto>>() {});
        List<ProductDto> list=responseEntity.getBody();
        for (ProductDto temp:list){
            log.info(temp);
        }
        //Database kaydetmek ,dosyaya kaydetmek
        return list;
    }
    //////////////////////////////
    ///POST
    // http://localhost:8080/client/controller/post
    @GetMapping("/client/controller/post")
    @ResponseBody
    public String  postBasic() {
        ProductDto productDto=ProductDto.builder().productId(0L).productName("Hamit").productPrice(3000).build();
        String URL = "http://localhost:8080/post/basic";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(URL,productDto,Void.class); //Void
        return "Success !";
    }


    // http://localhost:8080/client/controller/post?urun_adi=bilgisayar&urun_fiyati=6000
    @GetMapping("/client/controller/dto")
    @ResponseBody
    public String  postProductDto(@RequestParam(name="urun_adi") String urunAdi,@RequestParam(name="urun_fiyati") double urunFiyati) {
        ProductDto productDto=ProductDto.builder().productId(0L).productName(urunAdi).productPrice(urunFiyati).build();
        String URL = "http://localhost:8080/post/productdto";
        RestTemplate restTemplate = new RestTemplate();
        ProductDto productDto2=  restTemplate.postForObject(URL,productDto,ProductDto.class); //ProductDto

        return "Success !"+productDto2;
    }

    // http://localhost:8080/client/controller/post/responseentity?urun_adi=bilgisayar&urun_fiyati=6000
    @GetMapping("/client/controller/post/responseentity")
    @ResponseBody
    public String  postProductDtoResponseEntity(@RequestParam(name="urun_adi") String urunAdi,@RequestParam(name="urun_fiyati") double urunFiyati) {
        ProductDto productDto=ProductDto.builder().productId(0L).productName(urunAdi).productPrice(urunFiyati).build();
        String URL = "http://localhost:8080/post/productdto";
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<ProductDto> productDtoHttpEntity=new HttpEntity<>(productDto);
        ResponseEntity<ProductDto> responseEntity=restTemplate.exchange(URL,HttpMethod.POST,productDtoHttpEntity,ProductDto.class);
        ProductDto productDto2=responseEntity.getBody();
        return "Post Success ! HttpEntity bir hata varsa almak icin: "+productDto2;
    }


    ///////////
    //PUT
    // http://localhost:8080/client/controller/put/responseentity?urun_adi=bilgisayar&urun_fiyati=6000
    @GetMapping("/client/controller/put/responseentity")
    @ResponseBody
    public String  putProductDtoResponseEntity(@RequestParam(name="urun_adi") String urunAdi,@RequestParam(name="urun_fiyati") double urunFiyati) {
        ProductDto productDto=ProductDto.builder().productId(0L).productName(urunAdi).productPrice(urunFiyati).build();
        String URL = "http://localhost:8080/put/productdto";
        RestTemplate restTemplate = new RestTemplate();
        //HttpEntity aşağıda yazdım
        ResponseEntity<ProductDto> responseEntity=restTemplate.exchange(URL,HttpMethod.PUT, new HttpEntity<ProductDto>(productDto),ProductDto.class);
        ProductDto productDto2=responseEntity.getBody();
        return "Update Success ! HttpEntity bir hata varsa almak icin: "+productDto2;
    }


}
