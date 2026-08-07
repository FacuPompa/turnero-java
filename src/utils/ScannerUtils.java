package src.utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import src.enums.Especialidad;

public class ScannerUtils {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static String leerTexto(String mensaje) {
        while (true) {
            System.out.println(mensaje + ": ");
            String texto = SCANNER.nextLine().trim();

            if (!texto.isBlank()) {
                return texto;
            }

            System.out.println("Este campo es obligatorio. Ingrese un valor.");
        }
    }

    public static String leerEmail(String mensaje) {
        while (true) {
            String email = leerTexto(mensaje).trim();
            int posicionArroba = email.indexOf("@");
            int posicionCom = email.toLowerCase().lastIndexOf(".com");

            if (posicionArroba > 0
                    && posicionCom > posicionArroba + 1
                    && posicionCom == email.length() - 4) {
                return email;
            }

            System.out.println("Email inválido. Debe incluir @ y terminar en .com.");
        }
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

    public static LocalDate leerFecha(String mensaje) {
        System.out.println("Formato: AAAA-MM-DD");
        System.out.println(mensaje + ": ");
        while (true) {
            String fechaStr = SCANNER.nextLine();
            try {
                return LocalDate.parse(fechaStr);
            } catch (Exception e) {
                System.out.println("Fecha inválida. Por favor, ingrese una fecha en el formato AAAA-MM-DD.");
            }
        }
    }

    public static LocalTime leerHora(String mensaje) {
        System.out.println("Formato: HH:MM");
        System.out.println(mensaje + ": ");
        while (true) {
            String horaStr = SCANNER.nextLine();
            try {
                return LocalTime.parse(horaStr);
            } catch (Exception e) {
                System.out.println("Hora inválida. Por favor, ingrese una hora en el formato HH:MM.");
            }
        }
    }
}

