package inha.edu.kr.airlineproject.entity.id;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
public class LegInstanceId implements Serializable {

    @Embedded
    private FlightLegId flightLegId;

    private LocalDate date;

    public LegInstanceId() {}

    public LegInstanceId(FlightLegId flightLegId, LocalDate date) {
        this.flightLegId = flightLegId;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LegInstanceId that = (LegInstanceId) o;
        return java.util.Objects.equals(flightLegId, that.flightLegId)
                && java.util.Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(flightLegId, date);
    }
}

