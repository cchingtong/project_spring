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
@Table(name = "tp_car")
public class Car extends BaseEntity {

    private String company;
    private String type;
    private String seat;
    private String plate_number;
    private String model_year;

    @OneToMany(mappedBy = "car")
    private List<Booking> bookings;
}
