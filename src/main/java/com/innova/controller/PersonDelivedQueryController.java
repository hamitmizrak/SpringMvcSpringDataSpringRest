package com.innova.controller;

import com.innova.entity.ComputerEntity;
import com.innova.entity.PersonEntity;
import com.innova.repository.IDelivedQueryRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Log4j2
public class PersonDelivedQueryController {

    @Autowired
    IDelivedQueryRepository iDelivedQueryRepository;


    /////SAVE
    // http://localhost:8080/person/create
    @GetMapping("/person/create")
    @ResponseBody
    public String getSavePerson() {
        for (int i = 1; i <= 10; i++) {
            PersonEntity personEntity = PersonEntity
                    .builder().personId(0L).personName("person adı " + i).personPrice(100 * i)
                    .build();
            iDelivedQueryRepository.save(personEntity);
        }
        return PersonEntity.class + " Ekleme başarılı";
    }


    /////find
    // http://localhost:8080/person/find/starts/a
    @GetMapping("/person/find/starts/{starts}")
    @ResponseBody
    public String getFindStartsPerson(@PathVariable(name = "starts") String personStarts) {
        Iterable<PersonEntity> iterable = iDelivedQueryRepository.findByPersonNameStartingWith(personStarts);
        for (PersonEntity temp : iterable) {
            log.info(temp);
        }
        return iterable + "";
    }

    /////find
    // http://localhost:8080/person/find/ends/1
    @GetMapping("/person/find/ends/{ends}")
    @ResponseBody
    public String getFindEndsPerson(@PathVariable(name = "ends") String personEnds) {
        Iterable<PersonEntity> iterable = iDelivedQueryRepository.findByPersonNameEndsWith(personEnds);
        for (PersonEntity temp : iterable) {
            log.info(temp);
        }
        return iterable + "";
    }

}

