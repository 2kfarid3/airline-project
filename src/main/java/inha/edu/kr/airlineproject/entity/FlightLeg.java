package inha.edu.kr.airlineproject.entity;

import inha.edu.kr.airlineproject.entity.id.FlightLegId;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "flight_leg")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FlightLeg {

    @EmbeddedId
    private FlightLegId id;

    @MapsId("flightNumber")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_number", nullable = false)
    private Flight flight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departure_airport_code", nullable = false)
    private Airport departureAirport;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "arrival_airport_code", nullable = false)
    private Airport arrivalAirport;

    @Column(name = "scheduled_departure_time", nullable = false)
    private LocalTime scheduledDepartureTime;

    @Column(name = "scheduled_arrival_time", nullable = false)
    private LocalTime scheduledArrivalTime;

    @OneToMany(mappedBy = "flightLeg", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LegInstance> instances = new ArrayList<>();
}

