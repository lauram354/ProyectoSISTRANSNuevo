package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.modelo.Login;
import uniandes.edu.co.proyecto.modelo.Usuarios;
import uniandes.edu.co.proyecto.repositorio.UsuariosRepository;

@Controller
public class hotelController {

    @Autowired
    private UsuariosRepository usuarioRepository;
    
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @ModelAttribute("login")
    public Login getLogin() {
        return new Login();
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String user, @RequestParam String password) {
        Usuarios usuario = usuarioRepository.darUsuarioLogin(user);
        if(usuario != null) {

            if (usuario.getContrasenia().equals(password)){
                
                Integer tipoUsuario = usuario.getTipoUsu().getIdTipo();
                
                if (tipoUsuario == 1) {
                    return "redirect:/ADMIN";
                }
                else if (tipoUsuario == 2) {
                    return "redirect:/CLIENTE";
                }
                else if (tipoUsuario == 3) {
                    return "redirect:/RECEPCIONISTA";
                }
                else if (tipoUsuario == 4) {
                    return "redirect:/GERENTE";
                }
                else if (tipoUsuario == 5) {
                    return "redirect:/EMPLEADO";
                }
            }

        } 
        
        return "redirect:/";
        
    }

    @GetMapping("/ADMIN")
    public String showAdminPage() {
        return "ADMIN";
    }

    @GetMapping("/CLIENTE")
    public String showClientePage() {
        return "CLIENTE";
    }

    @GetMapping("/RECEPCIONISTA")
    public String showRecepPage() {
        return "RECEPCIONISTA";
    }

    @GetMapping("/GERENTE")
    public String showGerentePage() {
        return "GERENTE";
    }

    @GetMapping("/EMPLEADO")
    public String showEmplaedoPage() {
        return "EMPLEADO";
    }
    
}
