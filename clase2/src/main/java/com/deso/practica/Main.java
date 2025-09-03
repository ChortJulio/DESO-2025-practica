package com.deso.practica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.deso.practica.exceptions.UsuarioNoExistenteException;
import com.deso.practica.service.ValidadorLogin;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // LOGIN
            System.out.print("Ingrese usuario: ");
            String usuario = sc.nextLine();

            System.out.print("Ingrese contraseña: ");
            String contrasena = sc.nextLine();
            
            ValidadorLogin validador = new ValidadorLogin();

            if (!validador.validar(usuario, contrasena)) {
                System.out.println("❌ Contraseña incorrecta.");
                return;
            }

            System.out.println("✅ Login exitoso.");

            // MENU
            System.out.println("Ingrese opción (1 = guardar clave secreta, 2 = leer clave secreta): ");
            int opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            String filename = usuario + ".txt";
            File archivo = new File(filename);

            if (opcion == 1) {
                System.out.print("Ingrese su clave supersecreta: ");
                String secreto = sc.nextLine();

                try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
                    bw.write(secreto);
                }

                System.out.println("✅ Clave secreta guardada en " + filename);

            } else if (opcion == 2) {
                if (!archivo.exists()) {
                    System.out.println("⚠ Usuario sin clave supersecreta.");
                } else {
                    try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                        String contenido = br.readLine();
                        System.out.println("🔑 Clave secreta: " + contenido);
                    }
                }
            } else {
                System.out.println("⚠ Opción inválida.");
            }

        } catch (UsuarioNoExistenteException e) {
            System.out.println("❌ Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("❌ Error de entrada/salida: " + e.getMessage());
        }
    }
}
