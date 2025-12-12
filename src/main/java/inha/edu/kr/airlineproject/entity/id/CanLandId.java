package inha.edu.kr.airlineproject.entity.id;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CanLandId implements Serializable {

    @Column(name = "airplane_type_name", length = 50)
    private String airplaneTypeName;

    @Column(name = "airport_code", length = 10)
    private String airportCode;

    public CanLandId() {}
    public CanLandId(String airplaneTypeName, String airportCode) {
        this.airplaneTypeName = airplaneTypeName;
        this.airportCode = airportCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CanLandId)) return false;
        CanLandId that = (CanLandId) o;
        return Objects.equals(airplaneTypeName, that.airplaneTypeName) &&
                Objects.equals(airportCode, that.airportCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airplaneTypeName, airportCode);
    }
}

