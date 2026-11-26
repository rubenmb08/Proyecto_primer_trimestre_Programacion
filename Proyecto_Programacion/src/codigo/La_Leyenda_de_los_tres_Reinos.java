
package codigo;

import java.util.Scanner;
import java.util.Random;
import java.util.HashMap;


public class La_Leyenda_de_los_tres_Reinos {

    static Scanner sc = new Scanner(System.in);
    static Random rd = new Random();
    
    public static void main(String[] args) {

            System.out.println("LA LEYENDA DE LOS TRES REINOS");
            System.out.println("-El Despertar de la Oscuridad-");
            System.out.println("\nDesarrollado por Jorge Hernández y Rubén Martínez");

            String contraseña;

            // Comprobar contraseña
            do {
                System.out.print("\nIntroduce la contraseña para entrar al juego: ");
                contraseña = sc.nextLine();

                if (!"jugones".equals(contraseña)) {
                    System.out.println("Contraseña incorrecta, inténtalo de nuevo");
                }

            } while (!"jugones".equals(contraseña));

            System.out.println("\nContraseña correcta, estás dentro del juego\n");

            int opcion = 0;

            // Menú principal
            do {

                System.out.println("1. Nueva partida");
                System.out.println("2. Salir");

                System.out.print("\nElige una opción: ");

                if (sc.hasNextInt()) {

                    opcion = sc.nextInt();
                    sc.nextLine();

                    if (opcion == 1) {

                        nuevaPartida();

                    } else if (opcion == 2) {

                        System.out.println("¡Hasta pronto!");

                    } else {

                        System.out.println("Opción incorrecta");
                    }

                } else {

                    sc.nextLine();
                    opcion = 0;

                    System.out.println("Debes introducir un número");
                }

            } while (opcion != 2);
        }    

    // Nueva Partida
    public static void nuevaPartida() {

        Random rd = new Random();

        String txt = "\nHace siglos, tres reinos vivían en paz gracias a una reliquia mágica conocida como la Corona de los Tres Reinos.\r\n"
                + "\r\n"
                + "Una noche, el hechicero Malakar robó la corona y comenzó a extender la oscuridad por todos los territorios.\r\n"
                + "\r\n"
                + "El rey Alaric convoca a tres aventureros para recuperar la reliquia:\r\n"
                + "- Sir Aldric, un caballero experto en combate.\r\n"
                + "- Elara, una hechicera que domina la magia.\r\n"
                + "- Kael, un explorador experto en infiltración y supervivencia.\n";

        // Escribir la historia poco a poco
        for (int i = 0; i < txt.length(); i++) {

            try {

                System.out.print(txt.charAt(i));
                Thread.sleep(rd.nextInt(100));

            } catch (Exception e) {

            }
        }

        // Selección de personaje
        int personaje = 0;

        do {

            System.out.println("\nEscoge tu personaje:");
            System.out.println("1. Sir Aldric");
            System.out.println("2. Elara");
            System.out.println("3. Kael");

            System.out.print("\nElige una opción: ");

            if (sc.hasNextInt()) {

                personaje = sc.nextInt();
                sc.nextLine();

                if (personaje == 1) {
                    SirAldric();

                } else if (personaje == 2) {
                    Elara();

                } else if (personaje == 3) {
                    Kael();

                } else {

                    System.out.println("Error, introduce una opción válida");
                }

            } else {
                sc.nextLine();
                personaje = 0;

                System.out.println("Debes introducir un número");
            }

        } while (personaje < 1 || personaje > 3);

    }

    // 

    public static void SirAldric() {
        

    }

    public static void Elara() {
    	boolean fragmento1 = false;
    	boolean fragmento2 = false;
    	boolean fragmento3 = false;
    	boolean tienePocion = false;
    	boolean haVencidoMorgana = false;
    	boolean quiereAbandonar = false;
    	
        System.out.println("\nHas elegido a Elara, la hechicera.");
        System.out.println("\nEl rey entrega a Elara un pergamino que explica que la corona está protegida por un hechizo.");
        
    }

    public static void Kael() {
    	boolean tieneMapa = false;
    	boolean tieneHerramientas = false;
    	boolean haEncontradoRutaSecreta = false;
    	boolean haVencidoDarius = false;
    	boolean quiereAbandonar = false;
    	
        System.out.println("\nHas elegido a Kael, el explorador.");        

    }
    
    public static void continuar() {
    	System.out.println("\nPulsa INTRO para continuar");
    	sc.nextLine();
    }

}
