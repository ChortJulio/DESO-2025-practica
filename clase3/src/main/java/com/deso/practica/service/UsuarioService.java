package com.deso.practica.service;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

import com.deso.practica.dao.UsuarioDao;
import com.deso.practica.dao.UsuarioDaoMapImpl;
import com.deso.practica.exceptions.UsuarioInvalidoException;
import com.deso.practica.model.Usuario;

public class UsuarioService {
	private static UsuarioService instance;
	private UsuarioDao usuarioDao;
	private final Integer USERNAME_MIN_LENGTH = 6;
	
	private UsuarioService() {
		this.usuarioDao = UsuarioDaoMapImpl.getInstance();
		// this.usuarioDao = UsuarioDaoFileImpl.getInstance();
	}
	
	public static UsuarioService getInstance() {
		if (instance == null) {
			instance = new UsuarioService();
		}
		
		return instance;
	}
	
	public List<Usuario> getAll() {
		return usuarioDao.findAll();
	}
	
	public void registrarUsuario(Usuario usuario) throws UsuarioInvalidoException {
		
		validar(usuario);
		
		// Verificar si el usuario ya está en el "sistema"
		Predicate<Usuario> userRepeatedFilter = (Usuario u) -> u.getCorreo().equals(usuario.getCorreo()) || u.getUsername().equals(usuario.getUsername());
		
		List<Usuario> usuariosRepetidos = usuarioDao.findBy(userRepeatedFilter);
		
		if (usuariosRepetidos.size() > 0) {
			throw new UsuarioInvalidoException("Usuario con correo o username repetido");
		}
		
		usuarioDao.save(usuario);
		
		System.out.println("Se guardó con éxito el usuario: "+usuario.getCorreo());
	}
	
	private void validar(Usuario usuario) throws UsuarioInvalidoException {
		
		if (usuario.getCorreo() == null || !usuario.getCorreo().contains("@")) {
			throw new UsuarioInvalidoException("El correo no es válido");
		}
		
		if (usuario.getUsername() == null || usuario.getUsername().length() < USERNAME_MIN_LENGTH) {
			throw new UsuarioInvalidoException("El username no existe o es muy corto (menos de 6 caracteres)");
		}
		
		if (usuario.getFechaNacimiento() == null || usuario.getFechaNacimiento().isAfter(LocalDate.now())) {
			throw new UsuarioInvalidoException("La fecha de nacimiento del usuario debe ser anterior a la fecha actual");
		}		
	}

}
