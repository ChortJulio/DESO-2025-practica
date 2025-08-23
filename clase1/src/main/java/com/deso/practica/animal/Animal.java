package com.deso.practica.animal;

public abstract class Animal {

    protected String nombre;
    protected Integer cantPatas;
    protected TipoAnimal tipo;

    protected abstract void hacerSonido();

    public void setCantPatas(Integer cantPatas) {
        this.cantPatas = cantPatas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(TipoAnimal tipo) {
        this.tipo = tipo;
    }

    public Integer getCantPatas() {
        return cantPatas;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoAnimal getTipo() {
        return tipo;
    }
}
