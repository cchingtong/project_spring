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
@Table(name = "tp_rent_by")
public class Rent_By extends BaseEntity {

        private Timestamp pickup_date;
        private String deposit;
        private Timestamp return_date;
        private double total_price;

        @ManyToMany(mappedBy = "Users")
        private List<Users> users;






}
