package inha.edu.kr.airlineproject.entity.id;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Embeddable
public class SeatReservationId implements Serializable {

    @Embedded
    private LegInstanceId legInstanceId;

    @Column(name = "seat_number", length = 10)
    private String seatNumber;

    public SeatReservationId() {
    }

    public SeatReservationId(LegInstanceId legInstanceId, String seatNumber) {
        this.legInstanceId = legInstanceId;
        this.seatNumber = seatNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SeatReservationId that = (SeatReservationId) o;

        if (!legInstanceId.equals(that.legInstanceId)) return false;
        return seatNumber.equals(that.seatNumber);
    }

    @Override
    public int hashCode() {
        int result = legInstanceId.hashCode();
        result = 31 * result + seatNumber.hashCode();
        return result;
    }
}

