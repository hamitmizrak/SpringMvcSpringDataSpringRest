package com.innova.beantuto;

import lombok.Data;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.logging.Logger;


@Data
@ToString

public class PostContructTutorials {

    @Autowired
    Logger logger;

    @PostConstruct
    public void init(){
        logger.info("@PostConstruct");
    }

//    public PostContructTutorials() {
//        logger.info("Bu yazdırılmayacak, LOG hala boş ");
//        // NullPointerException will be thrown here
//    }


    public static void main(String[] args) {
        PostContructTutorials post=new PostContructTutorials();
        System.out.println(post);
    }
}
