package com.example.ServidorSura.Repositorios;

import com.example.ServidorSura.Modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepositorio extends JpaRepository <Usuario, Long>{
}
