package com.example.apijuegopalabrasdgv.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

@Table(name = "juego")
public class Juego {

    @Id
    @Column(name = "idjuego")
    private Long idjuego;

    @Column(name = "description")
    private String description;

    @Column(name = "difficulty_J")
    private String difficulty_J;

    @Column(name = "max_tries")
    private Integer max_tries;

    @ManyToOne
    @JoinColumn(name = "partida_idpartida")
    private Partida partida;

}