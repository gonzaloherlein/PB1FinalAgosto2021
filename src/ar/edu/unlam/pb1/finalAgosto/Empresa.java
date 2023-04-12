package ar.edu.unlam.pb1.finalAgosto;

import java.util.Random;

public class Empresa {

	/*
	 * Se deben incorporar los atributos necesarios.
	 */
	
	private String nombreEmpresa;
	private int codigoPostal;
	private int[] zonaDeCobertura;
	private Contacto[] contactos;
	private final int CANTIDAD_MAXIMA_DE_ZONAS = 100;
	private final int CANTIDAD_MAXIMA_DE_CONTACTOS = 100;
	
	
	public Empresa() {
		
	}
	
	public Empresa(String nombreEmpresa, int codigoPostal, int[] zonaDeCobertura) {
		this.nombreEmpresa = nombreEmpresa;
		this.codigoPostal = codigoPostal;
		this.zonaDeCobertura = new int [CANTIDAD_MAXIMA_DE_ZONAS];
		this.contactos = new Contacto[CANTIDAD_MAXIMA_DE_CONTACTOS];
	}
	
	public String getNombreEmpresa() {
		/*
		 * Devuelve el nombre de la empresa
		 */
		
		return this.nombreEmpresa;
	}
	
	public boolean agregarNuevoContacto(Contacto contacto) {
		for (int i = 0; i < contactos.length; i++) {
			if (contactos[i] == null) {
					contactos[i] = contacto;
					return true;
			}
		}
		return false;
	}
	
	public boolean agregarNuevaZonaDeCobertura(int codigoPostal) {
		/*
		 * Incorpora una nueva zona de cobertura (Las zonas de cobertura se identifican por el codigo postal)
		 */
		for (int i = 0; i < this.zonaDeCobertura.length; i++) {
			if(zonaDeCobertura[i] == 0 && !(elCodigoPostalEstaDentroDeLaZonaDeCobertura(codigoPostal))) {
				zonaDeCobertura[i] = codigoPostal;
				return true;
			}
		}
		return false;
	}	
	
	private boolean elCodigoPostalEstaDentroDeLaZonaDeCobertura(int codigoPostal) {
		/*
		 * Determina si un c�digo postal est� dentro de la zona de cobertura
		 */
		for (int i = 0; i < zonaDeCobertura.length; i++) {
			if(zonaDeCobertura[i] == codigoPostal) {
				return true;
			}
		}
		return false;
	}
	
	public Contacto buscarCandidato() {
		/*
		 * Para determinar qu� contacto el sistema debe mostrar, se debe realizar la siguiente b�squeda:
		 * 1.	El contacto NO debe ser cliente a�n.
		 * 2.	El contacto desea ser llamado o al menos no inform� lo contrario.
		 * 3.	El c�digo postal del contacto debe existir en las zonas de cobertura existente.
		 * 4.	Del conjunto de contactos resultante se debe seleccionar aleatoriamente el pr�ximo llamado.
		 */
		Contacto candidatos[] = new Contacto[contactos.length];
		int cantidadDeCandidatos = 0;
		
		
		for (int i = 0; i < contactos.length; i++) {
			if(contactos[i]!= null && contactos[i].getLlamarNuevamente() && !contactos[i].getEsCliente()) {
				candidatos[cantidadDeCandidatos++] = contactos[i];
			}
		}
		
		int candidatoAleatorio = (int)(Math.random() * cantidadDeCandidatos);
		return candidatos[candidatoAleatorio];
	}
	
	public Contacto buscarPorNombre(String nombre) {
		for (int i = 0; i < contactos.length; i++) {
			if(contactos[i] != null) {
				if(contactos[i].getNombreYApellido().equalsIgnoreCase(nombre)) {
					return contactos[i];
				}
			}
		}
		return null;
	}
	

	public Contacto[] getContactos() {
		return contactos;
	}

	public void setContactos(Contacto[] contactos) {
		this.contactos = contactos;
	}

	public int getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
}
