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

import java.util.List;

@RestController
@RequestMapping("/ap1/v1/biblioteca_digital")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    public ResponseEntity<List<Libro>> listar(){
        List<Libro> libros = libroService.findAll();
        if (libros.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(libros);
    }
}
