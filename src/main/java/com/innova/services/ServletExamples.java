package com.innova.services;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;

@RestController
@Log4j2
@RequestMapping("/servlet")
public class ServletExamples {

    @Autowired
    private ServletContext servletContext;

    // http://localhost:8080/servlet/info
    @GetMapping("/info")
    @ResponseBody
    public ResponseEntity<?> getServletInformation() {
        String secretData = servletContext.getInitParameter("secretinformation");
        return ResponseEntity.ok(secretData);
    }
}
