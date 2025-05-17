package com.biblioteca.biblioteca_digital.libroModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonFormat;


import java.util.Date;

@Entity
@Table(name="libro")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String editorial;



}
