package com.hedima.practica.controller;

import com.hedima.practica.model.Incidencia;
import com.hedima.practica.services.implementations.IncidenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/")
public class InitialController {
    @Autowired
    private IncidenciaService incidenciaService;

    @GetMapping
    public String findAll(Model model) throws IOException, InterruptedException {
        List<Incidencia> incidencias = incidenciaService.findAll();
         model.addAttribute("incidencias", incidencias);
        return "index";
    }

    @GetMapping("/new")
    public String view() {
        return "new";

    }

    @GetMapping("/create")
    public RedirectView createIncidencia(@RequestParam(name = "date") LocalDate date, @RequestParam(name = "user") String user, @RequestParam(name = "priority") Integer priority) throws IOException, InterruptedException {
        Incidencia incidencia = new Incidencia(date, user, priority);
        Incidencia newIncidencia = incidenciaService.create(incidencia);
        if (newIncidencia != null) {
            return new RedirectView("/");
        } else {
            return new RedirectView("/error");
        }
    }

    @GetMapping("/edit")
    public String editIncidencia(Model model, @RequestParam(name = "id") Integer id) throws IOException, InterruptedException {
        Incidencia incidencia = incidenciaService.findById(id);
        model.addAttribute("incidencia", incidencia);
        return "edit";
    }

    @GetMapping("/update")
    public String updateIncidencia(@RequestParam(name = "id") Integer id, @RequestParam(name = "date") LocalDate date, @RequestParam(name = "user") String user, @RequestParam(name = "priority") Integer priority) throws IOException, InterruptedException {
        Incidencia incidencia = new Incidencia(id, date, user, priority);
        Incidencia updatedIncidencia = incidenciaService.update(incidencia);
        if (updatedIncidencia != null) {
            return "redirect:/view?id=" + updatedIncidencia.getId();
        } else {
            return "redirect:/error";
        }
    }

    @GetMapping("/delete")
    public RedirectView deleteIncidencia(@RequestParam(name = "id") Integer id) throws IOException, InterruptedException {
        Incidencia incidencia = incidenciaService.findById(id);
        incidenciaService.delete(incidencia);
        return new RedirectView("/");
    }

    @GetMapping("/view")
    public String findById(Model model, @RequestParam(name = "id") Integer id) throws IOException, InterruptedException {
        Incidencia incidencia = incidenciaService.findById(id);
        model.addAttribute("incidencia", incidencia);
        return "showOne";
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }
}
