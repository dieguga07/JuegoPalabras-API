package com.example.apijuegopalabrasdgv.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "equipo")
public class Equipo {

    @Id
    @Column(name = "idequipo")
    private Long idequipo;

    @Column(name = "name")
    private String name;

    @Column(name = "score")
    private Integer score;

    @Column(name = "badge")
    private String badge;

    @ManyToOne
    @JoinColumn(name = "jugador_idjugador")
    private Jugador jugador;

}

