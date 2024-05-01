package ar.edu.unju.fi.main;

import java.util.ArrayList;
import java.util.Scanner;

import ar.edu.unju.fi.enums.Categoria;
import ar.edu.unju.fi.enums.origenFabricacion;
import ar.edu.unju.fi.model.Producto;

public class Main {
    // ***********Agrego comentarios para la facilitacion de la correccion**********
    static Scanner sc = new Scanner(System.in);
    // Se declara una variable para almacenar la opción elegida por el usuario
    static int opcionElegida;


    public static void main(String[] args) {
        // Se inicializa un ArrayList para almacenar productos
        ArrayList<Producto> productos = new ArrayList();
  
        int menu = 0;

        do {
            // Se obtiene la opción elegida por el usuario
            menu = menu();
      
            switch (menu) {
            
                case 1: 
                    System.out.println("Crear un Producto");
                    // Se limpia el buffer del scanner para evitar errores de entrada
                    limpiarBuffer();
                    // Se llama a la función para cargar un producto
                    cargarProducto(productos);
                    break;
                // Caso 2: Mostrar productos
                case 2:
                    // Si no hay productos en la lista, se muestra un mensaje de error
                    if(productos.isEmpty()) {
                        System.out.println("Error: Lista vacía. Por favor, cargue un producto antes de consultar.");
                    } else {
                        // Se muestra la lista de productos
                        System.out.println("La lista de productos es:");
                        listarProductos(productos);
                    }
                    break;
                // Caso 3: Modificar un producto
                case 3: 
                    // Si no hay productos en la lista, se muestra un mensaje
                    if(productos.isEmpty()) {
                        System.out.println("La lista se encuentra vacía.");
                    } else {
                        // Se limpia el buffer del scanner y se solicita al usuario que ingrese el código del producto a modificar
                        limpiarBuffer();
                        System.out.print("Ingrese código del producto: ");
                        String codigoBuscar = sc.nextLine();
                        // Se llama a la función para modificar el producto
                        modificarProducto(productos, codigoBuscar);
                    }
                    break;
                // Caso 4: Salir del programa
                case 4: 
                    System.out.println("Saliendo del programa...");
                    break;
                // Opción predeterminada: Mensaje de opción inválida
                default: 
                    System.out.println("Opción inválida");
                    break;
            } 
        } while(menu != 4); // El bucle se ejecuta mientras la opción elegida no sea 4
        // Mensaje de finalización del programa
        System.out.println("Programa finalizado");
    }

    // Método para mostrar el menú y obtener la opción elegida por el usuario
    public static int menu() {
        System.out.println("1. Crear producto");
        System.out.println("2. Mostrar producto");
        System.out.println("3. Modificar producto");
        System.out.println("4. Salir");
        System.out.print("Elija opción: ");
        // Se lee la opción elegida por el usuario y se devuelve
        return opcionElegida = sc.nextInt();
    }

    // Método para cargar un producto en la lista
    public static void cargarProducto(ArrayList<Producto> productos) {
        System.out.print("Ingrese código: ");
        String codigo = sc.nextLine();
        System.out.print("Ingrese descripción: ");
        String descripcion = sc.nextLine();
        double precioUnitario = ValidacionPrecio();
        limpiarBuffer();
        Categoria categoria = asignarCategoria();
        origenFabricacion origen = asignarOrigen();
        // Se crea un nuevo producto y se agrega a la lista
        productos.add(new Producto(codigo, descripcion, precioUnitario, categoria, origen)); 
        System.out.println("se creo exitosamente\n");
        
    }

    // Método para mostrar las opciones de categoría y obtener la elegida por el usuario
    public static int menuCategoria() {
        System.out.println("------Categoría------");
        System.out.println("1. Telefonía");
        System.out.println("2. Informática");
        System.out.println("3. Electrohogar");
        System.out.println("4. Herramienta");
        System.out.print("Elija opción: ");
        // Se lee la opción elegida por el usuario y se devuelve
        return opcionElegida = sc.nextInt();
    }

    // Método para mostrar las opciones de origen y obtener la elegida por el usuario
    public static int menuOrigen() {
        System.out.println("------Origen de fabricación------");
        System.out.println("1. Argentina");
        System.out.println("2. China");
        System.out.println("3. Brasil");
        System.out.println("4. Uruguay");
        System.out.print("Elija opción: ");
        // Se lee la opción elegida por el usuario y se devuelve
        return opcionElegida = sc.nextInt();
    }

