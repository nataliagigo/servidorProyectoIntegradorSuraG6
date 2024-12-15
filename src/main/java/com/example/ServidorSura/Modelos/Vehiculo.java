package com.example.ServidorSura.Modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "vehiculos")
public class Vehiculo {

        @Id
        private String placa;
        private String modelo;
        private String cilindraje;
        private String marca;
        private String descripcion;
        private Integer numerosIniestros;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id")
    private Usuario usuario;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "placa", referencedColumnName = "id")
    private Planes planes;

    public Vehiculo() {
    }

    public Vehiculo(String placa, String modelo, String cilindraje, String marca, String descripcion, Integer numerosIniestros) {
        this.placa = placa;
        this.modelo = modelo;
        this.cilindraje = cilindraje;
        this.marca = marca;
        this.descripcion = descripcion;
        this.numerosIniestros = numerosIniestros;
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String color) {
        this.marca = marca;
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
