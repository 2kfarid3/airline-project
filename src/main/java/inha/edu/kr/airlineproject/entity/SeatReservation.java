package inha.edu.kr.airlineproject.entity;

import inha.edu.kr.airlineproject.entity.id.SeatReservationId;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "seat_reservation")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SeatReservation {

    @EmbeddedId
    private SeatReservationId id;

    @MapsId("legInstanceId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "flight_number", referencedColumnName = "flight_number", nullable = false),
            @JoinColumn(name = "leg_number", referencedColumnName = "leg_number", nullable = false),
            @JoinColumn(name = "date", referencedColumnName = "date", nullable = false)
    })
    private LegInstance legInstance;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Column(name = "customer_phone", nullable = false)
    private String customerPhone;
}

