package inha.edu.kr.airlineproject.service.impl;

import inha.edu.kr.airlineproject.dto.AirplaneTypeCreateRequestDto;
import inha.edu.kr.airlineproject.dto.AirplaneTypeUpdateRequestDto;
import inha.edu.kr.airlineproject.entity.AirplaneType;
import inha.edu.kr.airlineproject.exception.AirplaneTypeAlreadyExistException;
import inha.edu.kr.airlineproject.exception.AirplaneTypeNotFoundException;
import inha.edu.kr.airlineproject.exception.BadRequestException;
import inha.edu.kr.airlineproject.repository.AirplaneTypeRepository;
import inha.edu.kr.airlineproject.service.IAirplaneTypeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AirplaneTypeService implements IAirplaneTypeService {

    private final AirplaneTypeRepository airplaneTypeRepository;

    @Override
    public void create(AirplaneTypeCreateRequestDto dto) {
        String name = dto.airplaneTypeName().trim();

        if (airplaneTypeRepository.existsById(name)) {
            throw new AirplaneTypeAlreadyExistException("AirplaneType already exists: " + name);
        }
        if (dto.maxSeats() == null || dto.maxSeats() <= 0) {
            throw new BadRequestException("maxSeats must be greater than 0");
        }

        AirplaneType entity = new AirplaneType();
        entity.setAirplaneTypeName(name);
        entity.setMaxSeats(dto.maxSeats());
        entity.setCompany(dto.company());

        airplaneTypeRepository.save(entity);
    }

    @Override
    public void update(String airplaneTypeName, AirplaneTypeUpdateRequestDto dto) {
        AirplaneType entity = airplaneTypeRepository.findById(airplaneTypeName)
                .orElseThrow(() -> new AirplaneTypeNotFoundException("AirplaneType not found: " + airplaneTypeName));

        if (dto.maxSeats() == null || dto.maxSeats() <= 0) {
            throw new BadRequestException("maxSeats must be greater than 0");
        }

        entity.setMaxSeats(dto.maxSeats());
        entity.setCompany(dto.company());

        airplaneTypeRepository.save(entity);
    }

    @Override
    public void delete(String airplaneTypeName) {
        AirplaneType entity = airplaneTypeRepository.findById(airplaneTypeName)
                .orElseThrow(() -> new AirplaneTypeNotFoundException("AirplaneType not found: " + airplaneTypeName));

        airplaneTypeRepository.delete(entity);
    }
}
