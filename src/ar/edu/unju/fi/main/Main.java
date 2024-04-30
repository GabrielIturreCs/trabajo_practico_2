package ar.edu.unju.fi.main;

import java.util.ArrayList;
import java.util.Scanner;

import ar.edu.unju.fi.enums.Categoria;
import ar.edu.unju.fi.enums.origenFabricacion;
import ar.edu.unju.fi.model.Producto;

public class Main {
    static Scanner sc = new Scanner(System.in);
	static int op;
    public static void main(String[] args) {
		ArrayList<Producto> productos = new ArrayList();
		int menu=0;
		do {
			menu=menu();
        switch (menu) {
		case 1: System.out.println("Crear un Producto");
		        limpiarBuffer();
			    cargarProducto(productos);
			break;
		case 2:
			   if(productos.isEmpty()) {
				   System.out.println("Error Lista vacia porfavor cargue un producto antes de consultar");
			   }else {
				   System.out.println("La lista de productos es");
				   listarProductos(productos);
			   }
			break;
		case 3: if(productos.isEmpty()) {
			System.out.println("La lista se encuentra vacia ");
		}else {
			limpiarBuffer();
			System.out.print("Ingrese codigo del producto: ");
			String codigoBuscar=sc.nextLine();
			modificarProducto(productos, codigoBuscar);
		}
			break;
		case 4: System.out.println("Salien del programa...");
			break;
		default: System.out.println("Opcion Invalida");
			break;
		} 
		}while(menu != 4);
		System.out.println("Programa finalizado");
	}
    public static int menu() {
    	System.out.println("1 Crear producto");
        System.out.println("2 Mostrar producto");
        System.out.println("3 Modificar producto");
        System.out.println("4 Salir");
        System.out.print("Elija opcion: ");
        return op=sc.nextInt();
    }
    public static void cargarProducto(ArrayList<Producto> productos) {
    	System.out.print("Ingrese codigo: ");
    	String codigo = sc.nextLine();
    	System.out.print("Ingrese descripcion: ");
    	String descripcion = sc.nextLine();
    	double precioUnitario = ValidacionPrecio();
    	limpiarBuffer();
    	Categoria categoria = asignarCategoria();
    	origenFabricacion origen = asignarOrigen();
        productos.add(new Producto(codigo, descripcion, precioUnitario, categoria, origen)); 
        System.out.println("***CREACION EXITOSA***");
        System.out.println("");
    }
    public static int menuCategoria() {
    	System.out.println("------Categoria------");
        System.out.println("1 Telefonia");
        System.out.println("2 Informatica");
        System.out.println("3 ElectroHogar");
        System.out.println("4 Herramienta");
        System.out.print("Elija opcion: ");
        return op=sc.nextInt();
    }
    public static int menuOrigen() {
    
    	System.out.println("------Origen de fabricacion------");
        System.out.println("1 Argentina");
        System.out.println("2 China");
        System.out.println("3 Brasil");
        System.out.println("4 Uruguay");
        System.out.print("Elija opcion: ");
        return op=sc.nextInt();
    }
    public static Categoria asignarCategoria() {
    	Categoria c = null;
        	op=menuCategoria();
    	switch (op) {
		case 1:
			c = Categoria.TELEFONIA;
			break;
		case 2: 
			c = Categoria.INFORMATICA;
			break;
		case 3:
			c = Categoria.ELECTROHOGAR;
			break;
		case 4:
			c = Categoria.HERRAMIENTAS;
			break;
		default: System.out.println("***OPCION INVALIDA***");
			break;
		}
    	return c;
    }
    public static origenFabricacion asignarOrigen() {
    	origenFabricacion origen=null;
        	op = menuOrigen();
        	switch (op) {
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
    public static void listarProductos(ArrayList<Producto> productos) {
    	for(Producto p: productos) {
    		System.out.println(" ");
            System.out.println("********************"); 
    		p.mostrarDatos();
    		System.out.println("********************");
    		System.out.println(" ");
    	}
    }
    public static void limpiarBuffer() {
    	sc.nextLine();
    }
    public static double ValidacionPrecio() {
    	String ingreso="";
    	Double precio=0.0;
    	while(true) {
    		System.out.println("Ingrese precio unitario: ");
        	ingreso=sc.nextLine();
        	if(ingreso.contains(",")) {
        		System.err.println("Ingrese \".\" para separar decimales");
        		continue;
        	}
    	try {
    	 precio = Double.parseDouble(ingreso);
         return precio;
    	}catch (Exception e) {
			System.err.println("Formato incorrecto");
		}
    	}

    }
    public static void modificarProducto(ArrayList<Producto> productos, String codigo) {
    	boolean band=false;	
    	Producto encontrado = new Producto(codigo, codigo, null, null, null);
    	for(Producto p: productos) {
    		if(p.getCodigo().equalsIgnoreCase(codigo)==true) {
    			band=true;
    			encontrado=p;
    		}
    		}
    	if(band == true) {
    		
    		System.out.println("***PRODUCTO ENCONTRADO***");
    		do {
    			op=menuModificar();
    			switch (op) {
				case 1:
					limpiarBuffer();
					System.out.println("Ingrese nueva descripcion: ");
					encontrado.setDescripcion(sc.nextLine());
					System.out.println("***DESCRIPCION CAMBIADA***");
					System.out.println("");
					break;
				case 2:
					limpiarBuffer();
					encontrado.setPrecioUnitario(ValidacionPrecio());
					System.out.println("***PRECIO CAMBIADO***");
					System.out.println("");
					break;
				case 3:
					limpiarBuffer();
					encontrado.setCategorias(asignarCategoria());
					System.out.println("***CATEGORIA CAMBIADA***");
					System.out.println("");
					break;
				case 4:
					limpiarBuffer();
					encontrado.setOrigen(asignarOrigen());
					System.out.println("***ORIGEN CAMBIADO***");
					System.out.println("");
					break;
				case 5: System.out.println("Hasta la proxima");
				break;
				default:System.out.println("***ERROR OPCION INVALIDA***");
					break;
				}
    		}while(op>=5);
    	}else {
    		System.out.println("***ERROR CODIGO INEXISTENTE***");
    	}
    }
    
   
    public static int menuModificar() {
    	System.out.println("1 Modificar descripcion");
    	System.out.println("2 Modificar precio unitario");
    	System.out.println("3 Modificar categoria");
    	System.out.println("4 Modificar origen");
    	System.out.println("5 Salir");
    	System.out.print("Elija una opcion: ");
    	op=sc.nextInt();
        return op;
        }
 
}