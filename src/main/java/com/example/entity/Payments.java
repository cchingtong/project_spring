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
@Table(name = "tp_payment") // tp = table product
public class Payments extends BaseEntity {
    private long payment_id;
    private long customer_id;
    private String bank;
    private double price;
    private double amount;
    private String status;


}
