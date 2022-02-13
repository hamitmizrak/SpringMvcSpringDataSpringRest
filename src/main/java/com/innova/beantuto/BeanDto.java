package com.innova.beantuto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j2
public class BeanDto {

    private Long id;
    private String beanName;
    private String beanData;

    //başlangıç
    public void initialBEanMethod(){
        log.info("Beanim başladı Hayırlı olsun");
        System.out.println("Beanim başladı Hayırlı olsun");
        //database
    }


    //bitiş
    public void destroyBEanMethod(){
        log.error("Beanim öldü Geçmiş olsun");
        System.err.println("Beanim öldü Geçmiş olsun");
        //loglama
    }


}
