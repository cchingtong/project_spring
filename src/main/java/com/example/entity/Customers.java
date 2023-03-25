package com.example.entity;

import com.example.entity.mapperclass.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tp_customers") // tp = table product
public class Customers extends BaseEntity {

    private long customer_id;
    private String username;
    private int number_phone;
    private String email;
    private String password;


}
