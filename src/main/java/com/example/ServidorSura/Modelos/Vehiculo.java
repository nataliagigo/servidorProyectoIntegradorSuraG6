package com.example.ServidorSura.Modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "vehiculos")
public class Vehiculo {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String placa;
        private String modelo;
        private String cilindraje;
        private String color;
        private String descripcion;
        private Integer numerosIniestros;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id")
    private Usuario usuario;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planes")
    private Planes planes;

    public Vehiculo() {
    }

    public Vehiculo(Long id, String placa, String modelo, String cilindraje, String color, String descripcion, Integer numerosIniestros) {
        this.id = id;
        this.placa = placa;
        this.modelo = modelo;
        this.cilindraje = cilindraje;
        this.color = color;
        this.descripcion = descripcion;
        this.numerosIniestros = numerosIniestros;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(String cilindraje) {
        this.cilindraje = cilindraje;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getNumerosIniestros() {
        return numerosIniestros;
    }

    public void setNumerosIniestros(Integer numerosIniestros) {
        this.numerosIniestros = numerosIniestros;
    }
}
