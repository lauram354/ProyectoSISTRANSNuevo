package uniandes.edu.co.proyecto;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uniandes.edu.co.proyecto.modelo.usuarios;
import uniandes.edu.co.proyecto.repositorio.UsuariosRepository;

@SpringBootApplication
public class ProyectoApplication implements CommandLineRunner{

	@Autowired
	private UsuariosRepository usuariosRepository;
	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}

	@Override
	public void run(String ... arg){
		Collection<usuarios> usuarios = usuariosRepository.darUsuarios();
		usuarios us = new usuarios();
		for (usuarios u: usuarios){
			us = u;
		}
		System.out.println(us.getNombreUsuario());
	}
}
