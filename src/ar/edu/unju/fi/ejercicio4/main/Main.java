package ar.edu.unju.fi.ejercicio4.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;
import ar.edu.unju.fi.ejercicio4.model.Jugador;

public class Main {
	
	//IturreSandovalChristianGabriel
	// ************************************AGREGO COMENTARIOS PARA FACILITAR LA CORRECCION...********************************
   
	
	
	static Scanner scanner = new Scanner(System.in);
	static int opcion;
    
    public static void main(String[] args) {
		// Lista para almacenar jugadores
		ArrayList<Jugador> listaJugadores = new ArrayList<>();
        // Menú principal
        do {
        	opcion = mostrarMenu();
        	switch (opcion) {
			case 1: System.out.println("----- ALTA DE NUEVO JUGADOR -----");
			        limpiarBuffer();
        	        altaJugador(listaJugadores);
				break;
			case 2: 
			        if(listaJugadores.isEmpty()) {
			        	System.out.println("AVISO: NO HAY JUGADORES REGISTRADOS EN EL SISTEMA");
			        }else {
			        	System.out.println("----- LISTA DE JUGADORES REGISTRADOS -----");
			        	mostrarJugadores(listaJugadores);
			        }
				break;
			case 3: 
			        if(listaJugadores.isEmpty()) {
	        	       System.out.println("AVISO: NO HAY JUGADORES REGISTRADOS EN EL SISTEMA");
	                }else {
	                 System.out.println("----- MODIFICAR POSICIÓN DE JUGADOR -----");
	        	     limpiarBuffer();
	        	     System.out.println("Ingrese nombre del jugador: ");
	        	     String nombre = scanner.nextLine();
	        	     System.out.println("Ingrese apellido del jugador: ");
	        	     String apellido = scanner.nextLine();
	        	     modificarPosicion(listaJugadores, nombre, apellido);
	                }
			    break;
			case 4: 
		             if(listaJugadores.isEmpty()) {
	        	       System.out.println("AVISO: NO HAY JUGADORES REGISTRADOS EN EL SISTEMA");
	                  }else {
	                	 System.out.println("----- ELIMINAR JUGADOR -----");
	                	 limpiarBuffer();
	 	        	     System.out.println("Ingrese nombre del jugador: ");
	 	        	     String nombre = scanner.nextLine();
	 	        	     System.out.println("Ingrese apellido del jugador: ");
	 	        	     String apellido = scanner.nextLine();
	 	        	     eliminarJugador(listaJugadores, nombre, apellido);
	                  }	
			break;
			case 5: System.out.println("Finalizando programa...");
				break;
			default:System.out.println("AVISO: OPCIÓN INVÁLIDA, POR FAVOR INTENTE NUEVAMENTE");
				break;
			}
        } while (opcion != 5);
        System.out.println("Programa finalizado");
	}
    
    // Método para mostrar el menú y obtener la opción del usuario
    public static int mostrarMenu() {
    	System.out.println("1. Alta de nuevo jugador");
    	System.out.println("2. Mostrar todos los jugadores registrados");
    	System.out.println("3. Modificar posición de un jugador");
    	System.out.println("4. Eliminar jugador");
    	System.out.println("5. Salir");
    	System.out.print("Elija una opción: ");
    	return opcion = scanner.nextInt();
    }
    
    // Método para agregar un nuevo jugador
    public static void altaJugador(ArrayList<Jugador> jugadores) {
    	System.out.print("Ingrese nombre del jugador: ");
    	String nombre = scanner.nextLine();
    	System.out.print("Ingrese apellido del jugador: ");
    	String apellido = scanner.nextLine();
    	LocalDate fechaNacimiento = validarFecha();
    	System.out.println("Ingrese nacionalidad del jugador: ");
    	String nacionalidad = scanner.nextLine();
    	double peso = validarPeso();
    	double altura = validarAltura();
    	Posicion posicion = Posicion.values()[elegirPosicion()-1];
    	jugadores.add(new Jugador(nombre, apellido, fechaNacimiento, nacionalidad, altura, peso, posicion));
    }
    
    // Método para mostrar todos los jugadores registrados
    public static void mostrarJugadores(ArrayList<Jugador> jugadores) {
    	for(Jugador jugador : jugadores) {
    		jugador.mostrarDatos();
    	}
    }
    
