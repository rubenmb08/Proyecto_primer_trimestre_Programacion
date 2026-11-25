package codigo;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;

public class full {

    public static Scanner sc = new Scanner(System.in);
    public static Random rd = new Random();

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println(" LA LEYENDA DE LOS TRES REINOS");
        System.out.println("      EL DESPERTAR DE LA OSCURIDAD");
        System.out.println("======================================");
        System.out.println("Creado por: [Nombre 1] y [Nombre 2]");

        String contrasena = "";

        while (!contrasena.equals("jugones")) {
            System.out.print("\nIntroduce la contraseña: ");
            contrasena = sc.nextLine();

            if (!contrasena.equals("jugones")) {
                System.out.println("Contraseña incorrecta. Inténtalo de nuevo.");
            }
        }

        System.out.println("\n¡Bienvenido a los Tres Reinos!");

        boolean salir = false;

        while (!salir) {
            System.out.println("\n========== MENÚ PRINCIPAL ==========");
            System.out.println("1. Nueva aventura");
            System.out.println("2. Ver instrucciones");
            System.out.println("3. Salir");

            int opcion = Utilidades.pedirOpcion(1, 3);

            switch (opcion) {
                case 1:
                    seleccionarPersonaje();
                    break;
                case 2:
                    mostrarInstrucciones();
                    break;
                case 3:
                    salir = true;
                    System.out.println("Gracias por jugar. ¡Hasta pronto!");
                    break;
            }
        }

        sc.close();
    }

    public static void seleccionarPersonaje() {

        System.out.println("\n========== ELIGE TU PROTAGONISTA ==========");
        System.out.println("1. Sir Aldric - El caballero");
        System.out.println("2. Elara - La hechicera");
        System.out.println("3. Kael - El explorador");
        System.out.println("4. Volver al menú");

        int opcion = Utilidades.pedirOpcion(1, 4);

        switch (opcion) {
            case 1:
                Aldric.iniciarAventura();
                break;
            case 2:
                Elara.iniciarAventura();
                break;
            case 3:
                Kael.iniciarAventura();
                break;
            case 4:
                System.out.println("Volviendo al menú...");
                break;
        }
    }

    public static void mostrarInstrucciones() {
        System.out.println("\n========== INSTRUCCIONES ==========");
        System.out.println("1. Elige uno de los tres protagonistas.");
        System.out.println("2. Habla con personajes durante la aventura.");
        System.out.println("3. Supera pruebas para conseguir objetos.");
        System.out.println("4. Enfréntate al enemigo en una batalla.");
        System.out.println("5. Tus decisiones determinarán el final.");
        System.out.println("Cada protagonista tiene cinco finales posibles.");
    }
}


// =====================================================
// CLASE DE UTILIDADES
// =====================================================

class Utilidades {

    public static int pedirOpcion(int minimo, int maximo) {

        int opcion = 0;
        boolean correcta = false;

        while (!correcta) {

            System.out.print("Elige una opción: ");

            if (full.sc.hasNextInt()) {
                opcion = full.sc.nextInt();
                full.sc.nextLine();

                if (opcion >= minimo && opcion <= maximo) {
                    correcta = true;
                } else {
                    System.out.println("Opción fuera de rango.");
                }

            } else {
                System.out.println("Debes introducir un número.");
                full.sc.nextLine();
            }
        }

        return opcion;
    }

    public static void pausa() {
        System.out.println("\nPulsa INTRO para continuar...");
        full.sc.nextLine();
    }

    public static void separador() {
        System.out.println("--------------------------------------");
    }

    public static void titulo(String texto) {
        separador();
        System.out.println(texto);
        separador();
    }
}


// =====================================================
// CLASE DE JUEGOS Y PRUEBAS
// =====================================================

class Juegos {

