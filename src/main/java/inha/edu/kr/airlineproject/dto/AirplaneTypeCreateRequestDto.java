package inha.edu.kr.airlineproject.dto;

import jakarta.validation.constraints.*;

public record AirplaneTypeCreateRequestDto(
        String airplaneTypeName,
        Integer maxSeats,
        String company
) {}

