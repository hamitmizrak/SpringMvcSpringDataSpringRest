package com.innova.services;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Log4j2
@RequestMapping("/servlet")
public class ServletExamples {

    @Autowired
    private ServletContext servletContext;

    // http://localhost:8080/servlet/info
    //application.properties
    @GetMapping("/info")
    @ResponseBody
    public ResponseEntity<?> getServletInformation() {
        String secretData = servletContext.getInitParameter("secretinformation");
        return ResponseEntity.ok(secretData);
    }

    // http://localhost:8080/servlet/common
    @GetMapping("/common")
    @ResponseBody
    public ResponseEntity<?> getServletCommon(HttpServletRequest request) {
        log.info("info " + request.getPathInfo());
        log.info("method " + request.getMethod());
        log.info("port " + request.getServerPort());
        return ResponseEntity.ok(request.getPathInfo());
    }

    // http://localhost:8080/servlet/common
    @GetMapping("/request/response")
    @ResponseBody
    public ResponseEntity<?> getServletRequestResponse(HttpServletRequest request, HttpServletResponse response) {
        log.info("info " + request.getPathInfo());
        log.info("method " + request.getMethod());
        log.info("port " + request.getServerPort());
        log.info("response " + response.getCharacterEncoding());
        return ResponseEntity.ok(request.getPathInfo());
    }
}
