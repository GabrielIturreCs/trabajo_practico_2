package ar.edu.unju.fi.ejercicio5.interfaces;
import java.time.LocalDate;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import ar.edu.unju.fi.ejercicio5.model.PagoEfectivo;

public class Pago {
    public void RealizarPago(double precioUnitario) {
       
 
    	 Scanner scanner2 = new Scanner(System.in);
    	 System.out.println("1-Pago con efectivo");
    	 System.out.println("2-Pago en Tarjeta");


         int Respuesta = scanner2.nextInt();
         if (Respuesta==2) {
        	 Scanner scanner3 = new Scanner(System.in);
        	 System.out.println("Ingrese numero de Tarjeta");
     
             int NumeroDeTarjeta = scanner2.nextInt();
        double montoTotal = precioUnitario + (precioUnitario * 0.15);
        
  //PAGO EN TARJETA
        PagoEfectivo pagoEfectivo = new PagoEfectivo();
        pagoEfectivo.setMontoPagado(montoTotal);
        pagoEfectivo.setFechadePago(LocalDate.now()); 
    	

        imprimirRecibido(pagoEfectivo);
        System.out.println("numero de tarjeta es: "+NumeroDeTarjeta);
         }
         else {
        	 //PAGO EN EFECTIVO
        	 double montoTotal = precioUnitario - (precioUnitario * 0.10);
             
        	 
             PagoEfectivo pagoEfectivo = new PagoEfectivo();
             pagoEfectivo.setMontoPagado(montoTotal);
             pagoEfectivo.setFechadePago(LocalDate.now()); 
         	
             
             imprimirRecibido(pagoEfectivo);

         }
    }
//aqui cree para que se impriman los datos del pago informando fecha y el monto total mas el porcentaje aplicado o el porcentaje restado.
    public void imprimirRecibido(PagoEfectivo pagoEfectivo) {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    	System.out.println("Monto pagado: " + pagoEfectivo.getMontoPagado());
    	 System.out.println("Fecha de pago: " + pagoEfectivo.getFechadePago().format(formatter));
    }
}