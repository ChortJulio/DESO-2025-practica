package com.deso.practica.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.deso.practica.model.Usuario;

public class UsuarioDaoMapImpl implements UsuarioDao {
	private Map<String, Usuario> usuarios; // key -> correo
	private static UsuarioDaoMapImpl instance;
	
	private UsuarioDaoMapImpl () {
		this.usuarios = new HashMap<String, Usuario>();
	}
	
	public static UsuarioDaoMapImpl getInstance() {
		if (instance == null) {
			instance = new UsuarioDaoMapImpl();
		}
		
		return instance;
	}
	
	
	@Override
	public List<Usuario> findBy(Predicate<Usuario> filtro) {
		return this.usuarios.values().stream()
				.filter(filtro)
				.collect(Collectors.toList());
	}

	@Override
	public List<Usuario> findAll() {
		return new ArrayList<>(this.usuarios.values());
	}

	@Override
	public void save(Usuario usuario) {
		this.usuarios.put(usuario.getCorreo(), usuario);
	}

}
