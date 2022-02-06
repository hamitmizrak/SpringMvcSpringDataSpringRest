package com.innova.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.util.Date;

//lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table( name="person")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personId;

    private String personName;
    private double personPrice;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date date;
}
