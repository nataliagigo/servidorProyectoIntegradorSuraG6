package com.example.ServidorSura.Repositorios;


import com.example.ServidorSura.Modelos.Planes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlanesRepositorio extends JpaRepository<Planes, Long> {
}
