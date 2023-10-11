package com.project.crud.mappers;

import com.project.crud.dtos.VehicleDto;
import com.project.crud.entities.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VehicleMapper {
    Vehicle toVehicle(VehicleDto vehicleDto);

    VehicleDto toVehicleDto(Vehicle vehicle);

    List<VehicleDto> toVehicleDtos(List<Vehicle> vehicles);

    List<Vehicle> toVehicles(List<VehicleDto> vehicleDtos);

    void updateVehicle(@MappingTarget Vehicle target, Vehicle source);
}
