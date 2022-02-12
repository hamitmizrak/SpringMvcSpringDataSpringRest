package com.innova.services;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

//Server
@RestController
@Log4j2
public class HeaderBodyServices {

    // REQUEST HEADER
    // http://localhost:8080/service/client/header
    @GetMapping("/service/client/header")
    public ResponseEntity<?> getHeader(@RequestHeader(value = "key_header", defaultValue = "default header") String gelenHeader) {
        log.info("@RestController(Server): "+gelenHeader);
        return ResponseEntity.ok(gelenHeader);
    }
}
