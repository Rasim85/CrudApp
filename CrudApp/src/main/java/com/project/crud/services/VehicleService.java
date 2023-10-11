package com.project.crud.services;

import com.project.crud.dtos.VehicleDto;
import com.project.crud.entities.Vehicle;
import com.project.crud.exceptions.AppException;
import com.project.crud.mappers.VehicleMapper;
import com.project.crud.repositories.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final VehicleMapper vehicleMapper;


    public List<VehicleDto> allVehicles() {
        List<Vehicle> all = vehicleRepository.findAll();
        return vehicleMapper.toVehicleDtos(all);
    }

    public VehicleDto getVehicle(Long id) {
        Vehicle vehicle = getVehicleById(id);
        return vehicleMapper.toVehicleDto(vehicle);
    }

    public VehicleDto createVehicle(VehicleDto vehicleDto) {
        Vehicle vehicle = vehicleMapper.toVehicle(vehicleDto);
        Vehicle createdVehicle = vehicleRepository.save(vehicle);
        return vehicleMapper.toVehicleDto(createdVehicle);
    }

    public VehicleDto deleteVehicle(Long id) {
        Vehicle vehicle = getVehicleById(id);
        vehicleRepository.deleteById(id);
        return vehicleMapper.toVehicleDto(vehicle);
    }

    public VehicleDto updateVehicle(Long id, VehicleDto vehicleDto) {
        Vehicle vehicle = getVehicleById(id);
        vehicleMapper.updateVehicle(vehicle, vehicleMapper.toVehicle(vehicleDto));
        Vehicle updatedVehicle = vehicleRepository.save(vehicle);
        return vehicleMapper.toVehicleDto(updatedVehicle);
    }

    public VehicleDto patchVehicle(Long id, VehicleDto vehicleDto) {
        Vehicle vehicle = getVehicleById(id);
        if (vehicleDto.getBrand() != null) {
            vehicle.setBrand(vehicleDto.getBrand());
        }
        if (vehicleDto.getModel() != null) {
            vehicle.setModel(vehicleDto.getModel());
        }
        if (vehicleDto.getColor() != null) {
            vehicle.setColor(vehicleDto.getColor());
        }
        if (vehicleDto.getYear() != 0) {
            vehicle.setYear(vehicleDto.getYear());
        }
        Vehicle savedVehicle = vehicleRepository.save(vehicle);
        return vehicleMapper.toVehicleDto(savedVehicle);
    }

    private Vehicle getVehicleById(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new AppException("Vehicle Not Found", HttpStatus.NOT_FOUND));
        return vehicle;
    }
}