    // Método para modificar la posición de un jugador
    public static void modificarPosicion(ArrayList<Jugador> jugadores, String nombre, String apellido) {
    	Jugador jugadorEncontrado = null;
    	for(Jugador jugador : jugadores) {
    		if(jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
    			jugadorEncontrado = jugador;
    			break;
    		}
    	}
    	if(jugadorEncontrado != null) {
    		jugadorEncontrado.setPosicion(Posicion.values()[elegirPosicion()-1]);
    		System.out.println("AVISO: POSICIÓN MODIFICADA CON ÉXITO");
    	} else {
    		System.out.println("AVISO: EL JUGADOR NO HA SIDO ENCONTRADO");
    	}
    }
    
    // Método para eliminar un jugador
    public static void eliminarJugador(ArrayList<Jugador> jugadores, String nombre, String apellido) {
    	Iterator<Jugador> iterator = jugadores.iterator();
    	boolean encontrado = false;
    	while(iterator.hasNext()) {
    		Jugador jugador = iterator.next();
    		if(jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
    			iterator.remove();
    			encontrado = true;
    			break;
    		}
    	}
    	if(encontrado) {
    		System.out.println("AVISO: JUGADOR ELIMINADO CON ÉXITO");
    	} else {
    		System.out.println("AVISO: EL JUGADOR NO HA SIDO ENCONTRADO");
    	}
    }
    
    // Método para validar la fecha de nacimiento del jugador
    public static LocalDate validarFecha() {
    	LocalDate fechaNacimiento = null;
    	boolean fechaInvalida = false;
    	do {
	    	System.out.println("Ingrese fecha de nacimiento del jugador (dd/MM/yyyy): ");
	    	String fecha = scanner.nextLine();
	    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    	try {
	    		fechaNacimiento = LocalDate.parse(fecha, formatter);
	    		fechaInvalida = true;
	    	} catch (DateTimeParseException error) {
	    		System.err.println("ERROR: EL FORMATO DE FECHA ES INCORRECTO, POR FAVOR INGRESE LA FECHA EN FORMATO dd/MM/yyyy");
	    	}
    	} while (!fechaInvalida);
    	return fechaNacimiento;
    }
    
    // Método para validar el peso del jugador
    public static double validarPeso() {
    	boolean pesoValido = false;
    	double peso = 0;
    	do {
    		System.out.print("Ingrese el peso del jugador (en kg): ");
    		try {
    			peso = scanner.nextDouble();
    			pesoValido = true;
    		} catch (Exception error) {
    			System.out.println("ERROR: INGRESE UN VALOR NUMÉRICO VÁLIDO PARA EL PESO");
    			limpiarBuffer();
    		}
    	} while (!pesoValido);
    	return peso;
    }
    
    // Método para validar la altura del jugador
    public static double validarAltura() {
    	boolean alturaValida = false;
    	double altura = 0;
    	do {
    		System.out.print("Ingrese la altura del jugador (en metros): ");
    		try {
    			altura = scanner.nextDouble();
    			alturaValida = true;
    		} catch (Exception error) {
    			System.out.println("ERROR: INGRESE UN VALOR NUMÉRICO VÁLIDO PARA LA ALTURA");
    			limpiarBuffer();
    		}
    	} while (!alturaValida);
    	return altura;
    }
    
    // Método para elegir la posición del jugador
    public static int elegirPosicion() {
    	int opcion = 0;
    	do {
    		System.out.println("Seleccione la posición del jugador:");
    		System.out.println("1. Delantero");
    		System.out.println("2. Mediocampista");
    		System.out.println("3. Defensor");
    		System.out.println("4. Arquero");
    		System.out.print("Ingrese la opción: ");
    		opcion = scanner.nextInt();
    		if(opcion < 1 || opcion > 4) {
    			System.err.println("ERROR: LA OPCIÓN SELECCIONADA ES INVÁLIDA, POR FAVOR SELECCIONE UNA OPCIÓN DEL 1 AL 4");
    		}
    	} while (opcion < 1 || opcion > 4);
    	return opcion;
    }
    
    // Método para limpiar el buffer del scanner
    public static void limpiarBuffer() {
    	scanner.nextLine();
    }
}