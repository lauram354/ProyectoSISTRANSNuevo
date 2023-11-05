package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Habis;
import uniandes.edu.co.proyecto.repositorio.habisRepository;


@Controller
public class habisController {

    @Autowired
    private habisRepository habisRepository;

    @GetMapping("/habitaciones")
    public String habitaciones(Model model) {
        model.addAttribute("habitaciones", habisRepository.darHabis());
        return "habitaciones";
    }
    
    @GetMapping("/habitaciones/new")
    public String habitacionesForm(Model model) {
        model.addAttribute("habitaciones", new Habis());
        return "habitacionesNuevo";
    }

    @PostMapping("/habitaciones/new/save")
    public String habitacionesGuardar(@ModelAttribute Habis habitacion) {
        habisRepository.insertarHabitacion(habitacion.getTv(), habitacion.getCafetera(), habitacion.getMinibar(), habitacion.getTipo().getIdTipoHabi());
        return "redirect:/habitaciones";
    }

    @GetMapping("/habitaciones/{id}/edit")
    public String habitacionesEditarForm(@PathVariable("id") int id_habitacion, Model model) {
        Habis habitacion = habisRepository.darhabi(id_habitacion);
        if(habitacion != null) {
            model.addAttribute("habitaciones", habitacion);
            return "habitacionesEditar";
        } else {
            return "redirect:/habitaciones";
        }
    }

    @PostMapping("/habitaciones/{id}/edit/save")
    public String habitacionesEditarGuardar(@PathVariable("id") int id_habitacion, @ModelAttribute Habis habitacion) {
        habisRepository.actualizarHabitacion(habitacion.getTv(), habitacion.getCafetera(), habitacion.getMinibar(), habitacion.getTipo().getIdTipoHabi(), habitacion.getId_habitacion());
        return "redirect:/habitaciones";
    }

    @GetMapping("/habitaciones/{id}/delete")
    public String habitacionesEliminar(@PathVariable("id") int id_habitacion) {
        habisRepository.eliminarHabitacion(id_habitacion);
        return "redirect:/habitaciones";
    }
    
}
