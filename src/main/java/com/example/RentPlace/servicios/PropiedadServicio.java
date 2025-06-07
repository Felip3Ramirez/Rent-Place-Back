package com.example.RentPlace.servicios;

import com.example.RentPlace.modelos.Propiedad;
import com.example.RentPlace.repositorios.IPropiedadRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropiedadServicio {
    @Autowired
    IPropiedadRepositorio repositorio;

    //Listar los metodos que activaran las consultas en la base de datos
    //Guardar
    public Propiedad guardarPropiedad(Propiedad datosPropiedad) throws Exception {
        try {
            //validar los datos de entrada
            return this.repositorio.save(datosPropiedad);
        } catch(Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //Buscar todos los registros
    public List<Propiedad> buscarTodasPropiedades() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //Buscar por ID
    public Propiedad buscarPropiedadPorId(Long idPropiedad) throws Exception {
        try {
            Optional<Propiedad> propiedadBuscada = this.repositorio.findById(idPropiedad);
            if (propiedadBuscada.isPresent()) {
                return propiedadBuscada.get();
            } else {
                throw new Exception("la propiedad consultada no esta en la BD");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //Modificar por ID
    public Propiedad modificarPropiedad(Long idPropiedad, Propiedad datosPropiedad) throws Exception {
        try {
            Optional<Propiedad> propiedadBuscada = this.repositorio.findById(idPropiedad);
            if (propiedadBuscada.isPresent()) {
                propiedadBuscada.get().setNombre(datosPropiedad.getNombre());
                propiedadBuscada.get().setUbicacion(datosPropiedad.getUbicacion());
                propiedadBuscada.get().setPrecio(datosPropiedad.getPrecio());
                propiedadBuscada.get().setDetalles(datosPropiedad.getDetalles());
                propiedadBuscada.get().setFoto(datosPropiedad.getFoto());
                return this.repositorio.save(propiedadBuscada.get());
            } else {
                throw new Exception("Propiedad no encontrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //Eliminar por ID
    public boolean eliminarPropiedad(Long id) throws Exception {
        try {
            Optional<Propiedad> propiedadBuscada = this.repositorio.findById(id);
            if (propiedadBuscada.isPresent()) {
                this.repositorio.deleteById(id);
                return true;
            } else {
                throw new Exception("Propiedad no encontrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
