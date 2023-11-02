package Dispositivos_Controladores;

import Dispositivo_a_controlar.configuracion_DAC;

public class Smartphone extends Configuracion_Contrloadores{

	public Smartphone(configuracion_DAC configuracion) {
		super(configuracion);
	}
	
	@Override
	public void control(int volumen, String imagen) {
		configuracion.ajustarVolumen(volumen);
		configuracion.insertarImagen(imagen);
	}
	
	@Override
	public String mostrarConfiguracion() {
		return configuracion.mostrarConfiguracion();
	}

}
