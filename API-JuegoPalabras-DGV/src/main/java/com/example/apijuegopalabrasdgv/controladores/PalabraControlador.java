package com.example.apijuegopalabrasdgv.controladores;
import com.example.apijuegopalabrasdgv.modelos.Palabra;
import com.example.apijuegopalabrasdgv.repo.PalabraRepositorio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class PalabraControlador {

    private final PalabraRepositorio palabraRepositorio;

    public PalabraControlador(PalabraRepositorio palabraRepositorio) {
        this.palabraRepositorio = palabraRepositorio;
    }



    @GetMapping("/palabras")
    public Palabra obtenerPalabra(
            @RequestParam(required = false) String empiezaCon,
            @RequestParam(required = false) String terminaCon,
            @RequestParam(required = false) String contiene) {

        List<Palabra> palabras = palabraRepositorio.findAll();

        if (empiezaCon != null) {
            palabras.removeIf(palabra -> !palabra.getPalabra().startsWith(empiezaCon));
        }

        if (terminaCon != null) {
            palabras.removeIf(palabra -> !palabra.getPalabra().endsWith(terminaCon));
        }

        if (contiene != null) {
            palabras.removeIf(palabra -> !palabra.getPalabra().contains(contiene));
        }

        // Barajamos la lista
        Collections.shuffle(palabras);

        // Devolvemos al menos una palabra
        return palabras.isEmpty() ? null : palabras.get(0);
    }
}
