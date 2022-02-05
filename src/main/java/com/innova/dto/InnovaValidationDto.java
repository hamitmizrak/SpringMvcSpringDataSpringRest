package com.innova.dto;

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
public class InnovaValidationDto {

    private String userName;
    private String userSurname;
    private String emailAddress;
    private int userAge;
    private String userMessage;
}