    public static boolean adivinarNumero() {

        int numeroSecreto = full.rd.nextInt(10) + 1;

        System.out.println("\nADIVINA EL NÚMERO");
        System.out.println("Estoy pensando un número del 1 al 10.");
        System.out.println("Tienes tres intentos.");

        for (int i = 1; i <= 3; i++) {

            System.out.print("Intento " + i + ": ");
            int numero = Utilidades.pedirOpcion(1, 10);

            if (numero == numeroSecreto) {
                System.out.println("¡Correcto! Has acertado.");
                return true;
            } else if (numero < numeroSecreto) {
                System.out.println("El número secreto es mayor.");
            } else {
                System.out.println("El número secreto es menor.");
            }
        }

        System.out.println("No lo has conseguido. Era el " + numeroSecreto);
        return false;
    }

    public static boolean adivinanza() {

        System.out.println("\nADIVINANZA");
        System.out.println("Tengo agujas y no sé coser,");
        System.out.println("tengo números y no sé leer.");
        System.out.println("¿Qué soy?");
        System.out.println("1. Un reloj");
        System.out.println("2. Una espada");
        System.out.println("3. Un árbol");

        int opcion = Utilidades.pedirOpcion(1, 3);

        if (opcion == 1) {
            System.out.println("¡Correcto!");
            return true;
        }

        System.out.println("Respuesta incorrecta.");
        return false;
    }

    public static boolean piedraPapelTijera() {

        System.out.println("\nPIEDRA, PAPEL O TIJERA");
        System.out.println("1. Piedra");
        System.out.println("2. Papel");
        System.out.println("3. Tijera");

        int jugador = Utilidades.pedirOpcion(1, 3);
        int maquina = full.rd.nextInt(3) + 1;

        System.out.println("El rival ha elegido: " + nombreJugada(maquina));

        if (jugador == maquina) {
            System.out.println("¡Empate!");
            return false;
        }

        if ((jugador == 1 && maquina == 3)
                || (jugador == 2 && maquina == 1)
                || (jugador == 3 && maquina == 2)) {
            System.out.println("¡Has ganado!");
            return true;
        }

        System.out.println("Has perdido.");
        return false;
    }

    public static String nombreJugada(int numero) {

        switch (numero) {
            case 1:
                return "Piedra";
            case 2:
                return "Papel";
            default:
                return "Tijera";
        }
    }

    public static boolean caraOCruz() {

        System.out.println("\nCARA O CRUZ");
        System.out.println("1. Cara");
        System.out.println("2. Cruz");

        int jugador = Utilidades.pedirOpcion(1, 2);
        int resultado = full.rd.nextInt(2) + 1;

        if (resultado == 1) {
            System.out.println("Ha salido CARA.");
        } else {
            System.out.println("Ha salido CRUZ.");
        }

        if (jugador == resultado) {
            System.out.println("¡Has acertado!");
            return true;
        }

        System.out.println("No has acertado.");
        return false;
    }

    public static boolean codigoSimbolos() {

        System.out.println("\nEL CÓDIGO DE LOS SÍMBOLOS");
        System.out.println("Cada símbolo representa un número:");
        System.out.println("Sol = 1, Luna = 2, Estrella = 3");
        System.out.println("¿Qué número representa Luna + Estrella?");
        System.out.println("1. 4");
        System.out.println("2. 5");
        System.out.println("3. 6");

        int opcion = Utilidades.pedirOpcion(1, 3);

        if (opcion == 1) {
            System.out.println("¡Código descifrado!");
            return true;
        }

        System.out.println("El código es incorrecto.");
        return false;
    }

    public static boolean laberinto() {

        System.out.println("\nEL LABERINTO");
        System.out.println("Te encuentras ante tres caminos.");
        System.out.println("¿Qué camino eliges?");
        System.out.println("1. Camino de la izquierda");
        System.out.println("2. Camino central");
        System.out.println("3. Camino de la derecha");

        int opcion = Utilidades.pedirOpcion(1, 3);

        if (opcion == 2) {
            System.out.println("¡Has encontrado la salida!");
            return true;
        }

        System.out.println("El camino no lleva a ninguna parte.");
        return false;
    }

