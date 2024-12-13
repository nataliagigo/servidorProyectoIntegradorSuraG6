package com.example.ServidorSura.Servicios;

import com.example.ServidorSura.Modelos.Usuario;
import com.example.ServidorSura.Modelos.Vehiculo;
import com.example.ServidorSura.Repositorios.IVehiculosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculoServicio {

    // Autowired sirve para poder inyectar dentro de una clase otra clase.
    @Autowired
    IVehiculosRepositorio iVehiculosRepositorio;
    //Se crean metodos para definir las operaciones a realizar en la base de datos
    public Vehiculo Guarada(Vehiculo datosVehiculos) throws Exception{
        try{
            return iVehiculosRepositorio.save(datosVehiculos);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Consulta
    @GetMapping
    public List<Vehiculo> ConsultaUsuarios () throws Exception{
        try{
            return iVehiculosRepositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @PostMapping
    public Optional<Vehiculo> ConsultaIndividual(Long IdVehiculo) throws  Exception{
        try{
            return iVehiculosRepositorio.findById(IdVehiculo);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }


    @GetMapping
    public Vehiculo buscarVehiculoPorId(Long id) throws Exception{
        try{

            Optional<Vehiculo> vehiculoEncontrado=iVehiculosRepositorio.findById(id);
            if(vehiculoEncontrado.isPresent()){
                return vehiculoEncontrado.get();
            }else{
                throw new Exception("vehiculo no encontrado");
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

}
