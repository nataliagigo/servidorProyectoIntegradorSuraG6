package com.example.ServidorSura.Servicios;

import com.example.ServidorSura.Modelos.Usuario;
import com.example.ServidorSura.Modelos.Vehiculo;
import com.example.ServidorSura.Repositorios.IVehiculosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
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
    public List<Vehiculo> ConsultaVehiculos () throws Exception{
        try{
            return iVehiculosRepositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @PostMapping
    public Optional<Vehiculo> ConsultaIndividual(String placa) throws  Exception{
        try{
            return iVehiculosRepositorio.findById(placa);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }


    @GetMapping
    public Vehiculo buscarVehiculoPorPlaca(String placa) throws Exception{
        try{

            Optional<Vehiculo> vehiculoEncontrado=iVehiculosRepositorio.findById(placa);
            if(vehiculoEncontrado.isPresent()){
                return vehiculoEncontrado.get();
            }else{
                throw new Exception("vehiculo no encontrado");
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public List<String> generarPlanesSeguro(String marca, String modelo, int numeroSiniestros) {
        List<String> planes = new ArrayList<>();
        if (numeroSiniestros == 0) {
            planes.add("Plan Básico - Cobertura mínima");
            planes.add("Plan Intermedio - Cobertura media");
            planes.add("Plan Premium - Cobertura total");
        } else if (numeroSiniestros < 3) {
            planes.add("Plan Intermedio - Cobertura ajustada");
            planes.add("Plan Avanzado - Cobertura ampliada");
        } else {
            planes.add("Plan Riesgo Alto - Cobertura limitada");
        }
        return planes;
    }

}
