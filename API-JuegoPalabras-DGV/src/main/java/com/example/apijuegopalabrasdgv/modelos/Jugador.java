package com.example.apijuegopalabrasdgv.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "jugador")
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idjugador")
    private Long idjugador;

    @Column(name = "user")
    private String user;

    @Column(name = "score")
    private Integer score = 0;

    @Column(name = "avatarimg")
    private String avatarimg;

    @ManyToOne
    @JoinColumn(name = "partida_idpartida")
    private Partida partida;

}
