package Dispositivo_a_controlar;

public class Proyector implements configuracion_DAC {
	private String Imagen=null;
	private int volumen=-1;
	
	@Override
	public void insertarImagen(String Imagen) {
		this.Imagen=Imagen;
	}

	@Override
	public void ajustarVolumen(int volumen) {
		this.volumen=volumen;
	}
	
	public String mostrarConfiguracion() {
		String reporte="Nombre de la imagen configurada: "+Imagen+"\nVolumen actual del dispositivo: "+volumen;
		return reporte;
	}
}
