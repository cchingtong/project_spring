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
@Table(name = "tp_MotorRent_by")

public class MotorRent_By extends BaseEntity {
    private Timestamp pickup_date;
    private Timestamp return_date;

//    @ManyToMany(mappedBy = "Users")
//    private List<Users> users;

//    @OneToOne(mappedBy = "MotorRent_By")
//    private MotorRent_invoice motorRent_invoice;
    @ManyToMany
    @JoinTable(
            name = "tp_MotorRent_by_motor",
            joinColumns = @JoinColumn(name = "motor_rent_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "moto_id",referencedColumnName = "id")
    ) private List<MotorRent_By> MotorRent_by;

//    @ManyToMany(mappedBy = "PickUp")
//    private List<PickUp> pickup;

}
