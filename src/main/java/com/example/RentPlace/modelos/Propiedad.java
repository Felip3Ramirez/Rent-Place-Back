package com.example.RentPlace.modelos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "propiedad")
@JsonIgnoreProperties({"reservas"})
public class Propiedad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(length = 255)
    private String nombre;

    @Column(name = "ubicacion", length = 255)
    private String ubicacion;

    @Column(precision = 10, scale = 2)
    private BigDecimal precio;

    @Column(columnDefinition = "TEXT")
    private String detalles;

    @Column(columnDefinition = "LONGTEXT")
    @Lob
    private String foto;

    @OneToMany(mappedBy = "propiedad")
    @JsonManagedReference(value = "propiedadreservas")
    private List<Reserva> reservas;

    public Propiedad() {
    }

    public Propiedad(Long id, String nombre, String ubicacion, BigDecimal precio, String detalles, String foto) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.precio = precio;
        this.detalles = detalles;
        this.foto = foto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}