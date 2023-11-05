package uniandes.edu.co.proyecto.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class hotelController {
    
    @RequestMapping("/")
    public String index() {
        return "index";
    }
    
}
