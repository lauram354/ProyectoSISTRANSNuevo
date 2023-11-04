package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "hoteles")
public class Hoteles {
    

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String nombre;


    public Hoteles(String nombre)
    {
        this.nombre = nombre;
    }

    public Hoteles()
    {;}


    //GETTERS
    public String getNombreHotel() {
        return nombre;
    }


    //SETTERS
    public void setNombreHotel(String nombre) {
        this.nombre = nombre;
    }

    
}

