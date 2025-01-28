package com.juan.reservanatural.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.util.Date;

public record AnimalDto(
        @NotBlank(message = "El nombre no puede estar vacío")
        @Size(max = 100, message = "El nombre no puede superar los 100 caracteres")
                String nombre,

                        @NotBlank(message = "El tipo no puede estar vacío")
                        String tipo,

                        @NotBlank(message = "La familia no puede estar vacía")
                        String familia,

                        @NotBlank(message = "El género no puede estar vacío")
                        String genero,

                        @NotBlank(message = "El país de origen no puede estar vacío")
                        String paisOrigen,

                        @NotNull(message = "La fecha de ingreso no puede estar vacía")
                        @PastOrPresent(message = "La fecha de ingreso debe ser pasada o presente")
                        Date fechaIngreso,

                        String imagen // Puede ser opcional

){}



