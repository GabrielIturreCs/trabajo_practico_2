package ar.edu.unju.fi.ejercicio7.main;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;
import ar.edu.unju.fi.enums.Categoria;
import ar.edu.unju.fi.enums.origenFabricacion;
import ar.edu.unju.fi.model.Producto;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static byte respuesta;

    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();
        cargarProductos(productos);
  
        do {
            respuesta = menu();
            switch (respuesta) {
                case 1:
                    mostrarProductosDisponibles(productos);
                    break;
                case 2:
                    System.out.println("REALIZACION DE PAGO");
                    limpiarBuffer();
                    realizarCompra(productos);
                    break;
                case 3:
                    mostrarProductosFaltantes(productos);
                    break;
                case 4:
                    productos = incrementarPrecios(productos);
                    break;
                case 5:
                	   mostrarProductosElectrohogarDisponibles(productos);
                    break;
                case 6:
                	 ordenarProductosPorPrecioDescendente(productos);
                    break;
                case 7:
                    mostrarProductosEnMayusculas(productos);
                    break;
                case 8:
               System.out.println("Saliendo Del Programa");
                    break;
                default:
                    System.out.println("OPCION INVALIDA");
                    break;
            }
        } while (respuesta != 8);
        System.out.println("Programa finalizado");
    }

    public static void cargarProductos(ArrayList<Producto> productos) {
        System.out.println("*********** PRODUCTOS ***********");
        productos.add(new Producto("001", "Teléfono móvil Samsung Galaxy S21", 100.0, Categoria.TELEFONIA, origenFabricacion.ARGENTINA));
        productos.add(new Producto("002", "Laptop HP Pavilion", 150.0, Categoria.INFORMATICA, origenFabricacion.CHINA));
        productos.add(new Producto("003", "Aspiradora Philips PowerPro Compact", 80.0, Categoria.ELECTROHOGAR, origenFabricacion.BRASIL));
        productos.add(new Producto("004", "Juego de destornilladores Stanley", 200.0, Categoria.HERRAMIENTAS, origenFabricacion.URUGUAY));
        productos.add(new Producto("005", "Licuadora Oster", 120.0, Categoria.ELECTROHOGAR, origenFabricacion.ARGENTINA));
        productos.add(new Producto("006", "Monitor LG UltraGear", 90.0, Categoria.INFORMATICA, origenFabricacion.CHINA));
        productos.add(new Producto("007", "Smart TV Sony Bravia", 180.0, Categoria.TELEFONIA, origenFabricacion.BRASIL));
        productos.add(new Producto("008", "Set de llaves Allen Stanley", 220.0, Categoria.HERRAMIENTAS, origenFabricacion.URUGUAY));
        productos.add(new Producto("009", "Tablet Lenovo Tab M10", 130.0, Categoria.INFORMATICA, origenFabricacion.ARGENTINA));
        productos.add(new Producto("010", "Teléfono móvil Xiaomi Redmi Note 10", 70.0, Categoria.TELEFONIA, origenFabricacion.CHINA));
        productos.add(new Producto("011", "Cafetera Philips Senseo", 240.0, Categoria.ELECTROHOGAR, origenFabricacion.BRASIL));
        productos.add(new Producto("012", "Caja de herramientas Bosch", 110.0, Categoria.HERRAMIENTAS, origenFabricacion.URUGUAY));
        productos.add(new Producto("013", "Mouse inalámbrico Logitech", 160.0, Categoria.INFORMATICA, origenFabricacion.ARGENTINA));
        productos.add(new Producto("014", "Smartwatch Huawei Watch GT", 190.0, Categoria.TELEFONIA, origenFabricacion.CHINA));
        productos.add(new Producto("015", "Cafetera Dolce Gusto", 250.0, Categoria.ELECTROHOGAR, origenFabricacion.BRASIL));
    }

    public static byte menu() {
        try {
            System.out.println("1 Mostrar productos disponibles");
            System.out.println("2 Realizar compra");
      
            System.out.println("3 Mostrar productos faltantes");
            System.out.println("4 Incrementar los precios de los productos en un 20%");
            System.out.println("5 Mostrar productos Electrohogar disponibles");
            System.out.println("6 Ordenar productos por precio de forma descendente");
            System.out.println("7 Mostrar productos en mayúsculas");
            System.out.println("8 Salir");
            System.out.print("Elija una opcion: ");
            respuesta = sc.nextByte();
        } catch (Exception e) {
            System.err.println("Solo números en la opción");
            sc.nextLine();
        }
        return respuesta;
    }

    public static void mostrarProductosDisponibles(ArrayList<Producto> productos) {
        System.out.println("*********** PRODUCTOS DISPONIBLES ***********");
        for (Producto producto : productos) {
            if (producto.getStock()) {
                producto.mostrarDatos();
                System.out.println("---------------------------------");
            }
        }
    }

    public static void limpiarBuffer() {
        sc.nextLine();
    }

    public static void realizarCompra(ArrayList<Producto> productos) {
        ArrayList<Producto> carrito = new ArrayList<>();
        LocalDate hoy = LocalDate.now();
        double total = 0.0;
        boolean band = true;
        Pago pago = new Pago(); // Crear una instancia de la clase Pago
        while (band) {
            try {
                System.out.println("Ingrese código del producto: ");
                String codigo = sc.next().toLowerCase(); // Convertir a minúsculas
                boolean encontrado = false;
                for (Producto producto : productos) {
                    if (producto.getCodigo().equals(codigo)) {
                        encontrado = true;
                        if (producto.getStock()) {
                            carrito.add(producto);
                            total += producto.getPrecioUnitario();
                            producto.setStock(false);
                            System.out.println("Producto añadido al carrito.");
                        } else {
                            System.out.println("Producto sin stock.");
                        }
                        break;
                    }
                }
                if (!encontrado) {
                    System.out.println("Producto no encontrado.");
                }
                System.out.println("¿Agregar otro producto? 1.Sí/2.No");
                byte respuesta = sc.nextByte();
                if (respuesta == 2) {
                    band = false;
                }
            } catch (Exception e) {
                System.err.println("Ingrese solo números");
                sc.nextLine();
            }
        }
      
        System.out.println("Total: " + total);
        pago.RealizarPago(total); // Llamar al método RealizarPago() en la instancia de Pago
    }

    public static void mostrarProductosFaltantes(ArrayList<Producto> productos) {
        System.out.println("*********** PRODUCTOS FALTANTES ***********");
        for (Producto producto : productos) {
            if (!producto.getStock()) {
                try {
					producto.mostrarDatos();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                System.out.println("---------------------------------");
            }
        }
    }

    public static ArrayList<Producto> incrementarPrecios(ArrayList<Producto> productos) {
        System.out.println("Incrementando precios en un 20%...");
        return productos.stream()
                       .map(p -> {
                           p.setPrecioUnitario(p.getPrecioUnitario() * 1.20);
                           return p;
                       })
                       .collect(Collectors.toCollection(ArrayList::new));
    }

    public static void mostrarProductosElectrohogarDisponibles(ArrayList<Producto> productos) {
        System.out.println("*********** PRODUCTOS ELECTROHOGAR DISPONIBLES ***********");
        for (Producto producto : productos) {
            if (producto.getCategorias() == Categoria.ELECTROHOGAR && producto.getStock()) {
                producto.mostrarDatos();
                System.out.println("---------------------------------");
            }
        }
    }

    public static void ordenarProductosPorPrecioDescendente(ArrayList<Producto> productos) {
        System.out.println("*********** PRODUCTOS ORDENADOS POR PRECIO DESCENDENTE ***********");
        List<Producto> productosOrdenados = productos.stream()
                                                     .sorted(Comparator.comparing(Producto::getPrecioUnitario).reversed())
                                                     .collect(Collectors.toList());
        for (Producto producto : productosOrdenados) {
            producto.mostrarDatos();
            System.out.println("---------------------------------");
        }
    }

    public static void mostrarProductosEnMayusculas(ArrayList<Producto> productos) {
        System.out.println("*********** PRODUCTOS EN MAYÚSCULAS ***********");
        for (Producto producto : productos) {
            System.out.println("Código: " + producto.getCodigo());
            System.out.println("Descripción: " + producto.getDescripcion().toUpperCase());
            System.out.println("Precio Unitario: " + producto.getPrecioUnitario());
            System.out.println("Categoría: " + producto.getCategorias());
            System.out.println("Origen de fabricación: " + producto.getOrigen());
            System.out.println("---------------------------------");
        }
    }
}
