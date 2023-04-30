package com.example.entity;

import com.example.entity.mapperclass.BaseEntity;
import com.example.entity.Users;
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
@Table(name = "tp_verification")
public class Verification extends BaseEntity {

   private String verify_identify_number;
   private String selfie_url;
   private String verify_driving_license;
   private String address;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Users users;

}
