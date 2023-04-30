package com.example.entity;

import com.example.entity.mapperclass.BaseEntity;
import com.example.entity.MotorRent_By;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tp_MotorRent_by_invoice")
public class MotorRent_invoice extends BaseEntity {
    private String Deposit;
    private Double Total_price;

    @OneToOne
    @JoinColumn(name = "motor_rent_id", referencedColumnName = "id")
    private MotorRent_By motorRent_by;
}
