package com.innova.transactiontuto;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;



public class TransactionTutorials {

    @Transactional
    public void deneme(){

    }

    public static void main(String[] args) {
        try{
            int sayi=5/0;
        }catch (Exception exception){
            exception.printStackTrace();
        }
        throw new ArithmeticException("ak burda sıfır hatası var");
    }


    // Read (transaction(-))
    // DML = Create+Update+Delete
    // DDL =
    // DQL = Read

    // CUD
    // Create (transaction(+))
    // Update (transaction(+))
    // Delete (transaction(+))

}
