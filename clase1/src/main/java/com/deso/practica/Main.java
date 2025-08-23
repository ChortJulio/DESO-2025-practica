package com.deso.practica;

import java.util.List;

import com.deso.practica.animal.Animal;
import com.deso.practica.animal.Gato;
import com.deso.practica.animal.Serpiente;

public class Main {
    public static void main(String[] args) {

        // instanciación y llamada a métodos
        Gato gato = new Gato();
        Serpiente serpiente = new Serpiente();

        gato.setNombre("pepito");
        serpiente.setNombre("snake");
        gato.hacerSonido();
        serpiente.hacerSonido();

        // polimorfismo
        Animal animal = gato;
        animal.hacerSonido();

        // utilidad de las interfaces:
        Persona persona = new Persona();
        List<Acariciable> acariciables = List.of(gato, serpiente, persona);
        System.out.println("\nAcariciar todos:");
        acariciables.forEach(p -> p.acariciar());

        // interfaces y clases abstractas
        System.out.println("\nAcariciar animales:");
        Acariciable gatoAcariciable = gato;
        Acariciable serpienteAcariciable = serpiente;
        gatoAcariciable.acariciar();
        serpienteAcariciable.acariciar();

        // clases anonimas
        System.out.println("\nCrear un nuevo Animal con comportamiento diferente, sin crear otro archivo ni definir otra clase");
        Animal nuevoAnimal = new Animal() {
            @Override
            public void hacerSonido() {
                System.out.println("soy un animal anonimo!");
            }
        };
        nuevoAnimal.hacerSonido();
    }
}