    public static boolean secuenciaMagica() {

        System.out.println("\nSECUENCIA MÁGICA");
        System.out.println("Recuerda esta secuencia: 2 - 4 - 6");
        System.out.println("¿Cuál es el siguiente número?");
        System.out.println("1. 7");
        System.out.println("2. 8");
        System.out.println("3. 10");

        int opcion = Utilidades.pedirOpcion(1, 3);

        if (opcion == 2) {
            System.out.println("¡Has dominado la secuencia!");
            return true;
        }

        System.out.println("La secuencia era 8.");
        return false;
    }

    public static boolean preguntasMagicas() {

        System.out.println("\nPREGUNTA MÁGICA");
        System.out.println("¿Qué elemento representa normalmente el fuego?");
        System.out.println("1. El hielo");
        System.out.println("2. La llama");
        System.out.println("3. La piedra");

        int opcion = Utilidades.pedirOpcion(1, 3);

        if (opcion == 2) {
            System.out.println("¡Respuesta correcta!");
            return true;
        }

        System.out.println("Respuesta incorrecta.");
        return false;
    }

    public static boolean abrirCofre() {

        System.out.println("\nEL COFRE MISTERIOSO");
        System.out.println("El cofre tiene una cerradura con un código.");
        System.out.println("¿Cuánto es 5 x 3 + 2?");
        System.out.println("1. 17");
        System.out.println("2. 20");
        System.out.println("3. 16");

        int opcion = Utilidades.pedirOpcion(1, 3);

        if (opcion == 1) {
            System.out.println("¡El cofre se ha abierto!");
            return true;
        }

        System.out.println("El código no funciona.");
        return false;
    }
}


// =====================================================
// CLASE DE INVENTARIO
// =====================================================

class Inventario {

    public static void agregarObjeto(ArrayList<String> inventario, String objeto) {

        if (!inventario.contains(objeto)) {
            inventario.add(objeto);
            System.out.println("Has conseguido: " + objeto);
        }
    }

    public static boolean tieneObjeto(ArrayList<String> inventario, String objeto) {
        return inventario.contains(objeto);
    }

    public static void mostrarInventario(ArrayList<String> inventario) {

        System.out.println("\n========== INVENTARIO ==========");

        if (inventario.size() == 0) {
            System.out.println("No tienes objetos.");
        } else {
            for (int i = 0; i < inventario.size(); i++) {
                System.out.println("- " + inventario.get(i));
            }
        }
    }
}


// =====================================================
// CLASE DE COMBATE
// =====================================================

class Combate {

    public static boolean iniciarCombate(
            String jugador, String enemigo,
            String[] ataquesJugador, int[] danosJugador,
            String[] ataquesEnemigo, int[] danosEnemigo) {

        int vidaJugador = 100;
        int vidaEnemigo = 100;

        boolean turnoJugador = full.rd.nextBoolean();

        System.out.println("\n========== COMBATE ==========");
        System.out.println(jugador + " VS " + enemigo);
        System.out.println("Cada combatiente comienza con 100 puntos de vida.");

        if (turnoJugador) {
            System.out.println("¡Empiezas tú!");
        } else {
            System.out.println("¡Empieza " + enemigo + "!");
        }

        while (vidaJugador > 0 && vidaEnemigo > 0) {

            System.out.println("\n" + jugador + ": " + vidaJugador + " PV");
            System.out.println(enemigo + ": " + vidaEnemigo + " PV");

            if (turnoJugador) {

                System.out.println("\nElige tu ataque:");

                for (int i = 0; i < ataquesJugador.length; i++) {
                    System.out.println((i + 1) + ". " + ataquesJugador[i]
                            + " (" + danosJugador[i] + " de daño)");
                }

                int opcion = Utilidades.pedirOpcion(1, ataquesJugador.length) - 1;

                System.out.println(jugador + " utiliza " + ataquesJugador[opcion] + ".");

                int dano = calcularDano(danosJugador[opcion]);
                vidaEnemigo = vidaEnemigo - dano;

                if (vidaEnemigo < 0) {
                    vidaEnemigo = 0;
                }

            } else {

                int ataque = full.rd.nextInt(ataquesEnemigo.length);

                System.out.println(enemigo + " utiliza " + ataquesEnemigo[ataque] + ".");

                int dano = calcularDano(danosEnemigo[ataque]);
                vidaJugador = vidaJugador - dano;

                if (vidaJugador < 0) {
                    vidaJugador = 0;
                }
            }

            turnoJugador = !turnoJugador;
            Utilidades.pausa();
        }

        if (vidaJugador > 0) {
            System.out.println("\n¡Has derrotado a " + enemigo + "!");
            return true;
        } else {
            System.out.println("\n" + enemigo + " te ha derrotado.");
            return false;
        }
    }

