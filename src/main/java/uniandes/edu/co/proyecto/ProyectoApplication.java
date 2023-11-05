package uniandes.edu.co.proyecto;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uniandes.edu.co.proyecto.modelo.Servicios;
import uniandes.edu.co.proyecto.modelo.Usuarios;
import uniandes.edu.co.proyecto.repositorio.UsuariosRepository;
import uniandes.edu.co.proyecto.repositorio.serviciosRepository;

@SpringBootApplication
public class ProyectoApplication implements CommandLineRunner{

	@Autowired
	private serviciosRepository serv;
	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Collection<Servicios> servis = serv.darServicios();
		for (Servicios s : servis){
			System.out.println(s.getTipo());
		}
		
	}

}
