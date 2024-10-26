package com.pruebaautos.crud.services;


import com.pruebaautos.crud.entities.Car;
import com.pruebaautos.crud.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService{

    @Autowired
    CarRepository carRepository;

    @Override
    public Car saveCar(Car car){
        return carRepository.save(car);
    }

    @Override
    public Car updateCar(Car car){
        return carRepository.save(car);
    }

    @Override
    public List<Car> getCars(){
        return carRepository.findAll();
    }

    //obtener auto por id
    @Override
    public Optional<Car> getCarById(Long id){
        return carRepository.findById(id);
    }


    @Override
    public void deleteCar(Long id){
        carRepository.deleteById(id);
    }


}
