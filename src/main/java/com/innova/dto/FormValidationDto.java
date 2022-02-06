package com.innova.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.validation.constraints.*;

//lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j2

// NEMM :  @NotEmpty @Email @Min @Max @Size
public class FormValidationDto {

    @NotEmpty(message = "adı alanını boş geçemezsiniz")
    private String userName;

    @NotEmpty(message = "soyadı alanını boş geçemezsiniz")
    private String userSurname;

    @NotEmpty(message = "email alanını boş geçemezsiniz")
    @Email(message = "uygun formatta mail giriniz")
    private String emailAddress;

    @Min(value=18,message = "18 yaşından küçüksünüz başvuramazsınız")
    @Max(value=45,message = "45 yaşından büyüksünüz başvuramazsınız")
    private int userAge;

    @NotEmpty(message = "mesaj alanını boş geçemezsiniz")
    @Size(min=1,max=250)
    private String userMessage;
}
