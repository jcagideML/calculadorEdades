package com.bootcampML.calculadoraDeEdades;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

@RestController
public class CalculadorEdadesController {

    @GetMapping("/{dia}/{mes}/{anio}")
    public String calcularEdad(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer anio) {
        if (dia > 1 & dia <= 31 && mes > 1 & mes <= 12) {
            Integer diaActual = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
            Integer mesActual = Calendar.getInstance().get(Calendar.MONTH) + 1;
            Integer anioActual = Calendar.getInstance().get(Calendar.YEAR);

            int edad = anioActual - anio;

            if (mesActual - mes < 0) {
                edad = edad - 1;
            } else if (mesActual - mes == 0) {
                if (diaActual - dia < 0) {
                    edad = edad - 1;
                }
            }

            return "La edad es: " + edad;
        }

        return "La fecha ingresada es inválida";
    }
}