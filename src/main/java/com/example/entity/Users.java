package com.example.entity;

import com.example.entity.enums.GenderEnum;
import com.example.entity.mapperclass.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tp_users")
public class Users extends BaseEntity {
    private String user_fname;
    private String user_lname;

    @Enumerated(EnumType.STRING)
    private GenderEnum genderEnum;

    private int age;
    private int number_phone;
    private String email;
    private String is_verified;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

    @ManyToMany
    @JoinTable(
            name = "tp_user_rent_by",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "rent_by_id", referencedColumnName = "id")
    ) private List<Users> Users; ;


    @OneToOne(mappedBy = "users")
    private Verification verification;
}
