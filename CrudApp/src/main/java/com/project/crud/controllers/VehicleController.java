package com.project.crud.controllers;

import com.project.crud.dtos.VehicleDto;
import com.project.crud.services.VehicleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class VehicleController {
    private final VehicleService vehicleService;

    @GetMapping("/vehicles")
    public ResponseEntity<List<VehicleDto>> allVehicles() {
        return ResponseEntity.ok(vehicleService.allVehicles());
    }

    @GetMapping("/vehicles/{id}")
    public ResponseEntity<VehicleDto> getVehicle(@PathVariable Long id) {
        return ResponseEntity.ok(vehicleService.getVehicle(id));
    }

    @PostMapping("/vehicles")
    public ResponseEntity<VehicleDto> createVehicle(@Valid @RequestBody VehicleDto vehicleDto) {
        VehicleDto createdVehicle = vehicleService.createVehicle(vehicleDto);
        return ResponseEntity.created(URI.create("/vehicles/" + createdVehicle.getId())).body(createdVehicle);
    }

    @DeleteMapping("/vehicles/{id}")
    public ResponseEntity<VehicleDto> deleteVehicle(@PathVariable Long id) {
        return ResponseEntity.ok(vehicleService.deleteVehicle(id));
    }

    @PutMapping("/vehicles/{id}")
    public ResponseEntity<VehicleDto> updateVehicle(@PathVariable Long id, @Valid @RequestBody VehicleDto vehicleDto) {
        return ResponseEntity.ok(vehicleService.updateVehicle(id, vehicleDto));
    }

    @PatchMapping("/vehicles/{id}")
    public ResponseEntity<VehicleDto> patchVehicle(@PathVariable Long id, @RequestBody VehicleDto vehicleDto) {
        return ResponseEntity.ok(vehicleService.patchVehicle(id, vehicleDto));
    }
}
