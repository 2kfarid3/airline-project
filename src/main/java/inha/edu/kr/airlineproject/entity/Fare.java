package inha.edu.kr.airlineproject.entity;

import inha.edu.kr.airlineproject.entity.id.FareId;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "fare")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Fare {

    @EmbeddedId
    private FareId id;

    @MapsId("flightNumber")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_number", nullable = false)
    private Flight flight;

    @Column(name = "amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @Column(name = "restrictions")
    private String restrictions;
}

