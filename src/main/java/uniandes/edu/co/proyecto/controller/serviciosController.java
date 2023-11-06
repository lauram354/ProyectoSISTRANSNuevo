package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        String usuarioid,
        String fechainicio,
        String fechafin,
        String tiposervicio,
        Model model) 
    {
        SimpleDateFormat original = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat nuevo = new SimpleDateFormat("dd/MM/yyyy");

        if ((usuarioid == null || usuarioid.equals("")) || (fechainicio ==null || fechainicio.equals(""))  || (fechafin ==null || fechafin.equals("")) || (tiposervicio ==null || tiposervicio.equals("")) ){
            model.addAttribute("servicioPorCaracteristica", serviciosRepository.obtenerServiciosConsumo());
        }
        else{
            String fechaFormateadaI = fechainicio.replace('-', '/').strip();
            String fechaFormateadaF = fechafin.replace('-', '/').strip();
            try {
                Date fechaDateI = original.parse(fechainicio);
                fechaFormateadaI = nuevo.format(fechaDateI);

                Date fechaDateF = original.parse(fechafin);
                fechaFormateadaF = nuevo.format(fechaDateF);

                System.out.println(fechaFormateadaI);
                System.out.println(fechaFormateadaF);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            
            List<Object[]> servicioPorCaracteristica = serviciosRepository.obtenerServiciosPorCaracteristica(usuarioid, fechaFormateadaI, fechaFormateadaF, tiposervicio); 
            model.addAttribute("servicioPorCaracteristica", servicioPorCaracteristica);
        
        }
        return "servicioPorCaracteristica";
    }

    @GetMapping("/servicios/serviciosConPocaDemanda")
    public String serviciosConPocaDemanda(Model model) {
    List<Object[]> serviciosPocaDemanda = serviciosRepository.encontrarServiciosConPocaDemanda();
    model.addAttribute("serviciosPocaDemanda", serviciosPocaDemanda);
    return "serviciosConPocaDemanda";
}
   @GetMapping("/servicios/mejorServicioPorSemana")
public String mejorServicioPorSemana(Model model) {
    model.addAttribute("mejorServicioPorSemana", serviciosRepository.encontrarMejorServicioPorSemana());
    return "mejorServicioPorSemana";
}

   @GetMapping("/servicios/peorServicioPorSemana")
public String peorServicioPorSemana(Model model) {
    model.addAttribute("peorServicioPorSemana", serviciosRepository.encontrarPeorServicioPorSemana());
    return "peorServicioPorSemana";
}

@GetMapping("/servicios/habitacionMenosSolicitada")
public String habitacionMenosSolicitada(Model model) {
    model.addAttribute("habitacionMenosSolicitada", serviciosRepository.encontrarHabitacionMenosSolicitada());
    return "habitacionMenosSolicitada";
}

@GetMapping("/servicios/habitacionMasSolicitada")
public String habitacionMasSolicitada(Model model) {
    model.addAttribute("habitacionMasSolicitada", serviciosRepository.encontrarHabitacionMasSolicitada());
    return "habitacionMasSolicitada";
}


}
