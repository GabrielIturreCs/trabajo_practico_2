package ar.edu.unju.fi.ejercicio4.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;

public class Jugador {
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String nacionalidad;
    private double estatura;
    private double peso;
    private Posicion posicion;
    
    // Constructores
    public Jugador() {
		// Constructor vacío
	}

	public Jugador(String nombre, String apellido, LocalDate fechaNacimiento, String nacionalidad, double estatura,
			double peso, Posicion posicion) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.estatura = estatura;
		this.peso = peso;
		this.posicion = posicion;
	}

	// Getters y Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public double getEstatura() {
		return estatura;
	}

	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	// Método para calcular la edad del jugador
	public int calcularEdad() {
		LocalDate hoy = LocalDate.now();
		int edad = Period.between(fechaNacimiento, hoy).getYears();
		return edad;
	}
    
    // Método para mostrar los datos del jugador
    public void mostrarDatos() {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    	System.out.println("Nombre: " + nombre);
    	System.out.println("Apellido: " + apellido);
    	System.out.println("Fecha de nacimiento: " + formatter.format(fechaNacimiento));
    	System.out.println("Nacionalidad: " + nacionalidad);
    	System.out.println("Estatura: " + estatura);
    	System.out.println("Peso: " + peso);
    	System.out.println("Posición: " + posicion);
    	System.out.println("Edad: " + calcularEdad());
    	System.out.println("***********************************");
    }
}