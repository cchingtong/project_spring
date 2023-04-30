package com.example.entity;

import com.example.entity.mapperclass.BaseEntity;
import com.example.entity.Booking;
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
@Table(name = "tp_invoice")
public class Invoice extends BaseEntity {

    private String duration;
    private String distance;
    private double total_price;

    @OneToOne
    @JoinColumn(name = "booking_id", referencedColumnName = "id")
    private Booking booking;

}
