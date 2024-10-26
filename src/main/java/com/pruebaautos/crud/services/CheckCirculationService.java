package com.pruebaautos.crud.services;

import com.pruebaautos.crud.entities.Car;

import java.time.LocalDateTime;
import java.util.Optional;

public interface CheckCirculationService {

    Optional<Car> getCarByLicensePlate(String licensePlate);
    String checkIfCanCirculate(String licensePlate, LocalDateTime fechaConsulta);
}
