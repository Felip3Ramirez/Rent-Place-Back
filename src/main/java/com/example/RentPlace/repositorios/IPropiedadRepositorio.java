package com.example.RentPlace.repositorios;

import com.example.RentPlace.modelos.Propiedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPropiedadRepositorio extends JpaRepository<Propiedad, Long> {

}