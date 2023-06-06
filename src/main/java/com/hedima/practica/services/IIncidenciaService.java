package com.hedima.practica.services;

import com.hedima.practica.model.Incidencia;
import java.io.IOException;
import java.util.List;

public interface IIncidenciaService {
    Incidencia create(Incidencia incidencia) throws IOException, InterruptedException;
    Incidencia update(Incidencia incidencia) throws IOException, InterruptedException;
    void delete(Incidencia incidencia) throws IOException, InterruptedException;
    List<Incidencia> findAll() throws IOException, InterruptedException;
    Incidencia findById(Integer id) throws IOException, InterruptedException;
}
