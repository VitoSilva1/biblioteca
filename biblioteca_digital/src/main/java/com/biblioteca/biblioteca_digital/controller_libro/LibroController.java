package com.biblioteca.biblioteca_digital.controller_libro;

import com.biblioteca.biblioteca_digital.libroModel.Libro;
import com.biblioteca.biblioteca_digital.service_libro.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/ap1/v1/biblioteca-digital")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping("listarLibros")
    public ResponseEntity<List<Libro>> listar(){
        List<Libro> libros = libroService.findAll();
        if (libros.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(libros);
    }

    @PostMapping("/crear")
    /**
     * Utiliza este curl para probar el endpoint de crear libro
     * 
     * curl --location 'http://localhost:8080/ap1/v1/biblioteca-digital/crear' \
        --header 'Content-Type: application/json' \
        --data '{
            "nombre":"test",
            "editorial":"test"
        }'
     * 
     */
    public ResponseEntity<?> agregar(@RequestBody Libro libro){
        try {
            Libro libroNuevo = libroService.save(libro);
            return ResponseEntity.status(HttpStatus.CREATED).body(libroNuevo);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al crear libro: " + e.getMessage());
        }
    }

    }

