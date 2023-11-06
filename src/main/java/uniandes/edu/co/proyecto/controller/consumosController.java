package uniandes.edu.co.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import uniandes.edu.co.proyecto.modelo.Consumos;
import uniandes.edu.co.proyecto.modelo.Usuarios;
import uniandes.edu.co.proyecto.repositorio.consumosRepository;

@Controller
public class consumosController {

    @Autowired
    private consumosRepository consumoRepository;

    @GetMapping("/consumos")
    public String usuarios(Model model) {
        model.addAttribute("consumos", consumoRepository.darConsumos());
        return "consumos";
    }
    
    @GetMapping("/consumos/new")
    public String usuarioForm(Model model) {
        model.addAttribute("consumo", new Consumos());
        return "consumoNuevo";
    }

    @PostMapping("/consumos/new/save")
    public String usuarioGuardar(@ModelAttribute Consumos consumo) {
        consumoRepository.insertarConsumo(consumo.getPagado(), consumo.getCostofinal(), consumo.getIducuenta().getIdcuenta(), consumo.getFecha(), consumo.getId_habitacion().getId_habitacion());
        return "redirect:/consumos";
    }

    @GetMapping("/consumos/{id}/edit")
    public String usuarioEditarForm(@PathVariable("id") int id, Model model) {
        Consumos consumo = consumoRepository.darConsumo(id);
        if(consumo != null) {
            model.addAttribute("consumo", consumo);
            return "consumoEditar";
        } else {
            return "redirect:/consumos";
        }
    }

    @PostMapping("/consumos/{id}/edit/save")
    public String usuarioEditarGuardar(@PathVariable("id") int id, @ModelAttribute Consumos consumo) {
        consumoRepository.actualizarConsumo(id, consumo.getPagado(), consumo.getCostofinal(), consumo.getIducuenta().getIdcuenta(), consumo.getFecha(), consumo.getId_habitacion().getId_habitacion());
        return "redirect:/consumos";
    }

    @GetMapping("/consumos/{id}/delete")
    public String usuarioEliminar(@PathVariable("id") int id) {
        consumoRepository.eliminarConsumo(id);
        return "redirect:/consumos";
    }
    
    // RFC5 // 
     @GetMapping("/consumos/consumoporfechas")
    public String consumoPorFechas(Model model, String id, String fechaInicial, String fechaFinal) {
        List<Object[]> consumoPorFechas = consumoRepository.darConsumosPorFechas(id, fechaInicial, fechaFinal);
        model.addAttribute("consumoporfechas", consumoPorFechas);
        return "consumoporfechas";
    }

    @GetMapping("/consumos/internet")
    public String consultarConsumoInternet(Model model) {
        // Realiza la primera consulta SQL
        List<Object[]> consumoInternet = consumoRepository.consultarConsumoInternet();
        model.addAttribute("consumoInternet", consumoInternet);

        // Realiza la segunda consulta SQL
        List<Object[]> consumoInternetCount = consumoRepository.consultarConsumoInternetCount();
        model.addAttribute("consumoInternetCount", consumoInternetCount);

        return "consumoInternet";
    }

    @GetMapping("/consumos/buenosClientes")
    public String encontrarBuenosClientes(Model model) {
        model.addAttribute("buenosClientes", consumoRepository.encontrarBuenosClientes());
        
        return "buenosClientes";
    }
}
