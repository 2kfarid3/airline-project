package inha.edu.kr.airlineproject.entity.id;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FlightLegId implements Serializable {

    @Column(name = "flight_number", length = 20)
    private String flightNumber;

    @Column(name = "leg_number")
    private Integer legNumber;

    public FlightLegId() {}
    public FlightLegId(String flightNumber, Integer legNumber) {
        this.flightNumber = flightNumber;
        this.legNumber = legNumber;
    }

    // getters/setters

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlightLegId)) return false;
        FlightLegId that = (FlightLegId) o;
        return Objects.equals(flightNumber, that.flightNumber) &&
                Objects.equals(legNumber, that.legNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightNumber, legNumber);
    }
}

