package com.innova.beantuto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BeanController {

    @Autowired
    _01_BeanBasic beanBasic;

    @Autowired
    _02_BeanScope beanScope;

    @Autowired
    _03_BeanIntialDestroy beanIntialDestroy1;

    @Autowired
    _03_BeanIntialDestroy beanIntialDestroy2;

    // http://localhost:8080/bean/basic
    @GetMapping("/bean/basic")
    @ResponseBody
    public String getBeanBasic(){
        return beanBasic.beanBasic()+"";
    }

    // http://localhost:8080/bean/scope
    @GetMapping("/bean/scope")
    @ResponseBody
    public String getBeanScope(){
        return beanBasic.beanBasic().hashCode()+" ??? "+beanScope.beanScope().hashCode();
    }

    // http://localhost:8080/bean/initial/destroy
    @GetMapping("/bean/initial/destroy")
    @ResponseBody
    public String getBeanInitialDestroy(){
        return beanIntialDestroy1.beanInitial().hashCode()+" ??? "+beanIntialDestroy2.beanInitial().hashCode();
    }

}
