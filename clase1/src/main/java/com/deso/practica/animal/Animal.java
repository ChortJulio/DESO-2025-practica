package com.deso.practica.animal;

import com.deso.practica.Acariciable;

public abstract class Animal implements Acariciable {

  protected String nombre;
  protected Integer cantPatas;
  protected TipoAnimal tipo;

  public abstract void hacerSonido();

  @Override
  public void acariciar() {
    System.out.println("animal acariciado");
  }

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
