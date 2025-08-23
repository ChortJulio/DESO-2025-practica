package com.deso.practica.animal;

public abstract class Animal {

    protected String nombre;
    protected Integer cantPatas;
    protected TipoAnimal tipo;

    protected abstract void hacerSonido();
}
