package com.biblioteca.biblioteca_digital.service_libro;

import com.biblioteca.biblioteca_digital.libroModel.Libro;
import com.biblioteca.biblioteca_digital.repository_libro.LibroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> findAll(){
        return libroRepository.findAll();
    }

    public Libro findById(long id){
        return libroRepository.findById(id).get();
    }

    public Libro save(Libro libro){
        return libroRepository.save(libro);
    }

    public void delete(Long id){
        libroRepository.deleteById(id);
    }
}
