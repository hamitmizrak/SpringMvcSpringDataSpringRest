package com.innova.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="computer")
public class ComputerEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long computerId;

    @Column(name = "computer_name")
    private String computerName;


    @Column(name = "computer_trade")
    private String computerTrade;

    @Column(name = "computer_price")
    //@Column(name = "computer_price",columnDefinition = "Decimal(10,2) default='100.00'")
    private String computerPrice;

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdDate;

//    @Lob  //buyuk veriler icin
//    private String bigData;

//    @Transient  //sadece java var ancak database eklenmeyecek
//    private String justJava;

//    @Column(name = "computer_serial_number",length = 11,nullable = false,unique = true)
//    private int serialComputerNumber;


}
