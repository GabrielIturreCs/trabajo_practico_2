package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;

public class PagoTarjeta {
	private String NumeroDeTarjeta;
private LocalDate	FechadePago;


public LocalDate getFechadePago() {
	return FechadePago;
}
public void setFechadePago(LocalDate fechadePago) {
	FechadePago = fechadePago;
}
	
}