    public static int calcularDano(int danoBase) {

        int resultado = full.rd.nextInt(100) + 1;

        if (resultado <= 50) {
            System.out.println("¡Ataque completo!");
            return danoBase;

        } else if (resultado <= 80) {
            System.out.println("Ataque parcial.");
            return danoBase / 2;

        } else {
            System.out.println("¡Ataque esquivado!");
            return 0;
        }
    }
}


// =====================================================
// CLASE DE ESTADÍSTICAS
// =====================================================

class Estadisticas {

    public static HashMap<String, Integer> puntuaciones = new HashMap<>();

    public static void registrarVictoria(String personaje) {

        if (puntuaciones.containsKey(personaje)) {
            int puntos = puntuaciones.get(personaje);
            puntuaciones.put(personaje, puntos + 30);
        } else {
            puntuaciones.put(personaje, 30);
        }
    }

    public static void mostrarPuntuaciones() {

        System.out.println("\n========== PUNTUACIONES ==========");

        if (puntuaciones.size() == 0) {
            System.out.println("Todavía no hay puntuaciones.");
        } else {
            for (String personaje : puntuaciones.keySet()) {
                System.out.println(personaje + ": " + puntuaciones.get(personaje) + " puntos");
            }
        }
    }
}


// =====================================================
// AVENTURA DE SIR ALDRIC
// =====================================================

class Aldric {

