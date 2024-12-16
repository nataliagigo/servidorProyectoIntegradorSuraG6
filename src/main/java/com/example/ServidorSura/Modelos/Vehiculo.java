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

        @Column(name = "placa", nullable = false)
        private String placa;
        private String modelo;
        private String cilindraje;
        private String marca;
        private String descripcion;
        private Integer numerosIniestros;
        private Float valorSeguro;
        private String tipoSeguro;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id")
    private Usuario usuario;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Planes planes;

    public Vehiculo() {
    }

    public Vehiculo(Long id, String placa, String modelo, String cilindraje, String marca, String descripcion, Integer numerosIniestros, Float valorSeguro, String tipoSeguro) {
        this.id = id;
        this.placa = placa;
        this.modelo = modelo;
        this.cilindraje = cilindraje;
        this.marca = marca;
        this.descripcion = descripcion;
        this.numerosIniestros = numerosIniestros;
        this.valorSeguro = valorSeguro;
        this.tipoSeguro = tipoSeguro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Float getValorSeguro() {
        return valorSeguro;
    }

    public void setValorSeguro(Float valorSeguro) {
        this.valorSeguro = valorSeguro;
    }

    public String getTipoSeguro() {
        return tipoSeguro;
    }

    public void setTipoSeguro(String tipoSeguro) {
        this.tipoSeguro = tipoSeguro;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
