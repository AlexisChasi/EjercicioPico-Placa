package com.pruebaautos.crud.controllers;

import com.pruebaautos.crud.entities.Car;
import com.pruebaautos.crud.services.CarServiceImpl;

import com.pruebaautos.crud.services.CheckCirculationService;
import com.pruebaautos.crud.services.CheckCirculationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/car")
@CrossOrigin("${frontend.url}")
public class CarController {
    @Autowired
    CarServiceImpl carServiceimpl;

    @Autowired
    CheckCirculationServiceImpl checkCirculationServiceimpl;

    @PostMapping
    public ResponseEntity<Car> saveCar(@RequestBody Car car){
        try{
            Car savedCar = carServiceimpl.saveCar(car);
            return new ResponseEntity<>(savedCar, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<Car> updateCar(@RequestBody Car car){
        try{
            Car savedCar = carServiceimpl.updateCar(car);
            return new ResponseEntity<>(savedCar, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Car>> getAllCars(){
        return new ResponseEntity<>(carServiceimpl.getCars(),HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id){
        Optional<Car> car = carServiceimpl.getCarById(id);
        return car.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id){
        Optional<Car> car = carServiceimpl.getCarById(id);
        if (car.isPresent()){
            carServiceimpl.deleteCar(car.get().getId());
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @GetMapping("/check-circulation")
    public ResponseEntity<String> checkCirculation(@RequestParam String licensePlate, @RequestParam LocalDateTime fechaConsulta) {
        Optional<Car> car = checkCirculationServiceimpl.getCarByLicensePlate(licensePlate);
        if (!car.isPresent()) {
            return new ResponseEntity<>("El vehículo con la placa " + licensePlate + " no está registrado.", HttpStatus.NOT_FOUND);
        }

        // Llama al método que verifica si puede circular
        String mensaje = checkCirculationServiceimpl.checkIfCanCirculate(licensePlate, fechaConsulta);

        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

}
