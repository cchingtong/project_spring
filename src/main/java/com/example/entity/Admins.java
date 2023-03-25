package com.example.entity;

import com.example.entity.mapperclass.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tp_admins")
public class Admins extends BaseEntity {

    private long admin_id;
    private long role_id;
    private String username;
    private String email;
    private String address;

}
