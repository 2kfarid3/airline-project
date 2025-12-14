package inha.edu.kr.airlineproject.service;

import inha.edu.kr.airlineproject.dto.AirplaneCreateRequestDto;
import inha.edu.kr.airlineproject.dto.AirplaneUpdateRequestDto;

public interface IAirplaneService {
    void create(AirplaneCreateRequestDto dto);
    void update(String airplaneId, AirplaneUpdateRequestDto dto);
    void delete(String airplaneId);
}
