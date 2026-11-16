package codigo;

import java.util.Scanner;
import java.util.Random;

public class La_Leyenda_de_los_tres_Reinos {

	public static void main(String[] args) {
			System.out.println("LA LEYENDA DE LOS TRES REINOS");
			System.out.println("-El Despertar de la Oscuridad-");
			System.out.println("\nDesarrollado por Jorge Hernández y Rubén Martínez");
			
			Scanner sc = new Scanner(System.in);
			
			String contraseña;
			
			do {
				System.out.print("\nIntroduce la contraseña para entrar al juego: ");
				contraseña = sc.nextLine();
				
				if (!"jugones".equals(contraseña)) {
					System.out.println("Contraseña incorrecta, intentalo de nuevo");
				}
			}while (!"jugones".equals(contraseña));
			System.out.println("\nContraseña correcta, estas dentro del juego");
			
			Random rd = new Random();
			String txt = "\nHace siglos, tres reinos vivían en paz gracias a una reliquia mágica conocida como la Corona de los Tres Reinos.\r\n"
					+ "\r\n"
					+ "Una noche, el hechicero Malakar robó la corona y comenzó a extender la oscuridad por todos los territorios.\r\n"
					+ "\r\n"
					+ "El rey Alaric convoca a tres aventureros para recuperar la reliquia:\r\n"
					+ "- Sir Aldric, un caballero experto en combate.\r\n"
					+ "- Elara, una hechicera que domina la magia.\r\n"
					+ "- Kael, un explorador experto en infiltración y supervivencia.\n";
			for (int i=0; i<txt.length(); i++) {
			try {
				System.out.print(txt.charAt(i));
				Thread.sleep(rd.nextInt(100));
			}catch (Exception e){
		
			}
		}
			String SirAldric;
			
			do {
			System.out.print("\nEscoge un personaje: ");
			SirAldric = sc.nextLine();
			
			if (!"Sir Aldric".equals(SirAldric)) {
				System.out.println("Error, introduzca una opción válida");

//			}else if (!"Elara".equals(personaje)) {
//				System.out.println("Error, introduzca una opción válida");
//
//			}else if (!"Kael".equals(personaje)) {
//			System.out.println("Error, introduzca una opción válida");
			}
			}while (!"Sir Aldric".equals(SirAldric));
			System.out.println("Buena elección");
			
	}
	}

	
