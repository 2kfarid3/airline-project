package inha.edu.kr.airlineproject.dto;

public record AirplaneUpdateRequestDto(
        Integer totalNumberOfSeats,
        String airplaneTypeName
) {}