    public static void iniciarAventura() {

        ArrayList<String> inventario = new ArrayList<>();

        System.out.println("\n======================================");
        System.out.println("        LA AVENTURA DE ALDRIC");
        System.out.println("======================================");

        System.out.println("El rey Alaric te ha convocado al castillo.");
        System.out.println("La Corona de los Tres Reinos ha sido robada.");
        System.out.println("Tu misión es recuperarla.");

        Utilidades.pausa();

        System.out.println("\nREY ALARIC:");
        System.out.println("Aldric, necesito que recuperes la corona.");
        System.out.println("El hechicero Malakar amenaza nuestros reinos.");

        boolean abandonar = preguntarAbandono();

        if (abandonar) {
            finalAldric(3);
            return;
        }

        System.out.println("\nBORIN, EL HERRERO:");
        System.out.println("Si resuelves mi adivinanza, mejoraré tu espada.");

        boolean acertijo = Juegos.adivinanza();

        if (acertijo) {
            Inventario.agregarObjeto(inventario, "Espada mejorada");
        }

        Utilidades.pausa();

        System.out.println("\nGRUK, EL MERCADER:");
        System.out.println("Adivina mi número y podrás conseguir una llave.");

        boolean numero = Juegos.adivinarNumero();

        if (numero) {
            Inventario.agregarObjeto(inventario, "Llave antigua");
        }

        System.out.println("\nGruk te propone otro desafío.");
        boolean piedra = Juegos.piedraPapelTijera();

        if (piedra) {
            Inventario.agregarObjeto(inventario, "Moneda de la suerte");
        }

        System.out.println("\nAntes de continuar, debes abrir un cofre.");
        boolean cofre = Juegos.abrirCofre();

        if (cofre) {
            Inventario.agregarObjeto(inventario, "Mapa secreto");
        }

        Inventario.mostrarInventario(inventario);

        String[] ataques = {"Espadazo", "Golpe poderoso", "Estocada"};
        int[] danos = {15, 25, 20};

        String[] ataquesDarius = {"Golpe oscuro", "Espadazo pesado", "Ataque sombrío"};
        int[] danosDarius = {15, 20, 25};

        System.out.println("\nDARIUS, EL CABALLERO OSCURO:");
        System.out.println("¡Nadie recuperará la corona mientras yo siga aquí!");

        boolean victoria = Combate.iniciarCombate(
                "Aldric", "Darius",
                ataques, danos, ataquesDarius, danosDarius);

        if (!victoria) {
            finalAldric(4);
            return;
        }

        Estadisticas.registrarVictoria("Aldric");

        if (acertijo && numero && cofre) {
            System.out.println("\nHas encontrado una cámara secreta.");
            System.out.println("La llave abre una sala que revela el origen de la corona.");
            finalAldric(5);
        } else {
            System.out.println("\nHas recuperado la Corona de los Tres Reinos.");
            System.out.println("¿Qué deseas hacer?");
            System.out.println("1. Devolver la corona al rey.");
            System.out.println("2. Quedarte con la corona y convertirte en rey.");

            int opcion = Utilidades.pedirOpcion(1, 2);

            if (opcion == 1) {
                finalAldric(1);
            } else {
                finalAldric(2);
            }
        }
    }

    public static boolean preguntarAbandono() {
        System.out.println("\n¿Aceptas la misión?");
        System.out.println("1. Sí");
        System.out.println("2. No, abandonar");

        return Utilidades.pedirOpcion(1, 2) == 2;
    }

    public static void finalAldric(int finalNumero) {

        Utilidades.titulo("FINAL DE ALDRIC");

        switch (finalNumero) {
            case 1:
                System.out.println("FINAL 1: HÉROE DEL REINO");
                System.out.println("Devuelves la corona y los tres reinos recuperan la paz.");
                break;
            case 2:
                System.out.println("FINAL 2: EL NUEVO REY");
                System.out.println("Te quedas la corona y gobiernas los tres reinos.");
                break;
            case 3:
                System.out.println("FINAL 3: EL ABANDONO");
                System.out.println("Decides no aceptar la misión del rey.");
                break;
            case 4:
                System.out.println("FINAL 4: LA DERROTA");
                System.out.println("Darius te vence y la corona continúa en manos oscuras.");
                break;
            case 5:
                System.out.println("FINAL 5: EL SECRETO DE LA CORONA");
                System.out.println("Descubres el origen de la corona y su poder oculto.");
                break;
        }
    }
}


// =====================================================
// AVENTURA DE ELARA
// =====================================================

class Elara {

