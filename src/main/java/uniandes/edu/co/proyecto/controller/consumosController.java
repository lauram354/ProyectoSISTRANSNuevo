package uniandes.edu.co.proyecto.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import uniandes.edu.co.proyecto.modelo.consultaForm;

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
        SimpleDateFormat original = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat nuevo = new SimpleDateFormat("dd/MM/yyyy");

        if ((id == null || id.equals("")) || (fechaInicial ==null || fechaInicial.equals(""))  || (fechaFinal ==null || fechaFinal.equals("")) ){
            model.addAttribute("consumoporfechas", consumoRepository.darConsumosReq5());
        }else{
            String fechaFormateadaI = fechaInicial.replace('-', '/').strip();
            String fechaFormateadaF = fechaFinal.replace('-', '/').strip();
            try {
                Date fechaDateI = original.parse(fechaInicial);
                fechaFormateadaI = nuevo.format(fechaDateI);

                Date fechaDateF = original.parse(fechaFinal);
                fechaFormateadaF = nuevo.format(fechaDateF);

            } catch (ParseException e) {
                e.printStackTrace();
            }

            List<Object[]> consumoPorFechas = consumoRepository.darConsumosPorFechas(id, fechaFormateadaI, fechaFormateadaF);
            model.addAttribute("consumoporfechas", consumoPorFechas);
        }
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

    /*
        @GetMapping("/consumos/usuarios")
    public String Usuarios(Model model) {
        // Consulta SQL 1: Obtener los consumos en el rango de fechas especificado sin PISCINA
        List<Object[]> consumos = consumoRepository.darConsumos(null, null);
        model.addAttribute("consumos", consumos);

        // Consulta SQL 2: Obtener la cantidad de consumos agrupados por usuarios y tipo de servicio
        List<Object[]> consumoCount = consumoRepository.darConsumosCount(null, null);
        model.addAttribute("consumoCount", consumoCount);

        return "consumos";
    }
    */
    @GetMapping("/consumos/consulta")
    public String mostrarFormularioConsulta(Model model) {
        model.addAttribute("consulta", new consultaForm());
        return "consulta";
    }

    @RequestMapping(value = "/consumos/consultar", method = RequestMethod.POST)
    public String consultarConsumo(@ModelAttribute consultaForm consultaForm, Model model) {
        String fechaInicio = consultaForm.getFechaInicio();
        String fechaFin = consultaForm.getFechaFin();
        String tipoServicio = consultaForm.getTipoServicio();


        List<Object[]> consumosPersonalizados = consumoRepository.darConsumosPorFechas(fechaInicio, fechaFin, tipoServicio);
        model.addAttribute("consumosPersonalizados", consumosPersonalizados);

        return "consumos_personalizados";
    }

    @GetMapping("/consumos/noconsumoporcaracteristica")
    public String mostrarConsumoCaracteristica(
        String fechainicio,
        String fechafin,
        String tiposervicio,
        String orden,
        Model model) 
    {
        SimpleDateFormat original = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat nuevo = new SimpleDateFormat("dd/MM/yyyy");

        if ((fechainicio ==null || fechainicio.equals(""))  || (fechafin ==null || fechafin.equals("")) || (tiposervicio ==null || tiposervicio.equals("")) ){
            model.addAttribute("noconsumoporcaracteristica", consumoRepository.darConsumosDefault());
        }
        else if ((orden.equals("Usuario"))){
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
            
            List<Object[]> noconsumo= consumoRepository.darConsumos(fechaFormateadaI, fechaFormateadaF, tiposervicio); 
            model.addAttribute("noconsumoporcaracteristica", noconsumo);
        
        } else{
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
            
            List<Object[]> noconsumo= consumoRepository.darConsumosCount(fechaFormateadaI, fechaFormateadaF, tiposervicio); 
            model.addAttribute("noconsumoporcaracteristica", noconsumo);
        }
        return "noconsumoporcaracteristica";
    }

    @GetMapping("/consumos/consumoporcaracteristica")
    public String mostrarConsumoCaracteristicaRFC9(
        String fechainicio,
        String fechafin,
        String tiposervicio,
        String orden,
        Model model) 
    {
        SimpleDateFormat original = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat nuevo = new SimpleDateFormat("dd/MM/yyyy");

        if ((fechainicio ==null || fechainicio.equals(""))  || (fechafin ==null || fechafin.equals("")) || (tiposervicio ==null || tiposervicio.equals("")) ){
            model.addAttribute("consumoporcaracteristica", consumoRepository.darConsumosDefault());
        }
        else if ((orden.equals("Usuario"))){
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
            
            List<Object[]> consumo= consumoRepository.consultarConsumoCaracteristica(fechaFormateadaI, fechaFormateadaF, tiposervicio); 
            model.addAttribute("consumoporcaracteristica", consumo);
        
        } else{
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
            
            List<Object[]> consumo= consumoRepository.consultarConsumoCaracteristicaCount(fechaFormateadaI, fechaFormateadaF, tiposervicio); 
            model.addAttribute("consumoporcaracteristica", consumo);
        }
        return "consumoporcaracteristica";
    }

}