    // Método para asignar la categoría del producto
    public static Categoria asignarCategoria() {
        Categoria categoria = null;
        // Se muestra el menú de categorías y se obtiene la opción elegida por el usuario
        opcionElegida = menuCategoria();
        switch (opcionElegida) {
            case 1:
                categoria = Categoria.TELEFONIA;
                break;
            case 2: 
                categoria = Categoria.INFORMATICA;
                break;
            case 3:
                categoria = Categoria.ELECTROHOGAR;
                break;
            case 4:
                categoria = Categoria.HERRAMIENTAS;
                break;
            default: 
                System.out.println("***OPCIÓN INVÁLIDA***");
                break;
        }
        return categoria;
    }

    // Método para asignar el origen de fabricación del producto
    public static origenFabricacion asignarOrigen() {
        origenFabricacion origen = null;
        // Se muestra el menú de origen y se obtiene la opción elegida por el usuario
        opcionElegida = menuOrigen();
        switch (opcionElegida) {
            case 1:
                origen = origenFabricacion.ARGENTINA;
                break;
            case 2:
                origen = origenFabricacion.CHINA;
                break;
            case 3:
                origen = origenFabricacion.BRASIL;
                break;
            case 4:
                origen = origenFabricacion.URUGUAY;
                break;
            default:
                break;
        }
        return origen;
    }

    // Método para mostrar los productos almacenados en la lista
    public static void listarProductos(ArrayList<Producto> productos) {
        for(Producto p: productos) {
            System.out.println(" ");
            System.out.println("********************"); 
            p.mostrarDatos();
            System.out.println("********************");
            System.out.println(" ");
        }
    }

    // Método para limpiar el buffer del scanner
    public static void limpiarBuffer() {
        sc.nextLine();
    }

    // Método para validar el precio ingresado por el usuario
    public static double ValidacionPrecio() {
        String ingreso = "";
        Double precio = 0.0;
        while(true) {
            System.out.println("Ingrese precio unitario: ");
            ingreso = sc.nextLine();
            // Si el precio contiene una coma, se muestra un mensaje de error
            if(ingreso.contains(",")) {
                System.err.println("Ingrese \".\" para separar decimales");
                continue;
            }
            try {
                // Se convierte el precio ingresado a tipo Double y se devuelve
                precio = Double.parseDouble(ingreso);
                return precio;
            } catch (Exception error) {
                System.err.println("Formato incorrecto");
            }
        }
    }

    // Método para modificar un producto existente en la lista
    public static void modificarProducto(ArrayList<Producto> productos, String codigo) {
        boolean band = false;   
        Producto encontrado = new Producto(codigo, codigo, null, null, null);
        for(Producto producto: productos) {
            if(producto.getCodigo().equalsIgnoreCase(codigo)) {
                band = true;
                encontrado = producto;
            }
        }
        if(band) {
            System.out.println("***PRODUCTO ENCONTRADO***");
            do {
                // Se muestra el menú de opciones para modificar el producto
                opcionElegida = menuModificar();
                switch (opcionElegida) {
                    case 1:
                        limpiarBuffer();
                        System.out.println("Ingrese nueva descripción: ");
                        encontrado.setDescripcion(sc.nextLine());
                        System.out.println("descripcion cambiada\n");
                        break;
                    case 2:
                        limpiarBuffer();
                        encontrado.setPrecioUnitario(ValidacionPrecio());
                        System.out.println("precio cambiado\n");
                        break;
                    case 3:
                        limpiarBuffer();
                        encontrado.setCategorias(asignarCategoria());
                        System.out.println("categoria cambiada\n");
                        break;
                    case 4:
                        limpiarBuffer();
                        encontrado.setOrigen(asignarOrigen());
                        System.out.println("origen cambiado\n");
                        break;
                    case 5: 
                        System.out.println("Hasta la próxima");
                        break;
                    default:
                        System.out.println("error");
                        break;
                }
            } while(opcionElegida >= 5);
        } else {
            System.out.println("Error:codigo no existe");
        }
    }

    // Método para mostrar el menú de opciones para modificar un producto
    public static int menuModificar() {
        System.out.println("1. Modificar descripción");
        System.out.println("2. Modificar precio unitario");
        System.out.println("3. Modificar categoría");
        System.out.println("4. Modificar origen");
        System.out.println("5. Salir");
        System.out.print("Elija una opción: ");
        // Se lee la opción elegida por el usuario y se devuelve
        opcionElegida = sc.nextInt();
        return opcionElegida;
    }
}