package com.example.apijuegopalabrasdgv.controladores;
import com.example.apijuegopalabrasdgv.modelos.Jugador;
import com.example.apijuegopalabrasdgv.repo.JugadorRepositorio;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping
@RequiredArgsConstructor
public class JugadorControlador {

    @Autowired
    private JugadorRepositorio jugadorRepositorio;

    @GetMapping("/jugadores")
    public ResponseEntity<?> obtenerAllJugadores(){
        List<Jugador> allJugadores = jugadorRepositorio.findAll();

        if(allJugadores.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(allJugadores);
    }
    @GetMapping("/jugadores/{id}")
    public ResponseEntity<?> obtenerJugador(@PathVariable Long id){
        Jugador jugador = jugadorRepositorio.findById(id).orElse(null);

        return (jugador == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(jugador);
    }


    @PostMapping("/jugadores")
    public ResponseEntity<Jugador> crearJugador(@RequestBody Jugador nuevoJugador) {

        nuevoJugador.setScore(0);

        Jugador jugadorCreado = jugadorRepositorio.save(nuevoJugador);

        return new ResponseEntity<>(jugadorCreado, HttpStatus.CREATED);
    }

    @DeleteMapping("jugadores/{id}")
    public ResponseEntity<?> deleteJugador(@PathVariable Long id) {
        if (jugadorRepositorio.existsById(id)) {
            jugadorRepositorio.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/jugadores/{id}")
    public ResponseEntity<Jugador> actualizarJugador(@PathVariable Long id, @RequestBody Jugador jugadorActualizado) {

        if (!jugadorRepositorio.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        jugadorActualizado.setIdjugador(id);

        Jugador jugadorActualizadoBD = jugadorRepositorio.save(jugadorActualizado);

        return new ResponseEntity<>(jugadorActualizadoBD, HttpStatus.OK);
    }
}