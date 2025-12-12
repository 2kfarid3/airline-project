package inha.edu.kr.airlineproject.entity.id;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FareId implements Serializable {

    @Column(name = "flight_number", length = 20)
    private String flightNumber;

    @Column(name = "fare_code", length = 20)
    private String fareCode;

    public FareId() {}
    public FareId(String flightNumber, String fareCode) {
        this.flightNumber = flightNumber;
        this.fareCode = fareCode;
    }

    // getters/setters, equals/hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FareId)) return false;
        FareId that = (FareId) o;
        return Objects.equals(flightNumber, that.flightNumber) &&
                Objects.equals(fareCode, that.fareCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightNumber, fareCode);
    }
}

