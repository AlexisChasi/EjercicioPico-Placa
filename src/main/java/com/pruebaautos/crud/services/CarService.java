package com.pruebaautos.crud.services;

import com.pruebaautos.crud.entities.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {
    Car saveCar (Car car);
    Car updateCar (Car car);
    List<Car> getCars();
    // metodo para buscar auto por identificador
    Optional<Car> getCarById (Long id);
    void deleteCar(Long id);
}
