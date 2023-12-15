package com.example.apijuegopalabrasdgv.repo;

import com.example.apijuegopalabrasdgv.modelos.Jugador;
import com.example.apijuegopalabrasdgv.modelos.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JuegoRepositorio extends JpaRepository<Jugador ,Long> {

}
