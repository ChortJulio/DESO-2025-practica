package com.deso.practica.service;

import java.util.HashMap;
import java.util.Map;

import com.deso.practica.exceptions.UsuarioNoExistenteException;

public class ValidadorLogin {

    private static final Map<String, String> usuarios = new HashMap<>();

    public ValidadorLogin() {
    	usuarios.put("admin", "12345");
        usuarios.put("user1", "abc123");
        usuarios.put("user2", "qwerty");
    }

    public boolean validar(String usuario, String contrasena) throws UsuarioNoExistenteException {
        if (!usuarios.containsKey(usuario)) {
            throw new UsuarioNoExistenteException("El usuario '" + usuario + "' no existe en el sistema.");
        }
        return usuarios.get(usuario).equals(contrasena);
    }
}
