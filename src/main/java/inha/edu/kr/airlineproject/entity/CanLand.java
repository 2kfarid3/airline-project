package inha.edu.kr.airlineproject.entity;

import inha.edu.kr.airlineproject.entity.id.CanLandId;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "can_land")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CanLand {

    @EmbeddedId
    private CanLandId id;

    @MapsId("airplaneTypeName")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airplane_type_name", nullable = false)
    private AirplaneType airplaneType;

    @MapsId("airportCode")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airport_code", nullable = false)
    private Airport airport;

}

