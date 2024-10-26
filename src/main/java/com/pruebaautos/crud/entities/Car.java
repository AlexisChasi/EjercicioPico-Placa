package com.pruebaautos.crud.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "La licencia es requerida")
    @Size(min = 7, max = 7, message = "La licencia debe tener 7 caracteres")
    private String licensePlate;

    @NotBlank(message = "El color es requerido")
    private String color;

    @NotBlank(message = "El modelo es requerido")
    private String model;

    @NotBlank(message = "El numero de chasis es requerido")
    private String chassis;

    @NotBlank(message = "El dueño es requerido")
    private String owner;
}
