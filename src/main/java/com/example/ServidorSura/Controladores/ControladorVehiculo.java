package com.example.ServidorSura.Controladores;

import com.example.ServidorSura.Modelos.Vehiculo;
import com.example.ServidorSura.Repositorios.IVehiculosRepositorio;
import com.example.ServidorSura.Servicios.VehiculoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/vehiculo")
public class ControladorVehiculo {
    @Autowired
    VehiculoServicio vehiculoServicio;
    IVehiculosRepositorio vehiculoRepository;
    @PostMapping
    public ResponseEntity<?> guardar (@RequestBody Vehiculo datos)throws Exception{
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(vehiculoServicio.Guarada(datos));
        }catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> Buscar()throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(vehiculoServicio.ConsultaVehiculos());
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

   @GetMapping("/{placa}")
    public ResponseEntity<?> buscarPorPlaca(@PathVariable String placa) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(vehiculoServicio.buscarVehiculoPorPlaca(placa));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }


    /*
    @GetMapping("/{placa}")
    public ResponseEntity<?> obtenerPlanesSeguro(@PathVariable String placa) {
        try {
            Vehiculo vehiculoOpt =vehiculoServicio.buscarVehiculoPorPlaca(placa);
        }


        if (vehiculoOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vehículo no encontrado");
        }

        Vehiculo vehiculo = vehiculoOpt.get();
        List<String> planes = vehiculoServicio.generarPlanesSeguro(
                vehiculo.getMarca(),
                vehiculo.getModelo(),
                vehiculo.getNumerosIniestros()
        );

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("marca", vehiculo.getMarca());
        respuesta.put("modelo", vehiculo.getModelo());
        respuesta.put("numeroSiniestros", vehiculo.getNumerosIniestros());
        respuesta.put("planes", planes);

        return ResponseEntity.ok(respuesta);
    }

     */
}