    public static void iniciarAventura() {

        ArrayList<String> inventario = new ArrayList<>();

        System.out.println("\n======================================");
        System.out.println("        LA AVENTURA DE ELARA");
        System.out.println("======================================");

        System.out.println("El rey Alaric te entrega un antiguo pergamino.");
        System.out.println("Debes recuperar tres fragmentos mágicos.");

        System.out.println("\nREY ALARIC:");
        System.out.println("El poder de la corona depende de esos fragmentos.");

        if (Aldric.preguntarAbandono()) {
            finalElara(3);
            return;
        }

        System.out.println("\nMERLIÓN, EL SABIO:");
        System.out.println("Para conseguir el primer fragmento debes dominar la magia.");

        boolean secuencia = Juegos.secuenciaMagica();

        if (secuencia) {
            Inventario.agregarObjeto(inventario, "Primer fragmento mágico");
        }

        Utilidades.pausa();

        System.out.println("\nGRUK, EL MERCADER:");
        System.out.println("Gana mi desafío de cara o cruz y recibirás ayuda.");

        boolean moneda = Juegos.caraOCruz();

        if (moneda) {
            Inventario.agregarObjeto(inventario, "Segundo fragmento mágico");
        }

        System.out.println("\nHas encontrado un antiguo libro de hechizos.");
        boolean libro = Juegos.codigoSimbolos();

        if (libro) {
            Inventario.agregarObjeto(inventario, "Poción mágica");
        }

        System.out.println("\nMORGANA, LA BRUJA:");
        System.out.println("Si respondes a mi pregunta, conocerás el secreto del tercer fragmento.");

        boolean pregunta = Juegos.preguntasMagicas();

        if (pregunta) {
            Inventario.agregarObjeto(inventario, "Tercer fragmento mágico");
        }

        System.out.println("\nMorgana no te dejará marchar sin luchar.");
        boolean libroCorrecto = Juegos.abrirCofre();

        if (libroCorrecto) {
            Inventario.agregarObjeto(inventario, "Hechizo protector");
        }

        Inventario.mostrarInventario(inventario);

        String[] ataques = {"Rayo mágico", "Bola de fuego", "Descarga arcana"};
        int[] danos = {15, 25, 20};

        String[] ataquesMorgana = {"Rayo oscuro", "Maldición", "Explosión mágica"};
        int[] danosMorgana = {15, 20, 25};

        boolean victoria = Combate.iniciarCombate(
                "Elara", "Morgana",
                ataques, danos, ataquesMorgana, danosMorgana);

        if (!victoria) {
            finalElara(4);
            return;
        }

        Estadisticas.registrarVictoria("Elara");

        if (secuencia && moneda && pregunta) {
            System.out.println("\n¡Has reunido los tres fragmentos!");
            finalElara(5);
        } else {
            System.out.println("\nHas derrotado a Morgana.");
            System.out.println("¿Qué harás con el poder mágico?");
            System.out.println("1. Restaurar la magia de la corona.");
            System.out.println("2. Quedarte con todo el poder.");

            int opcion = Utilidades.pedirOpcion(1, 2);

            if (opcion == 1) {
                finalElara(1);
            } else {
                finalElara(2);
            }
        }
    }

    public static void finalElara(int finalNumero) {

        Utilidades.titulo("FINAL DE ELARA");

        switch (finalNumero) {
            case 1:
                System.out.println("FINAL 1: SALVADORA MÁGICA");
                System.out.println("Restauras la magia y devuelves la paz a los reinos.");
                break;
            case 2:
                System.out.println("FINAL 2: HECHICERA SUPREMA");
                System.out.println("Te quedas con el poder mágico de la corona.");
                break;
            case 3:
                System.out.println("FINAL 3: CONOCIMIENTO PERDIDO");
                System.out.println("Abandonas la misión y los fragmentos siguen perdidos.");
                break;
            case 4:
                System.out.println("FINAL 4: LA MALDICIÓN DE MORGANA");
                System.out.println("Morgana vence y conserva el poder mágico.");
                break;
            case 5:
                System.out.println("FINAL 5: EL ORIGEN DE LA MAGIA");
                System.out.println("Descubres el origen de los tres fragmentos mágicos.");
                break;
        }
    }
}


// =====================================================
// AVENTURA DE KAEL
// =====================================================

class Kael {

