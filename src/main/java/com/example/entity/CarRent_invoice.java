package com.example.entity;

import com.example.entity.mapperclass.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.sql.Timestamp;
import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tp_CarRent_by_invoice")

public class CarRent_invoice extends BaseEntity {
    private String Deposit;
    private Double Total_price;

    @OneToOne
    @JoinColumn(name = "car_rent_id", referencedColumnName = "id")
    private CarRent_By carRent_by;


}
