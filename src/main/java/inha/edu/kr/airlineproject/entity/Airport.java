package inha.edu.kr.airlineproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@Entity
@Table(name = "airport")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Airport {

    @Id
    @Column(name = "airport_code", length = 10)
    private String airportCode;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "state")
    private String state;
}
