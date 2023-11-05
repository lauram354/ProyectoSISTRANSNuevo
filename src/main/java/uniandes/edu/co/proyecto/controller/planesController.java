package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Planes;
import uniandes.edu.co.proyecto.repositorio.planesRepository;

@Controller
public class planesController {

    @Autowired
    private planesRepository planRepository;

    @GetMapping("/planes")
    public String planes(Model model) {
        model.addAttribute("planes", planRepository.darPlanes());
        return "planes";
    }
    
    @GetMapping("/planes/new")
    public String planForm(Model model) {
        model.addAttribute("plan", new Planes());
        return "planNuevo";
    }

    @PostMapping("/planes/new/save")
    public String planGuardar(@ModelAttribute Planes plan) {
        planRepository.insertarPlanes(plan.getTipo_plan(), plan.getDescuento(), plan.getNombreHotel().getNombreHotel());
        return "redirect:/planes";
    }

    @GetMapping("/planes/{id}/edit")
    public String planEditarForm(@PathVariable("id") int id, Model model) {
        Planes plan = planRepository.darPlan(id);
        if(plan != null) {
            model.addAttribute("plan", plan);
            return "planEditar";
        } else {
            return "redirect:/planes";
        }
    }

    @PostMapping("/planes/{id}/edit/save")
    public String planEditarGuardar(@PathVariable("id") int id, @ModelAttribute Planes plan) {
        planRepository.actualizarPlan(plan.getTipo_plan(), plan.getDescuento(),id);
        return "redirect:/planes";
    }

    @GetMapping("/planes/{id}/delete")
    public String planEliminar(@PathVariable("id") int id) {
        planRepository.eliminarPlan(id);
        return "redirect:/planes";
    }
    
}
