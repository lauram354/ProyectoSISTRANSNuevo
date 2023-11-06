package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import uniandes.edu.co.proyecto.modelo.Servicios;
import uniandes.edu.co.proyecto.repositorio.serviciosRepository;

@Controller
public class serviciosController {

    @Autowired
    private serviciosRepository serviciosRepository;

    @GetMapping("/servicios")
    public String servicios(Model model) {
        model.addAttribute("servicios", serviciosRepository.darServicios());
        return "servicios";
    }
    
    @GetMapping("/servicios/new")
    public String serviciosForm(Model model) {
        model.addAttribute("servicios", new Servicios());
        return "serviciosNuevo";
    }

    @PostMapping("/servicios/new/save")
    public String serviciosGuardar(@ModelAttribute Servicios servicio) {
        serviciosRepository.insertarServicio(servicio.getDescripcion(), servicio.getCosto(), servicio.getTipo(), servicio.getHotel().getNombreHotel(), servicio.getservicios_type());
        return "redirect:/servicios";
    }

    @GetMapping("/servicios/{id}/edit")
    public String serviciosEditarForm(@PathVariable("id") int id, Model model) {
        Servicios servicio = serviciosRepository.darServicio(id);
        if(servicio != null) {
            model.addAttribute("servicios", servicio);
            return "serviciosEditar";
        } else {
            return "redirect:/servicios";
        }
    }

    @PostMapping("/servicios/{id}/edit/save")
    public String serviciosEditarGuardar(@PathVariable("id") int id, @ModelAttribute Servicios servicio) {
        serviciosRepository.actualizarServicio(id, servicio.getDescripcion(), servicio.getCosto(), servicio.getTipo(), servicio.getHotel().getNombreHotel(), servicio.getservicios_type());
        return "redirect:/servicios";
    }

    @GetMapping("/servicios/{id}/delete")
    public String serviciosEliminar(@PathVariable("id") int id) {
        serviciosRepository.eliminarServicio(id);
        return "redirect:/servicios";
    }

    // RFC1 // 
     @GetMapping("/servicios/recolectadoPorHabitacion")
    public String dineroRecolectadoServiciosHabitacion(Model model) {
        List<Object[]> dineroRecolectadoPorHabitacion = serviciosRepository.calcularDineroRecolectadoPorHabitacionEnUltimoAnio();
        model.addAttribute("dineroRecolectadoPorHabitacion", dineroRecolectadoPorHabitacion);
        return "recolectadoPorHabitacion";
    
    }

    @GetMapping("/servicios/top20Servicios")
    public String mostrarTop20Servicios(Model model) {
        List<Object[]> top20Servicios = serviciosRepository.top20Servicios("01/01/2020", "31/12/2023");
        model.addAttribute("top20Servicios", top20Servicios);
        return "top20Servicios"; 
    }

     @GetMapping("/servicios/servicioPorCaracteristica")
    public String mostrarServiciosPorCaracteristica(
        @RequestParam("usuarioId") Long usuarioId,
        @RequestParam("fechaInicio") String fechaInicio,
        @RequestParam("fechaFin") String fechaFin,
        @RequestParam("tipoServicio") String tipoServicio,
        Model model
    ) {
        List<Servicios> servicios = serviciosRepository.obtenerServiciosPorCaracteristica(
            usuarioId, fechaInicio, fechaFin, tipoServicio);
        
        model.addAttribute("servicios", servicios);
        return "servicioPorCaracteristica";
    }

    @GetMapping("/servicios/serviciosConPocaDemanda")
    public String serviciosConPocaDemanda(Model model) {
    List<Object[]> serviciosPocaDemanda = serviciosRepository.encontrarServiciosConPocaDemanda();
    model.addAttribute("serviciosPocaDemanda", serviciosPocaDemanda);
    return "serviciosConPocaDemanda";
}


}
