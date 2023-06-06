package com.hedima.practica.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="incidencias")
public class Incidencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 30)
    private String usuario;
    private Integer prioridad;
    private LocalDate fecha;

    public Incidencia(LocalDate date, String user, Integer priority) {
        this.fecha = date;
        this.usuario = user;
        this.prioridad = priority;
    }

    public Incidencia(Integer id, LocalDate date, String user, Integer priority) {
        this.id = id;
        this.fecha = date;
        this.usuario = user;
        this.prioridad = priority;
    }
}
