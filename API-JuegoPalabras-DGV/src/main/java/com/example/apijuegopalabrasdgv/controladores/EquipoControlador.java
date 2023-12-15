package com.example.apijuegopalabrasdgv.controladores;


import com.example.apijuegopalabrasdgv.modelos.Equipo;
import com.example.apijuegopalabrasdgv.repo.EquipoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor

public class EquipoControlador {

    private final EquipoRepositorio equipoRepositorio;

    // Obtener todos los equipos
    @GetMapping("/equipos")
    public ResponseEntity<?> obtnenerAllEquipos(){
        List<Equipo> equipos = equipoRepositorio.findAll();

        if(equipos.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(equipos);
    }
    // Obtener un equipo por ID
    @GetMapping("/equipos/{id}")
    public ResponseEntity<?> obtenerEquipo(@PathVariable Long id){
        Equipo equipo = equipoRepositorio.findById(id).orElse(null);

        return (equipo == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(equipo);
    }
    // Agregar un nuevo equipo
    @PostMapping("/equipos")
    public ResponseEntity<?> addEquipo(@RequestBody Equipo equipo){
        if(equipo.getScore() != null){
            equipo.setScore(0);
            return ResponseEntity.status(HttpStatus.CREATED).body(equipoRepositorio.save(equipo));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    // Eliminar un equipo por ID
    @DeleteMapping("/equipos/{id}")
    public ResponseEntity<?> deleteEquipo(@PathVariable Long id){
        Equipo deletEquipo = equipoRepositorio.findById(id).orElse(null);

        if(deletEquipo == null){
            return ResponseEntity.notFound().build();
        }

        equipoRepositorio.deleteById(id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(deletEquipo);
    }
    // Actualizar un equipo por ID
    @PutMapping("equipos/{id}")
    public ResponseEntity<?> actualizarEquipo(@RequestBody Equipo newEquipo, @PathVariable Long id){
        Equipo equipo = equipoRepositorio.findById(id).orElse(null);

        if(equipo == null){
            return ResponseEntity.notFound().build();
        }
        // Actualizar solo si los campos son diferentes de nulos
        if (newEquipo.getName() != null) equipo.setName(newEquipo.getName());
        if (newEquipo.getBadge() != null) equipo.setBadge(newEquipo.getBadge());

        equipoRepositorio.save(equipo);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(equipo);
    }

}
