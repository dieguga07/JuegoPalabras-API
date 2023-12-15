package com.example.apijuegopalabrasdgv.controladores;


import com.example.apijuegopalabrasdgv.modelos.Partida;
import com.example.apijuegopalabrasdgv.repo.EquipoRepositorio;
import com.example.apijuegopalabrasdgv.repo.JuegoRepositorio;
import com.example.apijuegopalabrasdgv.repo.JugadorRepositorio;
import com.example.apijuegopalabrasdgv.repo.PartidaRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping
@RequiredArgsConstructor

public class PartidaControlador {

    @Autowired
    private final PartidaRepositorio partidaRepositorio;

    @Autowired
    private  final JugadorRepositorio jugadorRepositorio;

    @Autowired
    private final JuegoRepositorio juegoRepositorio;

    @Autowired
    private final EquipoRepositorio equipoRepositorio;


    @GetMapping("/partidas")
    public ResponseEntity<?> obtenerAllPartidas(){

        List<Partida> allPartidas = partidaRepositorio.findAll();

        if(allPartidas.isEmpty()){return ResponseEntity.notFound().build();}
        return ResponseEntity.ok(allPartidas);

    }

    @GetMapping("/partidas/{id}")
    public ResponseEntity<?> obtenerPartida(@PathVariable Long id){
        Partida partida = partidaRepositorio.findById(id).orElse(null);

        return (partida == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(partida);
    }
    @DeleteMapping("/partidas/{id}")
    public ResponseEntity<?> eliminarPartida(@PathVariable Long id) {
        Optional<Partida> partidaOptional = partidaRepositorio.findById(id);

        if (partidaOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        partidaRepositorio.deleteById(id);

        return ResponseEntity.ok("Partida eliminada correctamente.");
    }

    @PutMapping("/partidas/{id}")
    //La actualizacion solo se hace en el campo score que es el unico que veo sentido poder editar
    public ResponseEntity<?> actualizarPuntuacionPartida(@PathVariable Long id, @RequestBody Partida partidaActualizada) {
        Optional<Partida> partidaOptional = partidaRepositorio.findById(id);

        if (partidaOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Partida partida = partidaOptional.get();

        partida.setScore(partidaActualizada.getScore());

        partidaRepositorio.save(partida);

        return ResponseEntity.ok(partida);
    }

    @PostMapping("/partidas")
    public ResponseEntity<?> crearPartida(@RequestBody Partida nuevaPartida) {
        // Asegúrate de que el ID de la partida no esté establecido para que se genere automáticamente
        if (nuevaPartida.getIdpartida() != null) {
            return ResponseEntity.badRequest().body("El ID de la partida no debe establecerse manualmente.");
        }
        // Guarda la nueva partida en la base de datos
        Partida partidaGuardada = partidaRepositorio.save(nuevaPartida);

        return ResponseEntity.ok(partidaGuardada);
    }


}
