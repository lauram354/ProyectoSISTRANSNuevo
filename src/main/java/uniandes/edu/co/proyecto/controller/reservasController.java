package uniandes.edu.co.proyecto.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Reservas;
import uniandes.edu.co.proyecto.repositorio.reservasRepository;

@Controller
public class reservasController {

    @Autowired
    private reservasRepository reservaRepository;

    @GetMapping("/reservas")
    public String reservas(Model model) {
        model.addAttribute("reservas", reservaRepository.darReservas());
        return "reservas";
    }
    
    @GetMapping("/reservas/new")
    public String reservaForm(Model model) {
        model.addAttribute("reserva", new Reservas());
        return "reservaNuevo";
    }

    @PostMapping("/reservas/new/save")
    public String reservaGuardar(@ModelAttribute Reservas reserva) {
        reservaRepository.insertarReserva(reserva.getFecha_entrada(), reserva.getFecha_salida(), reserva.getCant_personas(), reserva.getIdHabi().getId_habitacion(), reserva.getCuenta().getIdcuenta(), reserva.getTipo_plan().getIdTipoPlan(), reserva.getNombreHotel().getNombreHotel());
        return "redirect:/reservas";
    }

    @GetMapping("/reservas/{id}/edit")
    public String reservaEditarForm(@PathVariable("id") int id, Model model) {
        Reservas reserva = reservaRepository.darReserva(id);
        if(reserva != null) {
            model.addAttribute("reserva", reserva);
            return "reservaEditar";
        } else {
            return "redirect:/reservas";
        }
    }

    @PostMapping("/reservas/{id}/edit/save")
    public String reservaEditarGuardar(@PathVariable("id") int id, @ModelAttribute Reservas reserva) {
        reservaRepository.actualizarReserva(id, reserva.getFecha_entrada(), reserva.getFecha_salida(), reserva.getCant_personas(), reserva.getIdHabi().getId_habitacion(), reserva.getCuenta().getIdcuenta(), reserva.getTipo_plan().getIdTipoPlan(), reserva.getNombreHotel().getNombreHotel());
        return "redirect:/reservas";
    }

    @GetMapping("/reservas/{id}/delete")
    public String reservaEliminar(@PathVariable("id") int id) {
        reservaRepository.eliminarReserva(id);
        return "redirect:/reservas";
    }
    

    // RFC1 // 
     @GetMapping("/reservas/indiceocupacion")
    public String indiceOcupacionHabitaciones(Model model) {
        List<Object[]> indiceOcupacionHabitaciones = reservaRepository.indiceOcupacionHabitaciones();
        model.addAttribute("indiceOcupacionHabitaciones", indiceOcupacionHabitaciones);
        return "indiceocupacion";
    }

    //RFC6//
    @GetMapping("/operacionhotel")
    public String darFechaMayorOcupacion(Model model) {
        List<Object[]>  informacion = reservaRepository.darFechaMayorOcupacion();
        model.addAttribute("fechasMayorOcupacion", informacion);

        List<Object[]>  informacion2 = reservaRepository.darFechaMenorOcupacion();
        model.addAttribute("fechasMenorOcupacion", informacion2);

        List<Object[]>  informacion3 = reservaRepository.darFechaMayorConsumo();
        model.addAttribute("fechasMayorConsumo", informacion3);

        return "operacionhotel";
    }

}
