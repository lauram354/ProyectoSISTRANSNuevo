package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.usuReservas;
import uniandes.edu.co.proyecto.repositorio.usuReservasRepository;

@Controller
public class usuReservasController {

    @Autowired
    private usuReservasRepository urRepository;

    @GetMapping("/usuReservas")
    public String usuReservas(Model model) {
        model.addAttribute("usuReservas", urRepository.darUsuReservas());
        return "usuReservas";
    }
    
    @GetMapping("/usuReservas/new")
    public String usuReservaForm(Model model) {
        model.addAttribute("usuReserva", new usuReservas());
        return "usuReservaNuevo";
    }

    @GetMapping("/usuReservas/{id}/edit")
    public String usuReservaEditarForm(@PathVariable("id") int id, Model model) {
        usuReservas ur = urRepository.darUsuReserva(id);
        if(ur != null) {
            model.addAttribute("usuReserva", ur);
            return "usuReservaEditar";
        } else {
            return "redirect:/usuReservas";
        }
    }

    @PostMapping("/usuReservas/{id}/edit/save")
    public String usuReservaEditarCheckInGuardar(@PathVariable("id") int id, @ModelAttribute usuReservas ur) {
        urRepository.actualizarCheckIn(id, ur.getCheckin(), ur.getPk().getIdreserva().getIdreserva());
        urRepository.actualizarCheckOut(id, ur.getCheckout(), ur.getPk().getIdreserva().getIdreserva());
        return "redirect:/usuReservas";
    }

    @GetMapping("/usuReservas/{id}/delete/{id2}")
    public String usuReservaEliminar(@PathVariable("id") int id, @PathVariable("id2") int id2) {
        urRepository.eliminarUsuReservas(id, id2);
        return "redirect:/usuReservas";
    }
    
}
