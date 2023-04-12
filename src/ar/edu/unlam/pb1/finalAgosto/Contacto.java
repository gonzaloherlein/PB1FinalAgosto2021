package ar.edu.unlam.pb1.finalAgosto;

import java.util.Arrays;

public class Contacto {
	
	/*
	 * Se deben incorporar los atributos necesarios.
	 * 
	 * �	Nombre y Apellido: No se aceptan n�meros.
	 * �	Celular: Compuesto del c�digo de pa�s + c�digo de �rea + n�mero de celular.
	 * �	E-Mail: Debe contener al menos el s�mbolo �@� y el caracter �.�.
	 * �	Direcci�n: Valor alfanum�rico.
	 * �	C�digo Postal: Valor num�rico.
	 * �	Localidad: Valor alfanum�rico.
	 * �	Provincia. Enumerador que contenga las 23 provincias argentinas.
	 * �	Es cliente (Si o No): Inicialmente se carga en �No�.
	 * �	Desea ser llamado nuevamente (Si o No): Inicialmente se carga en �Si�.
	 */
	private String nombreYApellido;
	private int celular;
	private String email;
	private String direccion;
	private int codigoPostal;
	private String localidad;
	private Provincia provincia;
	private Boolean esCliente;
	private Boolean llamarNuevamente;
	
	private Llamada[] listaDellamadas;
	private final int CANTIDAD_MAXIMA_DE_LLAMADAS = 10;
	
	public Contacto() {
		
	}
	
	public Contacto(String nombreYApellido, int celular, String email, String direccion, int codigoPostal, String localidad, Provincia provincia) {
		this.nombreYApellido = nombreYApellido;
		this.celular = celular;
		this.email = email;
		this.direccion = direccion;
		this.codigoPostal = codigoPostal;
		this.localidad = localidad;
		this.provincia = provincia;
		this.esCliente = false;
		this.llamarNuevamente = true;
		this.listaDellamadas = new Llamada[CANTIDAD_MAXIMA_DE_LLAMADAS];
	}
	
	
	public static boolean esEmailValido(String email) {
		/*
		 * Eval�a si un String determinado puede ser almacenado como E-MAIL.
		 */
		if(email.contains("@") && email.contains(".")) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean registrarNuevaLlamada(Llamada nueva) {
		/*
		 * Registra una nueva llamada asociada al contacto actual.
		 */
		for (int i = 0; i < listaDellamadas.length; i++) {
			if(listaDellamadas[i] == null) {
				listaDellamadas[i] = nueva;
				return true;
			}
		}	
		this.llamarNuevamente = false;
		return false;
	}
	
	
	public Boolean getEsCliente() {
		return esCliente;
	}

	public void setEsCliente(Boolean esCliente) {
		this.esCliente = esCliente;
	}

	public Boolean getLlamarNuevamente() {
		return llamarNuevamente;
	}

	public void setLlamarNuevamente(Boolean llamarNuevamente) {
		this.llamarNuevamente = llamarNuevamente;
	}
	

	public int getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	@Override
	public String toString() {
		String resultado = "";
		
		resultado = this.nombreYApellido + "\n" + this.celular;
		
		for (int i = 0; i < listaDellamadas.length; i++) {
			if(listaDellamadas[i] != null) {
				resultado += "\n" + "[" + i + "]" + listaDellamadas[i].getObservaciones();
			}
		}
		return resultado;
	}

	public String getNombreYApellido() {
		return nombreYApellido;
	}

	public void setNombreYApellido(String nombreYApellido) {
		this.nombreYApellido = nombreYApellido;
	}

	

	
	
}
