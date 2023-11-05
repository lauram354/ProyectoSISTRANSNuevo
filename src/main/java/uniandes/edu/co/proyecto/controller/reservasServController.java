package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.reservaServ;
import uniandes.edu.co.proyecto.repositorio.reservasServRepository;

@Controller
public class reservasServController {

    @Autowired
    private reservasServRepository rsRepository;

    @GetMapping("/reservasServ")
    public String reservasServ(Model model) {
        model.addAttribute("reservasServ", rsRepository.darReservasServ());
        return "reservasServ";
    }
    
    @GetMapping("/reservasServ/new")
    public String reservaServForm(Model model) {
        model.addAttribute("reservaServ", new reservaServ());
        return "reservaServNuevo";
    }

    @PostMapping("/reservasServ/new/save")
    public String reservaServGuardar(@ModelAttribute reservaServ rs) {
        rsRepository.insertarReservaServ(rs.getIdusuario().getIdUsuario(), rs.getConsumo().getIdconsumo(), rs.getIdservicio().getIdservicio());
        return "redirect:/reservasServ";
    }

    @GetMapping("/reservasServ/{id}/edit")
    public String reservaServEditarForm(@PathVariable("id") int id, Model model) {
        reservaServ rs = rsRepository.darReservaServ(id);
        if(rs != null) {
            model.addAttribute("reservaServ", rs);
            return "reservasServEditar";
        } else {
            return "redirect:/reservasServ";
        }
    }

    @PostMapping("/reservasServ/{id}/edit/save")
    public String reservaServEditarGuardar(@PathVariable("id") int id, @ModelAttribute reservaServ rs) {
        rsRepository.actualizarReservaServ(id, rs.getIdusuario().getIdUsuario(), rs.getConsumo().getIdconsumo(), rs.getIdservicio().getIdservicio());
        return "redirect:/reservasServ";
    }

    @GetMapping("/reservasServ/{id}/delete")
    public String reservaServEliminar(@PathVariable("id") int id) {
        rsRepository.eliminarReservaServ(id);
        return "redirect:/reservasServ";
    }
    
}
