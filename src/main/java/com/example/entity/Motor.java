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
@Table(name = "tp_Motor")
public class Motor extends BaseEntity{
    private String company;
    private String model_year;
    private String plate_number;

//    @ManyToMany(mappedBy = "MotorRent_By")
//    private List<MotorRent_By> MotorRent_by;
}
