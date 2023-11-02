package main;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextPane;
import Dispositivo_a_controlar.*;
import Dispositivos_Controladores.*;

public class Principal {

	private JFrame frame;
	private JTextField text_Imagen;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Principal() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 546, 523);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Dispositivos Inteligentes");
		lblNewLabel.setFont(new Font("Nirmala UI", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 11, 182, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JRadioButton Radio_Laptop = new JRadioButton("Laptop");
		Radio_Laptop.setBounds(48, 88, 123, 23);
		frame.getContentPane().add(Radio_Laptop);
		
		JRadioButton Radio_Proyector = new JRadioButton("Proyector");
		Radio_Proyector.setBounds(48, 131, 109, 23);
		frame.getContentPane().add(Radio_Proyector);
		
		JRadioButton Radio_Smart_TV = new JRadioButton("Smart TV");
		Radio_Smart_TV.setBounds(48, 187, 109, 23);
		frame.getContentPane().add(Radio_Smart_TV);
		
		ButtonGroup grupo_Acontrolar = new ButtonGroup();
		grupo_Acontrolar.add(Radio_Smart_TV);
		grupo_Acontrolar.add(Radio_Proyector);
		grupo_Acontrolar.add(Radio_Laptop);
		
		JRadioButton Radio_Alexa = new JRadioButton("Alexa");
		Radio_Alexa.setBounds(355, 88, 109, 23);
		frame.getContentPane().add(Radio_Alexa);
		
		JRadioButton Radio_Google_Home = new JRadioButton("GoogleHome");
		Radio_Google_Home.setBounds(355, 131, 109, 23);
		frame.getContentPane().add(Radio_Google_Home);
		
		JRadioButton Radio_SmartPhone = new JRadioButton("SmartPhone");
		Radio_SmartPhone.setBounds(355, 187, 109, 23);
		frame.getContentPane().add(Radio_SmartPhone);
		
		ButtonGroup grupo_controla = new ButtonGroup();
		grupo_controla.add(Radio_Alexa);
		grupo_controla.add(Radio_SmartPhone);
		grupo_controla.add(Radio_Google_Home);
		
		JLabel lblDispositivosControladores = new JLabel("Dispositivo controlador");
		lblDispositivosControladores.setFont(new Font("Nirmala UI", Font.BOLD, 13));
		lblDispositivosControladores.setBounds(321, 58, 182, 23);
		frame.getContentPane().add(lblDispositivosControladores);
		
		JLabel lblDispositivosControlados = new JLabel("Dispositivo controlado");
		lblDispositivosControlados.setFont(new Font("Nirmala UI", Font.BOLD, 13));
		lblDispositivosControlados.setBounds(12, 58, 182, 23);
		frame.getContentPane().add(lblDispositivosControlados);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		spinner.setBounds(73, 265, 56, 20);
		frame.getContentPane().add(spinner);
		
		JLabel lblVolumen = new JLabel("Volumen");
		lblVolumen.setFont(new Font("Nirmala UI", Font.BOLD, 13));
		lblVolumen.setBounds(10, 263, 182, 23);
		frame.getContentPane().add(lblVolumen);
		
		JLabel lblNombreDeLa = new JLabel("Nombre de la imagen");
		lblNombreDeLa.setFont(new Font("Nirmala UI", Font.BOLD, 13));
		lblNombreDeLa.setBounds(10, 296, 182, 23);
		frame.getContentPane().add(lblNombreDeLa);
		
		text_Imagen = new JTextField();
		text_Imagen.setBounds(147, 297, 192, 20);
		frame.getContentPane().add(text_Imagen);
		text_Imagen.setColumns(10);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(12, 341, 483, 57);
		frame.getContentPane().add(textPane);
		
		JButton btnNewButton = new JButton("Agregar conexion y configuracion");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int volumen = (int) spinner.getValue();
				String imagen = text_Imagen.getText();
				configuracion_DAC laptop = new Laptop();
				configuracion_DAC proyector = new Proyector();
				configuracion_DAC smart_tv = new Smart_TV();
				String reporte;
				
				if(Radio_Laptop.isSelected()){
					if(Radio_Alexa.isSelected()){
						Configuracion_Contrloadores alexa=new Alexa(laptop);
						alexa.control(volumen, imagen);
						reporte=alexa.mostrarConfiguracion();
						
					}else if(Radio_SmartPhone.isSelected()){
						Configuracion_Contrloadores smartPhone=new Smartphone(laptop);
						smartPhone.control(volumen, imagen);
						reporte=smartPhone.mostrarConfiguracion();
					}else {
						Configuracion_Contrloadores googleHome=new GoogleHome(laptop);
						googleHome.control(volumen, imagen);
						reporte=googleHome.mostrarConfiguracion();
					}
				}else if(Radio_Proyector.isSelected()){
					if(Radio_Alexa.isSelected()){
						Configuracion_Contrloadores alexa=new Alexa(proyector);
						alexa.control(volumen, imagen);
						reporte=alexa.mostrarConfiguracion();
						
					}else if(Radio_SmartPhone.isSelected()){
						Configuracion_Contrloadores smartPhone=new Smartphone(proyector);
						smartPhone.control(volumen, imagen);
						reporte=smartPhone.mostrarConfiguracion();
						
					}else {
						Configuracion_Contrloadores googleHome=new GoogleHome(proyector);
						googleHome.control(volumen, imagen);
						reporte=googleHome.mostrarConfiguracion();
					}
				}else{
					if(Radio_Alexa.isSelected()){
						Configuracion_Contrloadores alexa=new Alexa(smart_tv);
						alexa.control(volumen, imagen);
						reporte=alexa.mostrarConfiguracion();
						
					}else if(Radio_SmartPhone.isSelected()){
						Configuracion_Contrloadores smartPhone=new Smartphone(smart_tv);
						smartPhone.control(volumen, imagen);
						reporte=smartPhone.mostrarConfiguracion();
						
					}else {
						Configuracion_Contrloadores googleHome=new GoogleHome(smart_tv);
						googleHome.control(volumen, imagen);
						reporte=googleHome.mostrarConfiguracion();
					}
				}
				
				textPane.setText(reporte);
			}
		});
		btnNewButton.setBounds(150, 420, 199, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
