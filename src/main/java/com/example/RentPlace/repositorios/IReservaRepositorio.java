package com.example.RentPlace.repositorios;

import com.example.RentPlace.modelos.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReservaRepositorio extends JpaRepository<Reserva, Long> {

}