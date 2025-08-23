package com.deso.practica;

public class Persona implements Acariciable {
    private String nombre;
    private String apellido;
    private Integer edad;

    @Override
    public void acariciar() {
        System.out.println("relajante....");
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
