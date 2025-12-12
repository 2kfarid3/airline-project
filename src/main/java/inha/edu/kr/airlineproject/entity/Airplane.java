package inha.edu.kr.airlineproject.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "airplane")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Airplane {

    @Id
    @Column(name = "airplane_id", length = 20)
    private String airplaneId;

    @Column(name = "total_number_of_seats", nullable = false)
    private Integer totalNumberOfSeats;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airplane_type", nullable = false)
    private AirplaneType airplaneType;
}

