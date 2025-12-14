package inha.edu.kr.airlineproject.mapper;

import inha.edu.kr.airlineproject.dto.AirplaneCreateRequestDto;
import inha.edu.kr.airlineproject.dto.AirplaneUpdateRequestDto;
import inha.edu.kr.airlineproject.entity.Airplane;
import inha.edu.kr.airlineproject.entity.AirplaneType;

public final class AirplaneMapper {
    private AirplaneMapper() {}

    public static Airplane toEntity(AirplaneCreateRequestDto dto, AirplaneType type) {
        Airplane a = new Airplane();
        a.setAirplaneId(dto.airplaneId().trim());
        a.setTotalNumberOfSeats(dto.totalNumberOfSeats());
        a.setAirplaneType(type);
        return a;
    }

    public static void apply(Airplane entity, AirplaneUpdateRequestDto dto, AirplaneType type) {
        entity.setTotalNumberOfSeats(dto.totalNumberOfSeats());
        entity.setAirplaneType(type);
    }
}
