package pw;

import java.util.Scanner;

public class Comprobar {
	private Scanner sc = new Scanner(System.in);
	 public int comprobarNumero() {
	     
	     int opcion = 99;
	     String espacio = "";
	     if (!sc.hasNextInt()) {
	         System.out.println("No has metido un número");
	         sc.nextLine();
	     } else {
	         opcion = sc.nextInt();
	         espacio = sc.nextLine();
	         if (!espacio.equals("")) {
	             System.out.println("Solo mete un número");
	         }
	     }
	     return opcion;


	 }
	 public void parar () {
		 sc.close();
	 }

	}

