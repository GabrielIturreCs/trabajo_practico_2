package ar.edu.unju.fi.ejercicio3.main;

import ar.edu.unju.fi.ejercicio3.constantes.Provincia;

public class Main {
//IturreSandovalChristianGabriel
	// *******************AGREGO COMENTARIOS PARA FACILITAR LA CORRECCION...*************************
	public static void main(String[] args) {
       Provincia[] provincias = Provincia.values();
       // Se itera sobre el array de provincias
       for(Provincia provincia: provincias) {
           // Se obtienen los datos de cada provincia mediante los métodos getter
    	   String nombreProvincia = provincia.toString(); // 
    	   long poblacion = provincia.getCantidadPoblacion(); // 
    	   double superficie = provincia.getSuperficie(); // 
    	   double densidadPoblacional = provincia.densidad(); // 
    	   
    	   // Se imprimen los datos de cada provincia
    	   System.out.println("LOS DATOS DE LAS PRONVICIAS SON:");
    	   System.out.println("Provincia: " + nombreProvincia);
    	   System.out.println("Población: " + poblacion);
    	   System.out.println("Superficie: " + superficie + " km^2");
    	   System.out.println("Densidad poblacional: " + densidadPoblacional);
    	   System.out.println("********************************");
       }
	}

}