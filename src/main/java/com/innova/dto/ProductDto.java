package com.innova.dto;

import lombok.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ProductDto {

    private Long productId;
    private String productName;
    private double productPrice;

    // Bean tam olarak başlatılmadan ve bağımlılıkları kullanabilirsiniz.
    @PostConstruct
    public void init() throws Exception {
        System.out.println("Inıt Metot PostConstruct : " + productName);
    }



    @PreDestroy
    public void preinit() throws Exception {
        System.out.println("Spring Konteyner Durdu ve preinit metodu çalıştı");
    }

    public static void main(String[] args) {
        ProductDto productDto=new ProductDto();
        System.out.println(productDto);
    }

}
