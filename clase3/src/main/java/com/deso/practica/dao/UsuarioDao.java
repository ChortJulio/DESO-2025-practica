package com.deso.practica.dao;

import java.util.List;
import java.util.function.Predicate;

import com.deso.practica.model.Usuario;

public interface UsuarioDao {
	public List<Usuario> findBy(Predicate<Usuario> filtro); 
	public List<Usuario> findAll();
	public void save(Usuario usuario);
}
