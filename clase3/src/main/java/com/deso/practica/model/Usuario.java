package com.deso.practica.model;

import java.time.LocalDate;

public class Usuario {
    private String correo;
    private String username;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String password;

    private Usuario(Builder builder) {
        this.correo = builder.correo;
        this.username = builder.username;
        this.nombre = builder.nombre;
        this.apellido = builder.apellido;
        this.fechaNacimiento = builder.fechaNacimiento;
        this.password = builder.password;
    }
    
    // Getters
    public String getCorreo() { return correo; }
    public String getUsername() { return username; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public String getPassword() { return password; }
    
    @Override
    public String toString() {
        return "Usuario{" +
                "correo='" + correo + '\'' +
                ", username='" + username + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
    
    public static class Builder {
        private String correo;
        private String username;
        private String nombre;
        private String apellido;
        private LocalDate fechaNacimiento;
        private String password;
        
        public Builder correo(String correo) {
            this.correo = correo;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder apellido(String apellido) {
            this.apellido = apellido;
            return this;
        }

        public Builder fechaNacimiento(LocalDate fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }
        
  
    	public Usuario build() {
    		return new Usuario(this);
    	}
    	
    }
}
