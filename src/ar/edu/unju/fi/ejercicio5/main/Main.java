package ar.edu.unju.fi.ejercicio5.main;
import ar.edu.unju.fi.ejercicio5.interfaces.*;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import ar.edu.unju.fi.enums.Categoria;
import ar.edu.unju.fi.enums.origenFabricacion;
import ar.edu.unju.fi.model.Producto;

public class Main {
	public static void main(String[] args) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		ArrayList<Producto> listaProductos = new ArrayList<>();
	    Scanner scanner = new Scanner(System.in);
	    int RespuestaMenu;

	    Pago pago = new Pago(); // Cree una instancia de la clase Pago
	    System.out.println("****PRIMERO DEBE MOSTRAR LOS PRODUCTOS PARA PODER COMPRAR  DE LO CONTRARIO NO SABRA EL CODIGO DEL PRODUCTO**************************");
	    do {
	    	
	    	
	
	        mostrarMenu();
	        RespuestaMenu = scanner.nextInt();
//en el primer caso sirve para mostrar los productos disponibles
	        switch (RespuestaMenu) {
	            case 1:
	                mostrarProductos(listaProductos);
	                break;
	                //en el caso 2 armo la logica para comprar el if funciona  si en caso que lo encontra y sino niego el if ! con esto informo que el producto ya fue comprado.
	            case 2:
	                Scanner scanner2 = new Scanner(System.in);
	                System.out.println("Ingrese código del producto:");
	                String codigoRecibido = scanner2.next();
	                boolean productoEncontrado = false;
	                for (Producto producto : listaProductos) {
	                    if (producto.getCodigo().equals(codigoRecibido)) {
	                        productoEncontrado = true;
	                        double precioUnitario = producto.getPrecioUnitario();
	                        pago.RealizarPago(precioUnitario); // Llamar al método RealizarPago a través de la instancia pago
	                        listaProductos.remove(producto); // Eliminar el producto de la lista
	                        System.out.println("Producto comprado y eliminado de la lista.");
	                        break; 
	                    }
	                }
	                if (!productoEncontrado) {
	                    System.out.println("Producto no encontrado o posiblemente vendido. Verifique el código.");
	                }
	              
	                break;
	            case 3: System.out.println("Saliendo del programa.'Hasta pronto!!");
	            break;
	            default:
	                System.out.println("Opción no válida. Intente de nuevo.");
	        }
	    } while (RespuestaMenu != 3);
	}
//aqui cree mi menu
    public static void mostrarMenu() {
        System.out.println("*********** MENÚ ***********");
        System.out.println("1. Mostrar Productos");
        System.out.println("2. Realizar compra");
        System.out.println("3. Salir");
        System.out.println("****************************");
        System.out.print("Ingrese su opción: ");
    }
//son mis productos
    public static void mostrarProductos(ArrayList<Producto> listaProductos) {
        System.out.println("*********** PRODUCTOS ***********");
        listaProductos.add(new Producto("001", "Teléfono móvil Samsung Galaxy S21", 100.0, Categoria.TELEFONIA, origenFabricacion.ARGENTINA));
        listaProductos.add(new Producto("002", "Laptop HP Pavilion", 150.0, Categoria.INFORMATICA, origenFabricacion.CHINA));
        listaProductos.add(new Producto("003", "Aspiradora Philips PowerPro Compact", 80.0, Categoria.ELECTROHOGAR, origenFabricacion.BRASIL));
        listaProductos.add(new Producto("004", "Juego de destornilladores Stanley", 200.0, Categoria.HERRAMIENTAS, origenFabricacion.URUGUAY));
        listaProductos.add(new Producto("005", "Licuadora Oster", 120.0, Categoria.ELECTROHOGAR, origenFabricacion.ARGENTINA));
        listaProductos.add(new Producto("006", "Monitor LG UltraGear", 90.0, Categoria.INFORMATICA, origenFabricacion.CHINA));
        listaProductos.add(new Producto("007", "Smart TV Sony Bravia", 180.0, Categoria.TELEFONIA, origenFabricacion.BRASIL));
        listaProductos.add(new Producto("008", "Set de llaves Allen Stanley", 220.0, Categoria.HERRAMIENTAS, origenFabricacion.URUGUAY));
        listaProductos.add(new Producto("009", "Tablet Lenovo Tab M10", 130.0, Categoria.INFORMATICA, origenFabricacion.ARGENTINA));
        listaProductos.add(new Producto("010", "Teléfono móvil Xiaomi Redmi Note 10", 70.0, Categoria.TELEFONIA, origenFabricacion.CHINA));
        listaProductos.add(new Producto("011", "Cafetera Philips Senseo", 240.0, Categoria.ELECTROHOGAR, origenFabricacion.BRASIL));
        listaProductos.add(new Producto("012", "Caja de herramientas Bosch", 110.0, Categoria.HERRAMIENTAS, origenFabricacion.URUGUAY));
        listaProductos.add(new Producto("013", "Mouse inalámbrico Logitech", 160.0, Categoria.INFORMATICA, origenFabricacion.ARGENTINA));
        listaProductos.add(new Producto("014", "Smartwatch Huawei Watch GT", 190.0, Categoria.TELEFONIA, origenFabricacion.CHINA));
        listaProductos.add(new Producto("015", "Cafetera Dolce Gusto", 250.0, Categoria.ELECTROHOGAR, origenFabricacion.BRASIL));
        for (Producto producto : listaProductos) {
          
            producto.mostrarDatos();
            System.out.println("---------------------------------");
        }
    }
}
