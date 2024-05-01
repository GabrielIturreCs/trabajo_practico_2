package ar.edu.unju.fi.ejercicio2.model;

import ar.edu.unju.fi.ejercicio2.constantes.Mes;

public class Efemeride {
    String codigo;
    Mes mes;
    String dia;
    String detalle;
    public Efemeride() {
		
	}
	public Efemeride(String codigo, Mes mes, String dia, String detalle) {
		this.codigo = codigo;
		this.mes = mes;
		this.dia = dia;
		this.detalle = detalle;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Mes getMes() {
		return mes;
	}
	public void setMes(Mes mes) {
		this.mes = mes;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
    public void mostrarDatos() {
    	System.out.println("-------------------------");
    	System.out.println("Codigo es : " + codigo);
    	System.out.println("Mes es : " + mes);
    	System.out.println("Dia es : " + this.dia);
    	System.out.println("Detalle es : " + detalle);
    	System.out.println("-----------------------------");
    }
}