    public static void iniciarAventura() {

        ArrayList<String> inventario = new ArrayList<>();

        System.out.println("\n======================================");
        System.out.println("        LA AVENTURA DE KAEL");
        System.out.println("======================================");

        System.out.println("Eres Kael, un explorador experto.");
        System.out.println("Debes infiltrarte en el territorio de Malakar.");

        System.out.println("\nLYRA, LA ARQUERA:");
        System.out.println("Puedo ayudarte a encontrar una ruta hacia el castillo.");

        if (Aldric.preguntarAbandono()) {
            finalKael(3);
            return;
        }

        System.out.println("\nDebes atravesar un antiguo laberinto.");
        boolean laberinto = Juegos.laberinto();

        if (laberinto) {
            Inventario.agregarObjeto(inventario, "Mapa del bosque");
        }

        Utilidades.pausa();

        System.out.println("\nGRUK, EL MERCADER:");
        System.out.println("Si ganas mi juego de cara o cruz, te daré un mapa.");

        boolean moneda = Juegos.caraOCruz();

        if (moneda) {
            Inventario.agregarObjeto(inventario, "Mapa antiguo");
        }

        System.out.println("\nBORIN, EL HERRERO:");
        System.out.println("Descifra este código para conseguir herramientas.");

        boolean codigo = Juegos.codigoSimbolos();

        if (codigo) {
            Inventario.agregarObjeto(inventario, "Herramientas");
        }

        System.out.println("\nAntes de llegar al castillo, debes resolver una adivinanza.");
        boolean acertijo = Juegos.adivinanza();

        if (acertijo) {
            Inventario.agregarObjeto(inventario, "Brújula");
        }

        System.out.println("\nUn último desafío te espera.");
        boolean numero = Juegos.adivinarNumero();

        if (numero) {
            Inventario.agregarObjeto(inventario, "Llave del castillo");
        }

        Inventario.mostrarInventario(inventario);

        String[] ataques = {"Flecha rápida", "Disparo preciso", "Flecha doble"};
        int[] danos = {15, 25, 20};

        String[] ataquesDarius = {"Golpe oscuro", "Espadazo pesado", "Ataque sombrío"};
        int[] danosDarius = {15, 20, 25};

        System.out.println("\nDARIUS, EL CABALLERO OSCURO:");
        System.out.println("¡No permitiré que llegues hasta Malakar!");

        boolean victoria = Combate.iniciarCombate(
                "Kael", "Darius",
                ataques, danos, ataquesDarius, danosDarius);

        if (!victoria) {
            finalKael(4);
            return;
        }

        Estadisticas.registrarVictoria("Kael");

        if (moneda && codigo) {
            System.out.println("\nHas encontrado un mapa secreto de los tres reinos.");
            finalKael(5);
        } else {
            System.out.println("\nHas conseguido información sobre Malakar.");
            System.out.println("¿Qué harás con ella?");
            System.out.println("1. Entregarla al rey.");
            System.out.println("2. Quedarte con el tesoro descubierto.");

            int opcion = Utilidades.pedirOpcion(1, 2);

            if (opcion == 1) {
                finalKael(1);
            } else {
                finalKael(2);
            }
        }
    }

    public static void finalKael(int finalNumero) {

        Utilidades.titulo("FINAL DE KAEL");

        switch (finalNumero) {
            case 1:
                System.out.println("FINAL 1: GUARDIÁN DE LOS REINOS");
                System.out.println("Entregas la información al rey y ayudas a salvar los reinos.");
                break;
            case 2:
                System.out.println("FINAL 2: EL TESORO OCULTO");
                System.out.println("Te quedas con el tesoro y te conviertes en un explorador rico.");
                break;
            case 3:
                System.out.println("FINAL 3: EXPLORADOR SOLITARIO");
                System.out.println("Abandonas la misión y continúas tu camino en solitario.");
                break;
            case 4:
                System.out.println("FINAL 4: LA EMBOSCADA");
                System.out.println("Darius te derrota y Malakar continúa con sus planes.");
                break;
            case 5:
                System.out.println("FINAL 5: EL MAPA DE LOS TRES REINOS");
                System.out.println("Descubres una ruta secreta que puede cambiar el destino del reino.");
                break;
        }
    }
}


