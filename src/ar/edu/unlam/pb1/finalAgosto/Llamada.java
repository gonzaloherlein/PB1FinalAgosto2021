package ar.edu.unlam.pb1.finalAgosto;

public class Llamada {

	private boolean fueExitosa;
	private String observaciones;
	
	public Llamada(boolean fueExitosa, String observaciones) {
		this.setFueExitosa(fueExitosa);
		this.setObservaciones(observaciones);
	}

	public boolean FueExitosa() {
		return fueExitosa;
	}

	public void setFueExitosa(boolean fueExitosa) {
		this.fueExitosa = fueExitosa;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
}
