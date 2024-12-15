package com.example.ServidorSura.Repositorios;

import com.example.ServidorSura.Modelos.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
//El long que esta hay es el tipo de dato del Id.
public interface IVehiculosRepositorio extends JpaRepository <Vehiculo, String> {
}
