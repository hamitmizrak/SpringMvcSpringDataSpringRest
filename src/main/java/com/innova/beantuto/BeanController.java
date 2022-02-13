package com.innova.beantuto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BeanController {

    @Autowired
    BeanConfig beanConfig;

    // http://localhost:8080/bean/beandto
    @GetMapping("/bean/beandto")
    @ResponseBody
    public String getBeanDto(){
        return beanConfig.beanDto()+"";
    }

}
