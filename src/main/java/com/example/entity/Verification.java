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
@Table(name = "tp_verification")
public class Verification extends BaseEntity {

   private String verify_identify_number;
   private String selfie_url;
   private String verify_driving_license;
   private String address;

    @OneToOne(mappedBy = "user_id")
    private Users user;

}
