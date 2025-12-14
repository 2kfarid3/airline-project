package inha.edu.kr.airlineproject.controller;

import inha.edu.kr.airlineproject.dto.ApiResponse;
import inha.edu.kr.airlineproject.dto.AirplaneCreateRequestDto;
import inha.edu.kr.airlineproject.dto.AirplaneUpdateRequestDto;
import inha.edu.kr.airlineproject.service.IAirplaneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/airplanes")
public class AdminAirplaneController {

    private final IAirplaneService airplaneService;

    public AdminAirplaneController(IAirplaneService airplaneService) {
        this.airplaneService = airplaneService;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> create(@RequestBody AirplaneCreateRequestDto dto) {
        airplaneService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse("Airplane created successfully"));
    }

    @PutMapping("/{airplaneId}")
    public ResponseEntity<ApiResponse> update(@PathVariable String airplaneId,
                                              @RequestBody AirplaneUpdateRequestDto dto) {
        airplaneService.update(airplaneId, dto);
        return ResponseEntity.ok(new ApiResponse("Airplane updated successfully"));
    }

    @DeleteMapping("/{airplaneId}")
    public ResponseEntity<ApiResponse> delete(@PathVariable String airplaneId) {
        airplaneService.delete(airplaneId);
        return ResponseEntity.ok(new ApiResponse("Airplane deleted successfully"));
    }
}
