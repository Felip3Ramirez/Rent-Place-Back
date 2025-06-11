package com.example.RentPlace.controladores;

import com.example.RentPlace.modelos.Reserva;
import com.example.RentPlace.servicios.ReservaServicio;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reserva")

public class ControladorReserva {

    @Autowired
    ReservaServicio reservaServicio;

    //Guardar
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Reserva datos) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.reservaServicio.guardarReserva(datos));

        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    //Buscar todos
    @GetMapping
    public ResponseEntity<?> buscarTodos() {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.reservaServicio.buscarTodasReservas());

        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    //Buscar Id
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarId(@PathVariable Long id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.reservaServicio.buscarReservaPorId(id));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    //Modificar
    @PutMapping("/{id}")
    public ResponseEntity<?> modificar(@PathVariable Long id, @RequestBody Reserva datos) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.reservaServicio.modificarReserva(id, datos));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    //Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.reservaServicio.eliminarReserva(id));

        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}