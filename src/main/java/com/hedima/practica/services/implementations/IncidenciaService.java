package com.hedima.practica.services.implementations;

import com.hedima.practica.model.Incidencia;
import com.hedima.practica.repository.IIncidenciaRepository;
import com.hedima.practica.services.IIncidenciaService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service("incidenciaService")
@Getter
public class IncidenciaService implements IIncidenciaService {

    @Autowired
    private IIncidenciaRepository<Object, Integer> incidenciaRepository;

    public Incidencia create(Incidencia incidencia) {
        return incidenciaRepository.saveAndFlush(incidencia);
    }

    public Incidencia findById(Integer id) {
        return (Incidencia) incidenciaRepository.getReferenceById(id);
    }
    public Incidencia update(Incidencia incidencia) {
        return incidenciaRepository.saveAndFlush(incidencia);
    }

    public void delete(Incidencia incidencia) throws IOException, InterruptedException {
        incidenciaRepository.delete(incidencia);
    }

    public List<Incidencia> findAll() {
        return incidenciaRepository.findAll();
    }
}
