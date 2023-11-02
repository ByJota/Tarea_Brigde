package Dispositivos_Controladores;
import Dispositivo_a_controlar.configuracion_DAC;

public abstract class Configuracion_Contrloadores {
	protected configuracion_DAC configuracion;
	
	public Configuracion_Contrloadores(configuracion_DAC configuracion){
		this.configuracion=configuracion;
	}
	
	public abstract void control(int volumen, String imagen);

	public abstract String mostrarConfiguracion();
}
