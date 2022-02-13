package com.innova.beantuto;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Logger;

@Data
@ToString
public class PostContruct {

    @Autowired
    Logger LOG;

//    @PostConstruct
//    public void init(){
//        LOG.info("Bu yazdırılacak; LOG zaten enjekte edildi ");
//    }

    public PostContruct() {
        LOG.info("Bu yazdırılmayacak, LOG hala boş ");
        // NullPointerException will be thrown here
    }

    public static void main(String[] args) {
        PostContruct productDto = new PostContruct();
        System.out.println(productDto);
    }
}
