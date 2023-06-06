package com.hedima.practica.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.hedima.practica.model.Incidencia;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IIncidenciaRepository<Object, Integer> extends JpaRepository<Incidencia,Integer> {

    <S extends Incidencia> S saveAndFlush(S incidencia);
    Incidencia getReferenceById(Integer id);

    List<Incidencia> findAll();

    void delete(Incidencia incidencia);
}
