package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.tiposUsu;
import uniandes.edu.co.proyecto.repositorio.tiposUsuariosRepository;

@Controller
public class tiposUsuariosController {

    @Autowired
    private tiposUsuariosRepository tiposUsuarioRepository;

    @GetMapping("/tiposUsu")
    public String tipoUsuarios(Model model) {
        model.addAttribute("tiposUsu", tiposUsuarioRepository.darTiposUsu());
        return "tiposUsu";
    }
    
    @GetMapping("/tiposUsu/new")
    public String tipoUsuarioForm(Model model) {
        model.addAttribute("tiposUsu", new tiposUsu());
        return "tiposUsuNuevo";
    }

    @PostMapping("/tiposUsu/new/save")
    public String tipoUsuarioGuardar(@ModelAttribute tiposUsu tipoUsuario) {
        tiposUsuarioRepository.insertarTipoUsuario(tipoUsuario.getTipo());
        return "redirect:/tiposUsu";
    }

    @GetMapping("/tiposUsu/{id}/edit")
    public String tipoUsuarioEditarForm(@PathVariable("id") int idtipo, Model model) {
        tiposUsu tipoUsuario = tiposUsuarioRepository.darTipoUsuario(idtipo);
        if(tipoUsuario != null) {
            model.addAttribute("tiposUsu", tipoUsuario);
            return "tiposUsuEditar";
        } else {
            return "redirect:/tiposUsu";
        }
    }

    @PostMapping("/tiposUsu/{id}/edit/save")
    public String tipoUsuarioEditarGuardar(@PathVariable("id") int idtipo, @ModelAttribute tiposUsu tipoUsuario) {
        tiposUsuarioRepository.actualizarTipoUsuario(idtipo, tipoUsuario.getTipo());
        return "redirect:/tiposUsu";
    }

    @GetMapping("/tiposUsu/{id}/delete")
    public String tipoUsuarioEliminar(@PathVariable("id") String tipoUsu) {
        tiposUsuarioRepository.eliminarTipoUsuario(tipoUsu);
        return "redirect:/tiposUsu";
    }
    
}
