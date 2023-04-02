package com.example.entity;

import com.example.entity.mapperclass.BaseEntity;
import com.example.entity.enums.GenderEnum;
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
@Table(name = "tp_driver")
public class Driver extends BaseEntity{
    private String fname;
    private String lname;
    private int age;
    @Enumerated(EnumType.STRING)
    private GenderEnum genderEnum;

    private int number_phone;
    private String identity_card;
    private String address;

    @OneToMany(mappedBy = "driver")
    private List<Booking> bookings;
}
