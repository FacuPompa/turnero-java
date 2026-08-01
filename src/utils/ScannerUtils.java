package src.utils;

import java.util.Scanner;

import src.enums.Especialidad;

public class ScannerUtils {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static String leerTexto(String mensaje) {
        System.out.println(mensaje + ": ");
        return SCANNER.nextLine();
    }

    public static int leerEntero(String mensaje) {
        System.out.println(mensaje + ": ");
        while (!SCANNER.hasNextInt()) {
            System.out.println("Por favor, ingrese un número válido.");
            SCANNER.next();
        }
        int dato = SCANNER.nextInt();
        SCANNER.nextLine();
        return dato;
    }

    public static Especialidad leerEspecialidad(String mensaje) {
        while(true) {
            System.out.println(mensaje);
            for (Especialidad especialidad : Especialidad.values()) {
                System.out.println("-" + especialidad.name());
            }
            System.out.println("Elegi una opcion");
            String entrada = SCANNER.nextLine().toUpperCase();

            try {
                return Especialidad.valueOf(entrada.toUpperCase());
            } catch (IllegalArgumentException e){
                System.out.println("Especialidad inválida." + mensaje + ":");
            }
        }
    }
}

