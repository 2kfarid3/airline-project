package inha.edu.kr.airlineproject.service;

import inha.edu.kr.airlineproject.dto.AirplaneTypeCreateRequestDto;
import inha.edu.kr.airlineproject.dto.AirplaneTypeUpdateRequestDto;

public interface IAirplaneTypeService {
    void create(AirplaneTypeCreateRequestDto dto);
    void update(String airplaneTypeName, AirplaneTypeUpdateRequestDto dto);
    void delete(String airplaneTypeName);
}
