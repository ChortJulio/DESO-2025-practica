package com.deso.practica.animal;

public class Serpiente extends Animal {

    @Override
    protected void hacerSonido() {
        System.out.println("Ssssssss");
    }

    @Override
    public void acariciar() {
        System.out.println("serpiente acariciada :)");
    }
    
}
