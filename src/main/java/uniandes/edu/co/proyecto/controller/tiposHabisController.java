package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.TiposHabi;
import uniandes.edu.co.proyecto.repositorio.tiposHabisRepository;

@Controller
public class tiposHabisController {
    
    @Autowired
    private tiposHabisRepository tiposHabisRepository;

    @GetMapping("/tiposHabis")
    public String tipoHabis(Model model) {
        model.addAttribute("tiposHabis", tiposHabisRepository.darTiposHabi());
        return "tiposHabis";
    }
    
    @GetMapping("/tiposHabis/new")
    public String tipoHabisForm(Model model) {
        model.addAttribute("tiposHabis", new TiposHabi());
        return "tiposHabisNuevo";
    }

    @PostMapping("/tiposHabis/new/save")
    public String tipoHabisGuardar(@ModelAttribute TiposHabi tiposHabi) {
        tiposHabisRepository.insertarTipoHabi(tiposHabi.getTipo(), tiposHabi.getNombre().getNombreHotel(), tiposHabi.getCosto_alojamiento(), tiposHabi.getCapacidad());
        return "redirect:/tiposHabis";
    }

    @GetMapping("/tiposHabis/{id}/edit")
    public String tipoHabisEditarForm(@PathVariable("id") int idtipohabi, Model model) {
        TiposHabi tipoHabi = tiposHabisRepository.darTipoHabi(idtipohabi);
        if(tipoHabi != null) {
            model.addAttribute("tiposHabis", tipoHabi);
            return "tiposHabisEditar";
        } else {
            return "redirect:/tiposHabis";
        }
    }

    @PostMapping("/tiposHabis/{id}/edit/save")
    public String tipoHabisEditarGuardar(@PathVariable("id") int idtipohabi, @ModelAttribute TiposHabi tiposHabi) {
        tiposHabisRepository.actualizarTipoHabi(idtipohabi, tiposHabi.getTipo(), tiposHabi.getCapacidad(), tiposHabi.getCosto_alojamiento());
        return "redirect:/tiposHabis";
    }

    @GetMapping("/tiposHabis/{id}/delete")
    public String tipoHabisEliminar(@PathVariable("id") int idtipohabi) {
        tiposHabisRepository.eliminarTipoHabi(idtipohabi);
        return "redirect:/tiposHabis";
    }

}
