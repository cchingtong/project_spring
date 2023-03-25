package com.example.entity;

//import com.example.entity.mapperclass.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tp_stations")
public class Stations extends BaseEntity {

    private long station_id;
    private String province;
    private String station_name;
    private String station_type;
    private String description;

}
