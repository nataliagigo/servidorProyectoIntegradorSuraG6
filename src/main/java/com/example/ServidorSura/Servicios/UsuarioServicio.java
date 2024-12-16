package com.example.ServidorSura.Servicios;

import com.example.ServidorSura.Modelos.Usuario;
import com.example.ServidorSura.Repositorios.IUsuarioRepositorio;
import com.example.ServidorSura.Repositorios.IVehiculosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio {

    //Llamando al repositorio de usuario
    @Autowired
    IUsuarioRepositorio iUsuarioRepositorio;

    @Autowired
    IVehiculosRepositorio iVehiculosRepositorio;

    //SE crean metodos para definir las operaciones
    //a realizar en la BD


    //1. Registar o guardar un usuario
    public Usuario guardarUsuario(Usuario datosUsuario)throws Exception{
        try{
            return iUsuarioRepositorio.save(datosUsuario);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //2. Buscar todos los usuarios
    public List<Usuario> buscarUsuarios()throws Exception{
        try{
            return iUsuarioRepositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    public Usuario buscarUsuarioPorId(Long id) throws Exception{
        try{

            Optional<Usuario> usuarioEncontrado=iUsuarioRepositorio.findById(id);
            if(usuarioEncontrado.isPresent()){
                return usuarioEncontrado.get();
            }else{
                throw new Exception("usuario no encontrado");
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public void eliminarUsuarios(Long id)throws Exception{
        try{
            iUsuarioRepositorio.deleteById(id);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}


