
package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;

public class PagoEfectivo {
private double MontoPagado;
private LocalDate FechadePago;
public double getMontoPagado() {
	return MontoPagado;
}
public void setMontoPagado(double montoPagado) {
	MontoPagado = montoPagado;
}
public LocalDate getFechadePago() {
	return FechadePago;
}
public void setFechadePago(LocalDate fechadePago) {
	FechadePago = fechadePago;
}
	
	

}
