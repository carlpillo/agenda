package ui;

import java.util.ArrayList;
import java.util.Scanner;

import com.cursoceat.agenda.Contactos;

public class Menu extends Contactos{

	static ArrayList<Contactos> agenda = new ArrayList<Contactos>();
	
	static	Scanner sc = new Scanner(System.in);

	static public void menu()
	{
		
		int opcion;
		do {
			 
				System.out.println("+----------------+");
			 System.out.println("|    Agenda      |");
			 System.out.println("+----------------+");
			 System.out.println("| 1. Nuevo       |");
			 System.out.println("| 2. Consultar   |");
			 System.out.println("| 3. Modificar   |");
			 System.out.println("| 4. Listar      |");
			 System.out.println("| 5. Salida      |");
			 System.out.println("+----------------+");
			 System.out.println("Ingrese Opcion :");
//			 opcion = new Scanner(System.in).nextInt();
			 opcion = sc.nextInt();

			 switch (opcion) {
				case 1 ->alta();
				case 2 ->buscar();
				case 3 ->modificar();
				case 4 ->mostrar();
				case 5 ->
					{
						System.out.println("Fin De Programa");
						break;
					}
				default -> System.out.println("Error... seleccion incorrecta");
				
				
				}
			 if(opcion == 5)
				 break;
		
		} while (opcion > 0 || opcion < 6);
		
		sc.close();
	}

	static void alta() {
		String nombre;
		String telefono;
		sc.nextLine();
		do {
			System.out.println("Ingrese Nombre :");
//			nombre = new Scanner(System.in).nextLine();
			nombre = sc.nextLine();
		} while (nombre.isEmpty());
		nombre = primeraMayuscula(nombre);
		do {
			System.out.println("Ingrese Telefono :");
//			telefono = new Scanner(System.in).nextLine();
			telefono = sc.nextLine();
		} while (validarTelefono(telefono));
		
		// aqui creamos un objeto y guardar los datos
		// que hemos capturado
		
		Contactos unCtto = new Contactos(nombre,telefono);
		agenda.add(unCtto);
	}
	
	static void buscar() {
		
		String nombre;
		boolean encontrado = false;
		sc.nextLine();
		do {
			System.out.println("Ingrese Nombre :");
			nombre = sc.nextLine();
		} while (nombre.isEmpty());
		nombre = primeraMayuscula(nombre);
		for (Contactos c : agenda) {
			String nombreAgenda = c.getNombre();
			if(nombreAgenda.startsWith(nombre)) {
				System.out.println("\t"+c.getNombre()+"\t("+c.getTelefono()+")");
				encontrado = true;
			}
		}
		if(!encontrado)	
			System.out.println("\t El contacto no existe");
		
	}
	
	static void modificar() {
		
	}

	static void mostrar() {
		for (Contactos c : agenda) {
			System.out.println("\t"+c.getNombre()+"\t("+c.getTelefono()+")");
		}
	}

	// metodo que pasa capitaliza las cadenas
	static String primeraMayuscula(String cadena)
	{
	String [] arrayCadena = cadena.split(" ");
	String temp = "";
	for (int i = 0; i < arrayCadena.length; i++) 
		{
		arrayCadena[i]=arrayCadena[i].substring(0, 1).toUpperCase()+
				arrayCadena[i].substring(1).toLowerCase();
		
		temp +=  arrayCadena[i] +" ";
		}
	return temp;
	}
	
	//metodo que valida el telefono
	static boolean validarTelefono(String telefono)
	{
		boolean correcto = false;
		if (!telefono.startsWith("9") && !telefono.startsWith("6") && !telefono.startsWith("7")
				||telefono.length()!= 9) 
		
			correcto = true;
		
	return correcto;
	}
}
