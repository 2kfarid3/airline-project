package inha.edu.kr.airlineproject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "flight")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Flight {

    @Id
    @Column(name = "flight_number", length = 20)
    private String flightNumber;

    @Column(name = "airline", nullable = false)
    private String airline;

    @Column(name = "weekdays")
    private String weekdays;

    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FlightLeg> legs = new ArrayList<>();

    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Fare> fares = new ArrayList<>();
}

