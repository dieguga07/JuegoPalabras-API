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

@Table(name = "partida")
public class Partida {

    @Id
    @Column(name = "idpartida")
    private Long idpartida;

    @Column(name = "word")
    private String word;

    @Column(name = "n_try")
    private Integer n_try;

    @Column(name = "score")
    private Integer score;
}
