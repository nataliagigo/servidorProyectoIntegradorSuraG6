package com.example.ServidorSura.Servicios;


import com.example.ServidorSura.Modelos.Planes;
import com.example.ServidorSura.Modelos.Usuario;
import com.example.ServidorSura.Repositorios.IPlanesRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.plaf.metal.MetalBorders;
import java.util.List;
import java.util.Optional;

@Service
public class PlanesServicio {
    //Llamando al repositorio de usuario
    @Autowired
    IPlanesRepositorio iPlanesRepositorio;

    //SE crean metodos para definir las operaciones
    //a realizar en la BD

    //1. Registar o guardar un Plan
    public Planes guardarPlan(Planes datosPlan)throws Exception{
        try{
            return iPlanesRepositorio.save(datosPlan);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //2. Buscar todos los planes
    public List<Planes> buscarPlanes()throws Exception{
        try{
            return iPlanesRepositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    public Planes buscarPlanPorId(Long id) throws Exception{
        try{

            Optional<Planes> planEncontrado=iPlanesRepositorio.findById(id);
            if(planEncontrado.isPresent()){
                return planEncontrado.get();
            }else{
                throw new Exception("plan no encontrado");
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
