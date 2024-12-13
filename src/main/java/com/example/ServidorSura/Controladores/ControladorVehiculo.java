package com.example.ServidorSura.Controladores;

import com.example.ServidorSura.Modelos.Vehiculo;
import com.example.ServidorSura.Servicios.VehiculoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vehiculo")
public class ControladorVehiculo {
    @Autowired
    VehiculoServicio vehiculoServicio;
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
                    .body(vehiculoServicio.ConsultaUsuarios());
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(vehiculoServicio.buscarVehiculoPorId(id));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }

    }
}
