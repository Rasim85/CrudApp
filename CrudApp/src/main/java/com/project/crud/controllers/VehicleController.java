package com.project.crud.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class VehicleController {
    private final VehicleService vehicleService;

    public ResponseEntity<List<VehicleDto>> allVehicles() {
        return ResponseEntity.ok(vehicleService.allVehicles());
    }

}
