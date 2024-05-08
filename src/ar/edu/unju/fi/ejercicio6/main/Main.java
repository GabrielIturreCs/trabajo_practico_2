package ar.edu.unju.fi.ejercicio6.main;

import ar.edu.unju.fi.ejercicio6.interfaces.funcionales.Converter;
import ar.edu.unju.fi.ejercicio6.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio6.model.FelinoSalvaje;

public class Main {
//Realizado por iturreSandovalChristianGabriel
	
	
	public static void main(String[] args) {
		FelinoSalvaje gato = new FelinoSalvaje("Tanner", (byte)20, 186f);
		Converter<FelinoSalvaje,FelinoDomestico> converter = x -> new FelinoDomestico(x.getNombre(),x.getEdad(),x.getPeso());
		//domesticar
		if(Converter.isNotNull(gato)) {
		
			FelinoDomestico domesticar = converter.convert(gato);
			converter.mostrarObjeto(domesticar);
		}else {
			System.out.println("Objeto nulo o no valido");
		}
	}

	
	
}
