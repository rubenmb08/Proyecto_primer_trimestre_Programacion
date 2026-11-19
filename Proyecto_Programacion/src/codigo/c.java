package codigo;

import java.util.Scanner;
import java.util.Random;

public class c {

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {

        int opcion;

        do {
            System.out.println("\n===== BUSCADOR DE TESOROS =====");
            System.out.println("1. Nueva partida");
            System.out.println("2. Salir");
            System.out.print("Elige una opcion: ");

            if (sc.hasNextInt()) {
                opcion = sc.nextInt();

                if (opcion == 1) {
                    jugar();
                } else if (opcion == 2) {
                    System.out.println("Hasta pronto!");
                } else {
                    System.out.println("Opcion incorrecta.");
                }

            } else {
                sc.next();
                opcion = 0;
                System.out.println("Debes introducir un numero.");
            }

        } while (opcion != 2);

        sc.close();
    }

    // Metodo para jugar una partida
    public static void jugar() {

        char[][] tablero = new char[5][5];
        boolean[][] descubierto = new boolean[5][5];

        int intentos = 12;
        int tesoros = 0;

        // Rellenamos el tablero con casillas vacias
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                tablero[i][j] = '.';
            }
        }

        // Colocamos los 5 tesoros
        for (int i = 0; i < 5; i++) {
            colocarElemento(tablero, 'T');
        }

        // Colocamos las 3 trampas
        for (int i = 0; i < 3; i++) {
            colocarElemento(tablero, 'P');
        }

        // Comienza la partida
        while (intentos > 0 && tesoros < 5) {

            mostrarTablero(tablero, descubierto);

            System.out.println("\nIntentos restantes: " + intentos);
            System.out.println("Tesoros encontrados: " + tesoros + "/5");

            int fila;
            int columna;

            // Pedimos una fila correcta
            do {
                System.out.print("\nIntroduce la fila (1-5): ");

                while (!sc.hasNextInt()) {
                    sc.next();
                    System.out.println("Debes introducir un numero entero.");
                    System.out.print("Introduce la fila (1-5): ");
                }

                fila = sc.nextInt();

                if (fila < 1 || fila > 5) {
                    System.out.println("La fila debe estar entre 1 y 5.");
                }

            } while (fila < 1 || fila > 5);

            // Pedimos una columna correcta
            do {
                System.out.print("Introduce la columna (1-5): ");

                while (!sc.hasNextInt()) {
                    sc.next();
                    System.out.println("Debes introducir un numero entero.");
                    System.out.print("Introduce la columna (1-5): ");
                }

                columna = sc.nextInt();

                if (columna < 1 || columna > 5) {
                    System.out.println("La columna debe estar entre 1 y 5.");
                }

            } while (columna < 1 || columna > 5);

            // Convertimos las coordenadas a indices
            fila = fila - 1;
            columna = columna - 1;

            // Comprobamos si ya se ha descubierto
            if (descubierto[fila][columna]) {

                System.out.println("Esta casilla ya ha sido descubierta.");

            } else {

                descubierto[fila][columna] = true;

                // Comprobamos el contenido de la casilla
                if (tablero[fila][columna] == 'T') {

                    System.out.println("Has encontrado un TESORO!");
                    tesoros++;
                    intentos--;

                } else if (tablero[fila][columna] == 'P') {

                    System.out.println("Has encontrado una TRAMPA!");
                    intentos = intentos - 2;

                } else {

                    System.out.println("No hay nada. Casilla vacia.");
                    intentos--;

                }

                // Evitamos que los intentos sean negativos
                if (intentos < 0) {
                    intentos = 0;
                }
            }
        }

        // Mostramos el tablero completo al terminar
        System.out.println("\n===== FIN DE LA PARTIDA =====");

        mostrarTableroCompleto(tablero);

        if (tesoros == 5) {
            System.out.println("\nFELICIDADES! HAS GANADO!");
        } else {
            System.out.println("\nHAS PERDIDO!");
        }

        System.out.println("Tesoros encontrados: " + tesoros + "/5");
        System.out.println("Intentos restantes: " + intentos);
    }

    // Metodo para colocar tesoros y trampas aleatoriamente
    public static void colocarElemento(char[][] tablero, char elemento) {

        int fila;
        int columna;

        do {
            fila = random.nextInt(5);
            columna = random.nextInt(5);

        } while (tablero[fila][columna] != '.');

        tablero[fila][columna] = elemento;
    }

    // Metodo para mostrar el tablero durante la partida
    public static void mostrarTablero(char[][] tablero, boolean[][] descubierto) {

        System.out.println("\n     1  2  3  4  5");

        for (int i = 0; i < 5; i++) {

            System.out.print(" " + (i + 1) + "   ");

            for (int j = 0; j < 5; j++) {

                if (descubierto[i][j]) {
                    System.out.print(tablero[i][j] + "  ");
                } else {
                    System.out.print("?  ");
                }
            }

            System.out.println();
        }
    }

    // Metodo para mostrar el tablero completo
    public static void mostrarTableroCompleto(char[][] tablero) {

        System.out.println("\n     1  2  3  4  5");

        for (int i = 0; i < 5; i++) {

            System.out.print(" " + (i + 1) + "   ");

            for (int j = 0; j < 5; j++) {
                System.out.print(tablero[i][j] + "  ");
            }

            System.out.println();
        }
    }
}


