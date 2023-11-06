package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Usuarios;
import uniandes.edu.co.proyecto.repositorio.UsuariosRepository;

@Controller
public class UsuariosController {

    @Autowired
    private UsuariosRepository usuarioRepository;

    @GetMapping("/usuarios")
    public String usuarios(Model model) {
        model.addAttribute("usuarios", usuarioRepository.darUsuarios());
        return "usuarios";
    }
    
    @GetMapping("/usuarios/new")
    public String usuarioForm(Model model) {
        model.addAttribute("usuario", new Usuarios());
        return "usuarioNuevo";
    }

    @PostMapping("/usuarios/new/save")
    public String usuarioGuardar(@ModelAttribute Usuarios usuario) {
        usuarioRepository.insertarUsuario(usuario.getTipoId(), usuario.getNombreUsuario(), usuario.getEmail(), usuario.getTipoUsu().getIdTipo(), usuario.getContrasenia(), usuario.getLogin());
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/{id}/edit")
    public String usuarioEditarForm(@PathVariable("id") int id, Model model) {
        Usuarios usuario = usuarioRepository.darUsuario(id);
        if(usuario != null) {
            model.addAttribute("usuario", usuario);
            return "usuarioEditar";
        } else {
            return "redirect:/usuarios";
        }
    }

    @PostMapping("/usuarios/{id}/edit/save")
    public String usuarioEditarGuardar(@PathVariable("id") int id, @ModelAttribute Usuarios usuario) {
        usuarioRepository.actualizarUsuario(id, usuario.getTipoId(), usuario.getNombreUsuario(), usuario.getEmail(), usuario.getTipoUsu().getIdTipo(), usuario.getContrasenia(), usuario.getLogin());
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/{id}/delete")
    public String usuarioEliminar(@PathVariable("id") int id) {
        usuarioRepository.eliminarUsuario(id);
        return "redirect:/usuarios";
    }

    @GetMapping("/consumos/clientesExcelentes")
    public String encontrarClientesExcelentes(Model model) {
        model.addAttribute("clientesExcelentes", usuarioRepository.encontrarClientesExcelentes());
        
        return "clientesExcelentes";
    }

}