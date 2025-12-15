package inha.edu.kr.airlineproject.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "airplane_type")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AirplaneType {

    @Id
    @Column(name = "airplane_type_name", length = 50)
    private String airplaneTypeName;

    @Column(name = "max_seats", nullable = false)
    private Integer maxSeats;

    @Column(name = "company")
    private String company;

    @OneToMany(mappedBy = "airplaneType", cascade = CascadeType.ALL)
    private List<Airplane> airplanes = new ArrayList<>();

    @OneToMany(mappedBy = "airplaneType", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CanLand> canLandAirports = new ArrayList<>();

    public String getAirplaneTypeName() {
        return airplaneTypeName;
    }

    public void setAirplaneTypeName(String airplaneTypeName) {
        this.airplaneTypeName = airplaneTypeName;
    }

    public Integer getMaxSeats() {
        return maxSeats;
    }

    public void setMaxSeats(Integer maxSeats) {
        this.maxSeats = maxSeats;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public List<Airplane> getAirplanes() {
        return airplanes;
    }

    public void setAirplanes(List<Airplane> airplanes) {
        this.airplanes = airplanes;
    }

    public List<CanLand> getCanLandAirports() {
        return canLandAirports;
    }

    public void setCanLandAirports(List<CanLand> canLandAirports) {
        this.canLandAirports = canLandAirports;
    }
}

