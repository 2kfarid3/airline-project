package inha.edu.kr.airlineproject.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "airplane_type")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AirplaneType {

    @Id
    @Column(name = "airplane_type_name", length = 50)
    private String airplaneTypeName;

    @Column(name = "max_seats", nullable = false)
    private Integer maxSeats;

    @Column(name = "company")
    private String company;

    @OneToMany(mappedBy = "airplaneType", cascade = CascadeType.ALL)
    private List<Airplane> airplanes = new ArrayList<>();

    @OneToMany(mappedBy = "airplaneType", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CanLand> canLandAirports = new ArrayList<>();
}

