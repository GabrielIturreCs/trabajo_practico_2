package ar.edu.unju.fi.ejercicio2.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio2.constantes.Mes;
import ar.edu.unju.fi.ejercicio2.model.Efemeride;



public class Main {
	// alumno Iturre Sandoval Christian Gabriel
    static Scanner sc = new Scanner(System.in);
    static int OpcionElegida;
	public static void main(String[] args) {
		ArrayList<Efemeride> efemerideslista = new ArrayList();
		do {
			OpcionElegida=menu();
			switch (OpcionElegida) {
			case 1:
				   limpiarBuffer();
				   crearEfemeride(efemerideslista);
				break;
			case 2:
				     if(efemerideslista.isEmpty()) {
				    	 System.out.println("error esta vacio no se cargo");
				    	 Espacio();
				     }else {
				    	 limpiarBuffer();
				    	 mostrarEfemerides(efemerideslista);
				     }
				break;
			case 3: 
				    if(efemerideslista.isEmpty()) {
				    	System.out.println("Se encuentra vacio");
				    	Espacio();
				    }else {
				    limpiarBuffer();
				    System.out.print("Ingrese codigo: ");
				    String codigomostrar = sc.nextLine();
				    eliminarEfemeride(efemerideslista, codigomostrar);
				    }
				break;
			case 4: 
				     if(efemerideslista.isEmpty()) {
				    	 System.out.println("Se encuentra vacio");
				    	 Espacio();
				     }else {
				    	 limpiarBuffer();
				    	 System.out.println("Ingrese codigo: ");
				    	 String codigomostrar = sc.nextLine();
				    	 modificarEfemeride(efemerideslista, codigomostrar);
				     }
				break;
			case 5: System.out.println("Finalizando programa...");
				break;
			default: System.out.println("Opcion equivocada");
				break;
			}
		}while(OpcionElegida!=5);
		System.out.println("Programa finalizado");

	}
	public static int menu() {
		System.out.println("1 Crear efemeride");
		System.out.println("2 Mostrar efemerides");
		System.out.println("3 Eliminar efemeride");
		System.out.println("4 Modificar efemeride");
		System.out.println("5 Salir");
		System.out.print("Elija una opcion: ");
		return OpcionElegida=sc.nextInt();
	}
	public static void crearEfemeride(ArrayList<Efemeride> efemerides) {
		System.out.print("Ingrese codigo: ");
		String codigo = sc.nextLine();
		int NumeroMes = validarMes();
		Mes mes = Mes.values()[NumeroMes-1];
		limpiarBuffer();
		System.out.print("Ingrese dia: ");
		String dia = sc.nextLine();
		System.out.print("Ingrese descripcion: ");
	    String descripcion = sc.nextLine();
	    efemerides.add(new Efemeride(codigo, mes, dia, descripcion));
	    System.out.println("creacion existosa");
	}
	public static void limpiarBuffer() {
		sc.nextLine();
	}
    public static int validarMes(){
        int mes=0;
        do {
    	System.out.print("Ingrese mes 1 al 12: ");
        mes=sc.nextInt();
        }while(mes < 1 || mes > 12);
        return mes;
    }
    public static void mostrarEfemerides(ArrayList<Efemeride> efemerides) {
    	for(Efemeride mostrar:efemerides) {
    		mostrar.mostrarDatos();
    	}
    }
    public static void eliminarEfemeride(ArrayList<Efemeride> efemerides, String codigo) {
        Iterator iterador = efemerides.iterator();
    	boolean band=false;
        while(iterador.hasNext()) {
           Efemeride elimino = (Efemeride)iterador.next();
           if(elimino.getCodigo().equalsIgnoreCase(codigo)==true) {
   			iterador.remove();
   			band=true;
   		}
        }
    		
        if(band==true) {
        	System.out.println("Eliminada efemeridad correctamente");
        }else {
        	System.out.println("No existe");
        }
    }
    public static void Espacio() {
    	System.out.println("");
    }
    public static void modificarEfemeride(ArrayList<Efemeride> efemerides, String codigo) {
    	boolean band=false;
    	int nuevoMes=0;
    	Efemeride encontrado = new Efemeride(); 
    	for(Efemeride modifico: efemerides) {
    		if(modifico.getCodigo().equalsIgnoreCase(codigo)==true) {
    			band = true;
    			encontrado = modifico;
    		}
    	}
    	if(band==true) {
    		do {
    			OpcionElegida=menuModificar();
    			switch (OpcionElegida) {
				case 1:
					limpiarBuffer();
					nuevoMes=validarMes();
					encontrado.setMes(Mes.values()[nuevoMes-1]);
					System.out.println("Mes cambiado con facilidad");
					Espacio();
					break;
				case 2:
					limpiarBuffer();
					System.out.print("Ingrese nuevo dia");
					encontrado.setDia(sc.nextLine());
					System.out.println("Dia cambiado");
					Espacio();
					break;
				case 3: 
					limpiarBuffer();
					System.out.println("Ingrese nuevo detalle: ");
					encontrado.setDetalle(sc.nextLine());
					System.out.println("Se cambio con exito");
					Espacio();
					break;
				case 4:
					System.out.println("***Hasta la proxima***");
					Espacio();
					break;
				default: System.out.println("Opcion invalida");
					break;
				}
    		}while(OpcionElegida>=4);
    	}else {
    		System.out.println("No existe");
    	}
    }
    public static int menuModificar() {
    		System.out.println("1 Modificar mes");
    		System.out.println("2 Modificar dia");
    		System.out.println("3 Modificar detalle");
    		System.out.println("4 Salir"); 
    		System.out.print("Elija opcion: ");
    	OpcionElegida = sc.nextInt();
    	return OpcionElegida;
    }
   
}
