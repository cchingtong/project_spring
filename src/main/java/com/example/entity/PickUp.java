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
@Table(name = "tp_pickup")
public class PickUp extends BaseEntity {

    private String pickup_place;

    @ManyToMany
    @JoinTable(
            name = "tp_rent_by_pickup",
            joinColumns = @JoinColumn(name = "pickup_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "rent_by_id",referencedColumnName = "id")

    ) private List<Rent_By> rent_by ;


}

