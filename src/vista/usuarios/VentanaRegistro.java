package vista.usuarios;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import vista.estandar.VentanaEstandarInicial;

public class VentanaRegistro extends VentanaEstandarInicial{
	
	private JTextField textoNombre;
	private JTextField textoApellido;
	private JTextField textoLegajo;
	private JPasswordField textoContrasena; 
	private JPasswordField textoRepetirContrasena;
	
	public VentanaRegistro() {
		super("SAI - Registrarse");
		
		panel.add(agregarLabel("Registrarse", 120, 10, 250, 30, 25));
		panel.add(agregarLabel("Ingrese sus datos", 10, 50, 250, 30, 17));
		panel.add(agregarLabel("Nombre:", 10, 90, 80, 30, 15));
		textoNombre = agregarTextField("", 90, 90, 200, 30, 15);
		panel.add(textoNombre);
		panel.add(agregarLabel("Apellido:", 10, 130, 80, 30, 15));
		textoApellido = agregarTextField("", 90, 130, 200, 30, 15);
		panel.add(textoApellido);
		panel.add(agregarLabel("Legajo:", 10, 170, 80, 30, 15));
		textoLegajo = agregarTextField("", 90, 170, 200, 30, 15);
		panel.add(textoLegajo);
		panel.add(agregarBoton("Validar datos", 90, 215, 200, 40, 16,true));
		panel.add(agregarLabel("Contraseña", 145, 275, 150, 30, 15));
		textoContrasena = agregarPasswordField("", 90, 305, 200, 30, 15,false);
		panel.add(textoContrasena);
		panel.add(agregarLabel("Repetir Contraseña", 125, 350, 150, 30, 15));
		textoRepetirContrasena = agregarPasswordField("", 90, 380, 200, 30, 15,false);
		panel.add(textoRepetirContrasena);
		panel.add(agregarBoton("Registrarse", 190, 440, 160, 40, 16,false));
		panel.add(agregarBoton("Volver", 20, 440, 160, 40, 16,true));

	}
	
	public JTextField getTextoNombre() {
		return textoNombre;
	}

	public JTextField getTextoApellido() {
		return textoApellido;
	}

	public JTextField getTextoLegajo() {
		return textoLegajo;
	}

	public JPasswordField getTextoContrasena() {
		return textoContrasena;
	}

	public JPasswordField getTextoRepetirContrasena() {
		return textoRepetirContrasena;
	}
	
	public void mostrarMensajeDatosIncorrectos() {
		JOptionPane.showMessageDialog(null, "Algunos de los datos ingresados\nno son válidos");
	}
	
	public void mostrarMensajeLegajoConUsuario() {
		JOptionPane.showMessageDialog(null, "El legajo ya tiene una cuenta asocida");
	}
	
	public void mostrarMensajeContrasenasDistintas(){
		JOptionPane.showMessageDialog(null, "Las contraseñas no son iguales");
	}

	public void mostrarMensajeFormatoContrasenaIncorrecta() {
		JOptionPane.showMessageDialog(null, "La contraseña debe contener mas de 8 caracteres, contener números y letras, no poseer espacios");
	}
	
	public void mostrarMensajeUsuarioCreado(){
		JOptionPane.showMessageDialog(null, "El usuario fue creado exitosamente.\nQuedará a la espera para recibir un rol de usuario");
	}
	public void habilitarContrasenas() {
		textoContrasena.setEnabled(true);
		textoRepetirContrasena.setEnabled(true);
		textoApellido.setEnabled(false);
		textoNombre.setEnabled(false);
		textoLegajo.setEnabled(false);
		for (Component c : panel.getComponents()) {
			JButton boton;
		    if (c instanceof JButton && "Registrarse".equals(c.getName())) {
		        boton = (JButton) c;
		        boton.setEnabled(true);
		    }else if(c instanceof JButton && "Validar datos".equals(c.getName())) {
		        boton = (JButton) c;
		        boton.setEnabled(false);
		    }
		}
	}

	@Override
	public JButton agregarBoton(String nombre, int ubicacionX, int ubicacionY,int ancho, int alto, int tamanoFuente, boolean estaHabilitado) {
		boton = new JButton(nombre);
		boton.setName(nombre);
		boton.setBounds(ubicacionX,ubicacionY,ancho,alto);
		boton.setBackground(new Color(220, 220, 220));
		boton.setFont(new Font("Arial", 1, tamanoFuente));
		boton.setForeground(new Color(0,0,0));
		boton.setEnabled(estaHabilitado);
		return boton;	
	}

	@Override
	public JLabel agregarLabel(String nombre, int ubicacionX, int ubicacionY,int ancho, int alto, int tamanoFuente) {
		label = new JLabel(nombre);
		label.setFont(new Font("Arial", Font.BOLD, tamanoFuente));
		label.setBounds(ubicacionX,ubicacionY ,ancho ,alto);
		label.setForeground(new Color(255,255,255));
		return label;
	}

	@Override
	public JTextField agregarTextField(String nombre, int ubicacionX, int ubicacionY,int ancho, int alto, int tamanoFuente) {
		campoTexto = new JTextField();
		campoTexto.setBounds(ubicacionX,ubicacionY,ancho,alto);
		campoTexto.setBackground(new Color(255,255,255));
		campoTexto.setFont(new Font("Andale Mono", 1, tamanoFuente));
		campoTexto.setForeground(new Color(0,0,0));
		return campoTexto;
	}

	@Override
	public JPasswordField agregarPasswordField(String nombre, int ubicacionX, int ubicacionY,int ancho, int alto, int tamanoFuente, boolean estaHabilitado) {
		campoContrasena = new JPasswordField();
		campoContrasena.setBounds(ubicacionX,ubicacionY,ancho,alto);
		campoContrasena.setBackground(new Color(255,255,255));
		campoContrasena.setFont(new Font("Andale Mono", 1, tamanoFuente));
		campoContrasena.setForeground(new Color(0,0,0));
		campoContrasena.setEnabled(estaHabilitado);
		return campoContrasena;
	}

	@Override
	public JLabel agregarLabel(String rutaDeImagen, int ubicacionX, int ubicacionY, int ancho, int alto) {return null;}

}
