package com.pruebaautos.crud.services;

import com.pruebaautos.crud.entities.Car;
import com.pruebaautos.crud.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CheckCirculationServiceImpl implements CheckCirculationService {

    @Autowired
    CarRepository carRepository;

    @Override
    public Optional<Car> getCarByLicensePlate(String licensePlate) {
        Optional<Car> car = carRepository.findAll().stream()
                .filter(carEntity -> carEntity.getLicensePlate().equalsIgnoreCase(licensePlate))
                .findFirst();

        return car;
    }

    @Override
    public String checkIfCanCirculate(String licensePlate, LocalDateTime fechaConsulta) {
        // Obtén el día de la semana de la fecha de consulta (1 = Lunes, 7 = Domingo)
        int diaDeLaSemana = fechaConsulta.getDayOfWeek().getValue();

        // Define los intervalos de restricción de tiempo (en formato 24 horas)
        LocalDateTime inicioRestriccionManana = fechaConsulta.withHour(7).withMinute(0);
        LocalDateTime finRestriccionManana = fechaConsulta.withHour(9).withMinute(30);
        LocalDateTime inicioRestriccionTarde = fechaConsulta.withHour(16).withMinute(0);
        LocalDateTime finRestriccionTarde = fechaConsulta.withHour(19).withMinute(0);

        // Verifica si la hora de consulta está en alguno de los intervalos de restricción
        boolean enRestriccionManana = !fechaConsulta.isBefore(inicioRestriccionManana) && !fechaConsulta.isAfter(finRestriccionManana);
        boolean enRestriccionTarde = !fechaConsulta.isBefore(inicioRestriccionTarde) && !fechaConsulta.isAfter(finRestriccionTarde);

        // Obtén el último carácter de la placa para determinar su valor numérico
        char ultimoCaracter = licensePlate.charAt(licensePlate.length() - 1);
        int valorUltimoCaracter = Character.getNumericValue(ultimoCaracter);

        // Lógica de restricción basada en día y horario
        switch (diaDeLaSemana) {
            case 1: // Lunes
                if ((valorUltimoCaracter == 1 || valorUltimoCaracter == 2) && (enRestriccionManana || enRestriccionTarde)) {
                    return "El vehículo con la placa " + licensePlate + " NO puede circular hoy (Lunes) de 7:00 a 9:30 o de 16:00 a 19:00.";
                }
                break;
            case 2: // Martes
                if ((valorUltimoCaracter == 3 || valorUltimoCaracter == 4) && (enRestriccionManana || enRestriccionTarde)) {
                    return "El vehículo con la placa " + licensePlate + " NO puede circular hoy (Martes) de 7:00 a 9:30 o de 16:00 a 19:00.";
                }
                break;
            case 3: // Miércoles
                if ((valorUltimoCaracter == 5 || valorUltimoCaracter == 6) && (enRestriccionManana || enRestriccionTarde)) {
                    return "El vehículo con la placa " + licensePlate + " NO puede circular hoy (Miércoles) de 7:00 a 9:30 o de 16:00 a 19:00.";
                }
                break;
            case 4: // Jueves
                if ((valorUltimoCaracter == 7 || valorUltimoCaracter == 8) && (enRestriccionManana || enRestriccionTarde)) {
                    return "El vehículo con la placa " + licensePlate + " NO puede circular hoy (Jueves) de 7:00 a 9:30 o de 16:00 a 19:00.";
                }
                break;
            case 5: // Viernes
                if ((valorUltimoCaracter == 9 || valorUltimoCaracter == 0) && (enRestriccionManana || enRestriccionTarde)) {
                    return "El vehículo con la placa " + licensePlate + " NO puede circular hoy (Viernes) de 7:00 a 9:30 o de 16:00 a 19:00.";
                }
                break;
            // Para sábado y domingo, no hay restricciones
            default:
                return "El vehículo con la placa " + licensePlate + " puede circular hoy.";
        }

        return "El vehículo con la placa " + licensePlate + " puede circular hoy.";
    }
}
