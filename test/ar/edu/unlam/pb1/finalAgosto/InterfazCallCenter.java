package ar.edu.unlam.pb1.finalAgosto;

import java.util.Scanner;

public class InterfazCallCenter {
	
	static Scanner teclado = new Scanner(System.in);
	private static final int SALIR = 9;
	
	
	public static void main(String args[]) {
		
		
		Empresa empresa = new Empresa();
		
		int opcion = 0;
		
		do {
			opcion = seleccionarOpcion(teclado);
			
			switch (opcion) {
			case 1:
				incorporarZonaDeCobertura(teclado,empresa);
				break;
			case 2:
				darDeAltaNuevoContacto(teclado, empresa);
				break;
			case 3:
				realizarNuevaLlamada(teclado, empresa);
				break;
			case 4:
				verInformacionDelContacto(empresa);
				break;
			case SALIR:
				System.out.println("Gracias por utilizar el sistema");
				break;
			}
			
		} while (opcion != SALIR);
			
		teclado.close();
		
	}
	
	private static void incorporarZonaDeCobertura(Scanner teclado, Empresa empresa) {
		/*
		 * Se registra un nuevo codigo postal dentro de la zona de cobertura de la empresa
		 */
		
		int codigoDeCobertura = 0;
		
		System.out.println("Ingrese un nuevo codigo postal: ");
		codigoDeCobertura = teclado.nextInt();
		
		if(empresa.agregarNuevaZonaDeCobertura(codigoDeCobertura)) {
			System.out.println("Se ha incorporado Zona de Cobertura correctamente");
		}else {
			System.out.println("Vuelva a intentarlo");
		}
		
		
	}
	
	private static void darDeAltaNuevoContacto(Scanner teclado, Empresa empresa) {
		/*
		 * Registra un nuevo contacto en la empresa
		 */
		Contacto contacto;
		String email;
		System.out.println("Ingrese el nombre y apellido: ");
		String nombreYApellido = teclado.nextLine();
		
		
		System.out.println("Ingrese el celular: ");
		int celular = teclado.nextInt();
		
		do {
			System.out.println("Ingrese el email: ");
			email = teclado.next();
		} while (!Contacto.esEmailValido(email));
		
		System.out.println("Ingrese la direccion: ");
		String direccion = teclado.nextLine();
		
		
		System.out.println("Ingrese el codigo postal: ");
		int codigoPostal = teclado.nextInt();
		
		System.out.println("Ingrese la localidad: ");
		String localidad = teclado.nextLine();
		
		System.out.println("Ingrese la provincia: ");
		int opcionSeleccionada = teclado.nextInt();
		Provincia provincia = Provincia.values()[opcionSeleccionada - 1];
		
		contacto = new Contacto(nombreYApellido, celular,email,direccion,codigoPostal,localidad,provincia);
		if(empresa.agregarNuevoContacto(contacto)) {
			System.out.println("Se ha registrado el contacto correctamente");
		}else {
			System.out.println("Vuelva a intentarlo");
		}
	}
	
	private static void realizarNuevaLlamada(Scanner teclado, Empresa empresa) {
		/*
		 * Busca un candidato,  muestra los datos del mismo, y permite almacenar el resultado de la llamada.
		 * 
		 * a.	Si la llamada fue exitosa (en ese caso el contacto pasa a ser cliente, y no se lo debe volver a 
		 * llamar).
		 * b.	Si el contacto no desea ser llamado nuevamente (la llamada pudo no haber sido exitosa, pero se haga 
		 * un nuevo intento en el futuro).
		 * c.	Observaciones: Texto libre donde el operador deja registro de lo conversado.
		 */
		Llamada nuevaLlamada;
		Contacto candidato = empresa.buscarCandidato();
		char OpcionDeLlamadaExitosa, OpcionDeDeseaSerLlamadoNuevamente;
		boolean llamadaExitosa = false, deseaSerLlamadoNuevamente = false;
		String observaciones;
		System.out.println(candidato);
		System.out.println("La llamada fue exitosa? (S/N): ");
		OpcionDeLlamadaExitosa = teclado.next().charAt(0);
		if(OpcionDeLlamadaExitosa == 'S') {
			candidato.setEsCliente(true);
		}

		System.out.println("El contacto desea ser llamado nuevamente? (S/N):");
		OpcionDeDeseaSerLlamadoNuevamente = teclado.next().charAt(0);
		if(OpcionDeDeseaSerLlamadoNuevamente == 'N') {
			candidato.setLlamarNuevamente(false);
		}
		
		
		System.out.println("Ingrese las observaciones: ");
		teclado.nextLine();
		observaciones = teclado.nextLine();
		
		nuevaLlamada = new Llamada(llamadaExitosa, observaciones);
		
		candidato.registrarNuevaLlamada(nuevaLlamada);
		
	}
	
	private static void verInformacionDelContacto(Empresa empresa) {
		/*
		 * Se visualiza la informaci�n del contacto, incluso el listado de las llamadas que se le hicieron
		 */
		String nombre = " ";
		Contacto encontrado = null;
		System.out.println("Ingrese el nombre del contacto que desee buscar: ");
		nombre = teclado.nextLine();
		encontrado = empresa.buscarPorNombre(nombre);
		if(encontrado != null) {
			System.out.println(encontrado.toString());
		}else {
			System.out.println("No se ha encontrado el contacto");
		}
	}
	
	
	private static int seleccionarOpcion(Scanner teclado) {
		
		int opcionSeleccionada = 0;
		
		System.out.println("Bienvenido al callcenter");
		
		System.out.println("************************");
		System.out.println("Menu de opciones\n");
		System.out.println("1 - Incorporar zona de cobertura");
		System.out.println("2 - Dar de alta un nuevo contacto");
		System.out.println("3 - Realizar nueva llamada");
		System.out.println("4 - Ver informacion del contacto");
		System.out.println("9 - Salir");
		System.out.println("************************");
		
		opcionSeleccionada = teclado.nextInt();
		
		return opcionSeleccionada;
	}
}
