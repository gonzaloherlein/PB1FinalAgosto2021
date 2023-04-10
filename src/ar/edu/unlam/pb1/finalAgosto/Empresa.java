package ar.edu.unlam.pb1.finalAgosto;

import java.util.Random;

public class Empresa {

	/*
	 * Se deben incorporar los atributos necesarios.
	 */
	
	private String nombreEmpresa;
	private int codigoPostal;
	private int[] zonaDeCobertura = new int[100];
	private Contacto[] contactos = new Contacto[100];
	
	public Empresa() {
		
	}
	
	public Empresa(String nombreEmpresa, int codigoPostal, int[] zonaDeCobertura) {
		this.nombreEmpresa = nombreEmpresa;
		this.codigoPostal = codigoPostal;
		this.zonaDeCobertura = zonaDeCobertura;
		this.contactos = new Contacto[100];
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
					contacto.setEsCliente(true);
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
		
		Contacto[] candidato = new Contacto[contactos.length];
		int numCandidatos = 0;
		/*
		 * Para determinar qu� contacto el sistema debe mostrar, se debe realizar la siguiente b�squeda:
		 * 1.	El contacto NO debe ser cliente a�n.
		 * 2.	El contacto desea ser llamado o al menos no inform� lo contrario.
		 * 3.	El c�digo postal del contacto debe existir en las zonas de cobertura existente.
		 * 4.	Del conjunto de contactos resultante se debe seleccionar aleatoriamente el pr�ximo llamado.
		 */
		for (int i = 0; i < contactos.length; i++) {
			if(contactos[i] != null){
				if(contactos[i].getEsCliente() == false && contactos[i].getLlamarNuevamente() == null && contactos[i].getCodigoPostal() == zonaDeCobertura[i]) {
					 candidato[numCandidatos] = contactos[i];
				     numCandidatos++;
				}
			}
		}
		if(numCandidatos > 0) {
			Random random = new Random();
			int index = random.nextInt(candidato.length);
			Contacto proximoContacto = candidato[index];
			return proximoContacto;
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
