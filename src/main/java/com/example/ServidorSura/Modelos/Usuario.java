package com.example.ServidorSura.Modelos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
//Para cambiarle el nombre a la tabla y no sea el por defecto de la class
@Table(name = "usuarios")
public class Usuario {
    @Id
    //el identity para que sea auto incremental
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //cambiamos el nombre y tampoco puede ser null
    @Column(name = "documento", nullable = false, length = 20)
    private String cedula;
    private String nombres;
    private String telefono;
    private String direccion;
    private String correo;
    private String contrasena;
    private LocalDate fechaNacimiento;

    //LAS RELACIONES SERAN NUEVOS ATRIBUTOS
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Vehiculo> vehiculos = new ArrayList<>();

    public Usuario() {
    }
    public Usuario(Long id, String cedula, String nombres, String telefono, String direccion, String correo, String contrasena, LocalDate fechaNacimiento) {
        this.id = id;
        this.cedula = cedula;
        this.nombres = nombres;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
        this.contrasena = contrasena;
        this.fechaNacimiento = fechaNacimiento;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
