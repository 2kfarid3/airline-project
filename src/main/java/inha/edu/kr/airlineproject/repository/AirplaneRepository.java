package inha.edu.kr.airlineproject.repository;

import inha.edu.kr.airlineproject.entity.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirplaneRepository extends JpaRepository<Airplane, String> {
}
