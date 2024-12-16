package com.example.ServidorSura.Controladores;


import com.example.ServidorSura.Modelos.RegistroDTO;
import com.example.ServidorSura.Modelos.Usuario;
import com.example.ServidorSura.Modelos.Vehiculo;
import com.example.ServidorSura.Repositorios.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/registro")
public class ControladorRegistroDTO {
    @Autowired
    private IUsuarioRepositorio iUsuarioRepositorio;

    @PostMapping
    public ResponseEntity<String> registrarUsuarioYVehiculo(@RequestBody RegistroDTO dto){
        Usuario usuario = new Usuario();
        usuario.setNombres(dto.getNombreCompleto());
        usuario.setCedula(dto.getDocumento());
        usuario.setFechaNacimiento(dto.getFechaNacimiento());
        usuario.setCorreo(dto.getCorreo());
        usuario.setTelefono(dto.getTelefono());
        usuario.setDireccion(dto.getDireccion());
        usuario.setContrasena(dto.getContrasena());

        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setPlaca(dto.getPlaca());
        vehiculo.setModelo(dto.getModelo());
        vehiculo.setCilindraje(dto.getCilindraje());
        vehiculo.setNumerosIniestros(dto.getNumeroSiniestros());
        vehiculo.setDescripcion(dto.getDescripcion());
        vehiculo.setUsuario(usuario);

        if (usuario.getVehiculos() == null) {
            usuario.setVehiculos(new ArrayList<>());
        }

        usuario.getVehiculos().add(vehiculo);
        iUsuarioRepositorio.save(usuario);

        return ResponseEntity.ok("Usuario y Vehículo registrados exitosamente");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerRegistroPorId(@PathVariable Long id) {
        try {
            Optional<Usuario> optionalUsuario = iUsuarioRepositorio.findById(id);

            if (optionalUsuario.isPresent()) {
                Usuario usuario = optionalUsuario.get();

                if (usuario.getVehiculos() == null || usuario.getVehiculos().isEmpty()) {
                    return ResponseEntity
                            .status(HttpStatus.BAD_REQUEST)
                            .body("El usuario no tiene vehículos registrados.");
                }

                Vehiculo vehiculo = usuario.getVehiculos().get(0);

                RegistroDTO dto = new RegistroDTO();
                dto.setNombreCompleto(usuario.getNombres());
                dto.setDocumento(usuario.getCedula());
                dto.setFechaNacimiento(usuario.getFechaNacimiento());
                dto.setCorreo(usuario.getCorreo());
                dto.setTelefono(usuario.getTelefono());
                dto.setDireccion(usuario.getDireccion());
                dto.setPlaca(vehiculo.getPlaca());
                dto.setModelo(vehiculo.getModelo());
                dto.setCilindraje(vehiculo.getCilindraje());
                dto.setNumeroSiniestros(vehiculo.getNumerosIniestros());
                dto.setDescripcion(vehiculo.getDescripcion());


                return ResponseEntity.ok(dto);
            } else {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("Usuario no encontrado con ID: " + id);
            }
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ocurrió un error inesperado: " + error.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<RegistroDTO>> obtenerTodosLosRegistros() {
        List<Usuario> usuarios = iUsuarioRepositorio.findAll();

        List<RegistroDTO> registrosDTO = new ArrayList<>();

        for (Usuario usuario : usuarios) {
            if (usuario.getVehiculos() != null && !usuario.getVehiculos().isEmpty()) {
                for (Vehiculo vehiculo : usuario.getVehiculos()) {
                    RegistroDTO dto = new RegistroDTO();
                    dto.setNombreCompleto(usuario.getNombres());
                    dto.setDocumento(usuario.getCedula());
                    dto.setFechaNacimiento(usuario.getFechaNacimiento());
                    dto.setCorreo(usuario.getCorreo());
                    dto.setTelefono(usuario.getTelefono());
                    dto.setDireccion(usuario.getDireccion());
                    dto.setContrasena(usuario.getContrasena());
                    dto.setPlaca(vehiculo.getPlaca());
                    dto.setModelo(vehiculo.getModelo());
                    dto.setCilindraje(vehiculo.getCilindraje());
                    dto.setNumeroSiniestros(vehiculo.getNumerosIniestros());
                    dto.setDescripcion(vehiculo.getDescripcion());

                    registrosDTO.add(dto);
                }
            }
        }

        return ResponseEntity.ok(registrosDTO);
    }
}
