package com.innova.controller;

import com.innova.entity.ComputerEntity;
import com.innova.repository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;


@Controller
public class ComputerController {

    @Autowired
    ComputerRepository computerRepository;

    /////SAVE
    // http://localhost:8080/computer/create
    @GetMapping("/computer/create")
    @ResponseBody
    public String getCreateComputer(){
        ComputerEntity computerEntity=ComputerEntity
                .builder()
                .computerId(0L)
                .computerName("computerName44")
                .computerTrade("computerTrade44")
                .computerPrice("computerPrice44")
                .build();
        //kaydettim
        computerRepository.save(computerEntity);
        return "Ekleme başarılı";
    }

    // http://localhost:8080/computer/create2?computer_name=computeradim55&computer_trade=xyzmarkası&computer_price=66
    @GetMapping("/computer/create2")
    @ResponseBody
    public String getCreateComputerRequestParam(
            @RequestParam(name = "computer_name") String computerName ,
            @RequestParam(name = "computer_trade") String computerTrade,
            @RequestParam(name = "computer_price") String computerPrice
    ){
        ComputerEntity computerEntity=ComputerEntity
                .builder()
                .computerId(0L)
                .computerName(computerName)
                .computerTrade(computerTrade)
                .computerPrice(computerPrice)
                .build();
        //kaydettim
        computerRepository.save(computerEntity);
        return "Ekleme başarılı Request param";
    }


    ///FIND
   // http://localhost:8080/computer/find/1
    @GetMapping("/computer/find/{id}")
    @ResponseBody
    public String getFindComputer(@PathVariable(name="id") Long idim ){
        //optional NullPointer Excepiton almamak icin
        Optional<ComputerEntity> optional=computerRepository.findById(idim);
        if(optional.isPresent()){
            //datayı getirdim
            ComputerEntity computerEntity2= optional.get();
            return "bulundu "+computerEntity2;
        }else{
            return " data bulunamadı !!! ";
        }
    }



    ///DELETE
    // http://localhost:8080/computer/delete/1
    @GetMapping("/computer/delete/{id}")
    @ResponseBody
    public String getDeleteComputer(@PathVariable(name="id") Long idim ){
        Optional<ComputerEntity> optional=computerRepository.findById(idim);
        if(optional.isPresent()){
            ComputerEntity computerEntity2= optional.get();
            //sildim
            computerRepository.deleteById(idim);
            return "silme yapıldı "+computerEntity2;
        }else{
            return " data bulunamadı ve silinemedi !!! ";
        }
    }



    /////UPDATE
    // http://localhost:8080/computer/update/2?computer_name=name66&computer_trade=trade66&computer_price=price66
    @GetMapping("/computer/update/{id}")
    @ResponseBody
    public String getUpdateComputer(
           @PathVariable(name="id")  Long idim,
           @RequestParam(name="computer_name") String computerName,
           @RequestParam(name="computer_trade") String computerTrade,
           @RequestParam(name="computer_price") String computerPrice
    ){
        Optional<ComputerEntity> optional=computerRepository.findById(idim);
        if(optional.isPresent()){
            ComputerEntity computerEntity2= optional.get();
            computerEntity2.setComputerName(computerName);
            computerEntity2.setComputerTrade(computerTrade);
            computerEntity2.setComputerPrice(computerPrice);
            computerRepository.save(computerEntity2);
            return "Güncelleme yapıldı "+computerEntity2;
        }else{
            return " data bulunamadı ve güncellenemedi !!! ";
        }
    }
}
