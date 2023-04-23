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
@Table(name = "tp_CarRent_by")
public class CarRent_By extends BaseEntity {

        private String car_type;
        private Timestamp pickup_date;
        private String deposit;
        private Timestamp return_date;
        private double total_price;


//        @ManyToMany(mappedBy = "Users")
//        private List<Users> users;


//        @OneToOne(mappedBy = "CarRent_By")
//        private CarRent_invoice carRent_invoice;






}
