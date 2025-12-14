package inha.edu.kr.airlineproject.dto;

public record AirplaneCreateRequestDto(
        String airplaneId,
        Integer totalNumberOfSeats,
        String airplaneTypeName
) {}
