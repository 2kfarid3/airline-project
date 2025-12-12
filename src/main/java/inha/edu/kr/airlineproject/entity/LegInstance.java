package inha.edu.kr.airlineproject.entity;

import inha.edu.kr.airlineproject.entity.id.LegInstanceId;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "leg_instance")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LegInstance {

    @EmbeddedId
    private LegInstanceId id;

    @MapsId("flightLegId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "flight_number", referencedColumnName = "flight_number", nullable = false),
            @JoinColumn(name = "leg_number", referencedColumnName = "leg_number", nullable = false)
    })
    private FlightLeg flightLeg;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airplane_id", nullable = false)
    private Airplane airplane;

    @Column(name = "number_of_available_seats", nullable = false)
    private Integer numberOfAvailableSeats;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departure_airport_code", nullable = false)
    private Airport departureAirport;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "arrival_airport_code", nullable = false)
    private Airport arrivalAirport;

    @Column(name = "departure_time")
    private LocalTime departureTime;

    @Column(name = "arrival_time")
    private LocalTime arrivalTime;

    @OneToMany(mappedBy = "legInstance", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SeatReservation> reservations = new ArrayList<>();
}

