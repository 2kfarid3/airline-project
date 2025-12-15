package inha.edu.kr.airlineproject.controller;

import inha.edu.kr.airlineproject.dto.AirplaneTypeCreateRequestDto;
import inha.edu.kr.airlineproject.dto.AirplaneTypeUpdateRequestDto;
import inha.edu.kr.airlineproject.dto.ApiResponse;
import inha.edu.kr.airlineproject.service.IAirplaneTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/airplane-types")
@RequiredArgsConstructor
public class AirplaneTypeController {

    private final IAirplaneTypeService airplaneTypeService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody AirplaneTypeCreateRequestDto dto) {
        airplaneTypeService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse("AirplaneType created successfully"));
    }

    @PutMapping("/{airplaneTypeName}")
    public ResponseEntity<?> update(
            @PathVariable String airplaneTypeName,
            @RequestBody AirplaneTypeUpdateRequestDto dto
    ) {
        airplaneTypeService.update(airplaneTypeName, dto);
        return ResponseEntity.ok(new ApiResponse("AirplaneType updated successfully"));
    }

    @DeleteMapping("/{airplaneTypeName}")
    public ResponseEntity<?> delete(@PathVariable String airplaneTypeName) {
        airplaneTypeService.delete(airplaneTypeName);
        return ResponseEntity.ok(new ApiResponse("AirplaneType deleted successfully"));
    }
}
