package com.example.ServidorSura.Controladores;


import com.example.ServidorSura.Modelos.Planes;
import com.example.ServidorSura.Modelos.Usuario;
import com.example.ServidorSura.Servicios.PlanesServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/plan")
public class ControladorPlan {

    @Autowired
    PlanesServicio planesServicio;

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Planes datos) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(planesServicio.guardarPlan(datos));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }

    //llamamos al metodo que busca
    @GetMapping
    public ResponseEntity<?> buscar() throws Exception {
        try {

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(planesServicio.buscarPlanes());

        } catch (Exception error) {
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
                    .body(planesServicio.buscarPlanPorId(id));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }

    }
}
