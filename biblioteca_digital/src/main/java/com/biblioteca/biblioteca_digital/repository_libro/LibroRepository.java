package com.biblioteca.biblioteca_digital.repository_libro;

import com.biblioteca.biblioteca_digital.libroModel.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
}
