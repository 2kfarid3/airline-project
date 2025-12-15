package inha.edu.kr.airlineproject.repository;

import inha.edu.kr.airlineproject.entity.AirplaneType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirplaneTypeRepository extends JpaRepository<AirplaneType, String> {
    boolean existsByAirplaneTypeName(String airplaneTypeName);
}
