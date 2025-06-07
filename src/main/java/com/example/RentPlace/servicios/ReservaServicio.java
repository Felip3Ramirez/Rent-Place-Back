package com.example.RentPlace.servicios;

import com.example.RentPlace.modelos.Reserva;
import com.example.RentPlace.repositorios.IReservaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaServicio {
    @Autowired
    IReservaRepositorio repositorio;

    //Listar los metodos que activaran las consultas en la base de datos
    //Guardar
    public Reserva guardarReserva(Reserva datosReserva) throws Exception {
        try {
            //validar los datos de entrada
            return this.repositorio.save(datosReserva);
        } catch(Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //Buscar todos los registros
    public List<Reserva> buscarTodasReservas() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //Buscar por ID
    public Reserva buscarReservaPorId(Long idReserva) throws Exception {
        try {
            Optional<Reserva> reservaBuscada = this.repositorio.findById(idReserva);
            if (reservaBuscada.isPresent()) {
                return reservaBuscada.get();
            } else {
                throw new Exception("la reserva consultada no esta en la BD");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //Modificar por ID
    public Reserva modificarReserva(Long idReserva, Reserva datosReserva) throws Exception {
        try {
            Optional<Reserva> reservaBuscada = this.repositorio.findById(idReserva);
            if (reservaBuscada.isPresent()) {
                reservaBuscada.get().setUsuario(datosReserva.getUsuario());
                reservaBuscada.get().setPropiedad(datosReserva.getPropiedad());
                reservaBuscada.get().setFechaInicio(datosReserva.getFechaInicio());
                reservaBuscada.get().setFechaFin(datosReserva.getFechaFin());
                return this.repositorio.save(reservaBuscada.get());
            } else {
                throw new Exception("Reserva no encontrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //Eliminar por ID
    public boolean eliminarReserva(Long id) throws Exception {
        try {
            Optional<Reserva> reservaBuscada = this.repositorio.findById(id);
            if (reservaBuscada.isPresent()) {
                this.repositorio.deleteById(id);
                return true;
            } else {
                throw new Exception("Reserva no encontrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}