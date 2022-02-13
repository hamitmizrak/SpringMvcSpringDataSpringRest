package com.innova.entity;

import com.innova.audit.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

//lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

//entity
@Entity
@Table(name="audit")
public class AuditEntity extends BaseEntity implements Serializable {



    @Column(name = "audit_name")
    private String auditName;



}
