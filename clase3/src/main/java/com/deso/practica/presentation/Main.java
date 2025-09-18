package com.deso.practica.presentation;

import java.time.LocalDate;
import java.util.function.Predicate;

import com.deso.practica.dao.UsuarioDao;
import com.deso.practica.dao.UsuarioDaoMapImpl;
import com.deso.practica.exceptions.UsuarioInvalidoException;
import com.deso.practica.model.Usuario;
import com.deso.practica.service.UsuarioService;

public class Main {

	public static void main(String[] args) {
		Usuario usuario = new Usuario.Builder()
				.username("jlopez")
				.correo("juan@gmail.com")
				.password("pepito123")
				.apellido("Lopez")
				.fechaNacimiento(LocalDate.of(2000, 1, 1))
				.nombre("Juan")
				.build();
		
		System.out.println(usuario.toString());
		
		Usuario usuario2 = new Usuario.Builder()
				.username("jlopez2")
				.correo("juangomez@gmail.com")
				.password("pepito123")
				.apellido("Gomez")
				.fechaNacimiento(LocalDate.of(2000, 1, 1))
				.nombre("Juan")
				.build();
		
		
		
		UsuarioService service = UsuarioService.getInstance();
		
		try {
			
			service.registrarUsuario(usuario);
			service.registrarUsuario(usuario2);
			
		} catch (UsuarioInvalidoException e) {
			System.out.println("Excepción lanzada: "+e.getMessage());
		} finally {
			
			System.out.println("Usuarios existentes al finalizar la compilación: "+service.getAll());
		}
		

	}

}
