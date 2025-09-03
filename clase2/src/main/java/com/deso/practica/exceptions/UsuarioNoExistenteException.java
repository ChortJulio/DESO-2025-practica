package com.deso.practica.exceptions;

public class UsuarioNoExistenteException extends Exception {
	public UsuarioNoExistenteException(String mensaje) {
        super(mensaje);
    }
}
