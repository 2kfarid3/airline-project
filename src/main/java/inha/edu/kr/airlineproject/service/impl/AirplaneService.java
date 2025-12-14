package inha.edu.kr.airlineproject.service.impl;

import inha.edu.kr.airlineproject.dto.AirplaneCreateRequestDto;
import inha.edu.kr.airlineproject.dto.AirplaneUpdateRequestDto;
import inha.edu.kr.airlineproject.entity.Airplane;
import inha.edu.kr.airlineproject.entity.AirplaneType;
import inha.edu.kr.airlineproject.exception.AirplaneNotFoundException;
import inha.edu.kr.airlineproject.exception.AirplaneTypeNotFoundException;
import inha.edu.kr.airlineproject.exception.InvalidAirplaneException;
import inha.edu.kr.airlineproject.mapper.AirplaneMapper;
import inha.edu.kr.airlineproject.repository.AirplaneRepository;
import inha.edu.kr.airlineproject.repository.AirplaneTypeRepository;
import inha.edu.kr.airlineproject.service.IAirplaneService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AirplaneService implements IAirplaneService {

    private final AirplaneRepository airplaneRepository;
    private final AirplaneTypeRepository airplaneTypeRepository;

    public AirplaneService(AirplaneRepository airplaneRepository,
                           AirplaneTypeRepository airplaneTypeRepository) {
        this.airplaneRepository = airplaneRepository;
        this.airplaneTypeRepository = airplaneTypeRepository;
    }

    @Override
    @Transactional
    public void create(AirplaneCreateRequestDto dto) {
        String airplaneId = normalizeId(dto.airplaneId());

        if (dto.totalNumberOfSeats() == null || dto.totalNumberOfSeats() <= 0) {
            throw new InvalidAirplaneException("totalNumberOfSeats must be > 0");
        }

        if (airplaneRepository.existsById(airplaneId)) {
            throw new InvalidAirplaneException("Airplane already exists: " + airplaneId);
        }

        AirplaneType type = getTypeOrThrow(dto.airplaneTypeName());

        if (type.getMaxSeats() != null && dto.totalNumberOfSeats() > type.getMaxSeats()) {
            throw new InvalidAirplaneException(
                    "totalNumberOfSeats exceeds airplane type maxSeats (" + type.getMaxSeats() + ")"
            );
        }

        Airplane entity = AirplaneMapper.toEntity(
                new AirplaneCreateRequestDto(airplaneId, dto.totalNumberOfSeats(), dto.airplaneTypeName()),
                type
        );

        airplaneRepository.save(entity);
    }

    @Override
    @Transactional
    public void update(String airplaneIdPath, AirplaneUpdateRequestDto dto) {
        String airplaneId = normalizeId(airplaneIdPath);

        Airplane airplane = airplaneRepository.findById(airplaneId)
                .orElseThrow(() -> new AirplaneNotFoundException("Airplane not found: " + airplaneId));

        if (dto.totalNumberOfSeats() == null || dto.totalNumberOfSeats() <= 0) {
            throw new InvalidAirplaneException("totalNumberOfSeats must be > 0");
        }

        AirplaneType type = getTypeOrThrow(dto.airplaneTypeName());

        if (type.getMaxSeats() != null && dto.totalNumberOfSeats() > type.getMaxSeats()) {
            throw new InvalidAirplaneException(
                    "totalNumberOfSeats exceeds airplane type maxSeats (" + type.getMaxSeats() + ")"
            );
        }

        AirplaneMapper.apply(airplane, dto, type);
    }

    @Override
    @Transactional
    public void delete(String airplaneIdPath) {
        String airplaneId = normalizeId(airplaneIdPath);

        if (!airplaneRepository.existsById(airplaneId)) {
            throw new AirplaneNotFoundException("Airplane not found: " + airplaneId);
        }
        airplaneRepository.deleteById(airplaneId);
    }

    private AirplaneType getTypeOrThrow(String airplaneTypeName) {
        if (airplaneTypeName == null || airplaneTypeName.trim().isEmpty()) {
            throw new InvalidAirplaneException("airplaneTypeName is required");
        }
        String name = airplaneTypeName.trim();
        return airplaneTypeRepository.findById(name)
                .orElseThrow(() -> new AirplaneTypeNotFoundException("AirplaneType not found: " + name));
    }

    private String normalizeId(String airplaneId) {
        if (airplaneId == null || airplaneId.trim().isEmpty()) {
            throw new InvalidAirplaneException("airplaneId is required");
        }
        return airplaneId.trim();
    }
}
