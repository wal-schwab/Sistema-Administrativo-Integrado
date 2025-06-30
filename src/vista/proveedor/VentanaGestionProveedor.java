package vista.proveedor;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import vista.estandar.VentanaEstandarAplicacion;

public class VentanaGestionProveedor extends VentanaEstandarAplicacion{

	public VentanaGestionProveedor(String nombreVentana,String nombreUsuario,String apellidoUsuario, String nombreRol) {
		super(nombreVentana, nombreUsuario, apellidoUsuario, nombreRol);
			
		panel.add(agregarBoton("Volver", new ImageIcon("resources/images/imageBack.png"), 10, 10, 60, 40, 0, true));
		panel.add(agregarLabel("Menu", 180, 40, 200, 50, 22));
		panel.add(agregarLabel("Presione en 'Listar' para comenzar", 685, 65, 200, 30, 12));
		panel.add(agregarBoton("Listar Proveedores", 650, 90, 270, 30, 16, true));
		panel.add(agregarBoton("Crear Proveedor", 80, 90, 270, 60, 16, false));
		panel.add(agregarBoton("Modificar Proveedor", 80, 155, 270, 60, 16, false));
		panel.add(agregarBoton("Eliminar Proveedor", 80, 220, 270, 60, 16, false));
		panel.add(agregarBoton("Cerrar Sesión", 80, 520, 270, 60, 16, true));
		panel.add(agregarBoton("Salir", 80, 585, 270, 60, 16, true));	
	}
	
	public void usuarioLecturaEscritura() {
		activarOpciones();
	}
	
	public void mostrarProveedoresEnTabla(String[] nombresColumnas, List <Object[]> filas) {	
		JScrollPane scrollTabla = mostrarEnTabla(nombresColumnas, filas, 450, 130, 650, 380);
		panel.add(scrollTabla);
		activarOpciones();
	}	
	
	public String mostrarCuadroEliminacionProveedor(String[] idProveedores) {
		JComboBox<String> opciones = new JComboBox<String>(idProveedores);
		String seleccion = "";
		int resultado = JOptionPane.showConfirmDialog(
				this,
				opciones,
				"Selecciona un proveedor a eliminar",
				JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null
				);
		 if (resultado == JOptionPane.OK_OPTION) {
	            seleccion = (String) opciones.getSelectedItem();
	        } else {
	            JOptionPane.showMessageDialog(null, "No seleccionaste ninguna opción");
	        }
		return seleccion;
	}
	
	public void mostrarEliminacionExitoso(String idProveedor) {
		JOptionPane.showMessageDialog(null, "¡Se ha eliminado el proveedor " + idProveedor + "!");
	}
	
	public void mostrarModificacionExitoso(int idProveedor) {
		JOptionPane.showMessageDialog(null, "¡Se ha modificado el proveedor " + idProveedor + "!");
	}
	
	public List<String> mostrarVentanasCrearProveedor(){
		List<String> datos = new ArrayList<String>();
		  String id = JOptionPane.showInputDialog("ID del proveedor (8 dígitos):");
		  datos.add(id);
          String nombre = JOptionPane.showInputDialog("Nombre del proveedor:");
          datos.add(nombre);
          String contacto = JOptionPane.showInputDialog("Nombre del contacto:");
          datos.add(contacto);
          String email = JOptionPane.showInputDialog("Correo electrónico:");
          datos.add(email);
          String actividad = JOptionPane.showInputDialog("Actividad principal:");
          datos.add(actividad);
		return datos;
	}
	
	public int mostrarListaDeProveedores(String[] opciones) {
		JComboBox<String> combo = new JComboBox<>(opciones);
		int indice = -1;
		int seleccion = JOptionPane.showConfirmDialog(this, combo, "Seleccioná un proveedor", JOptionPane.OK_CANCEL_OPTION);
		if (seleccion == JOptionPane.OK_OPTION) {
            indice = combo.getSelectedIndex();
		}
		return indice;
	}
	
	public List<String> mostrarVentanasModificarProveedor() {
		List<String> datos = new ArrayList<String>();
        String nombre = JOptionPane.showInputDialog("Nuevo nombre:");
        datos.add(nombre);
        String contacto = JOptionPane.showInputDialog("Nuevo contacto:");
        datos.add(contacto);
        String email = JOptionPane.showInputDialog("Nuevo correo electrónico:");
        datos.add(email);
        String actividad = JOptionPane.showInputDialog("Nueva actividad principal:");
        datos.add(actividad);
		return datos;
	}
	
	@Override
	public JButton agregarBoton(String nombre, int ubicacionX, int ubicacionY, int ancho, int alto, int tamanoFuente, boolean visible) {
		boton = new JButton(nombre);
		boton.setName(nombre);
		boton.setBounds(ubicacionX,ubicacionY,ancho,alto);
		boton.setBackground(new Color(220, 220, 220));
		boton.setFont(new Font("Arial", 1, tamanoFuente));
		boton.setForeground(new Color(0,0,0));
		boton.setEnabled(visible);
		return boton;
	}
	
	@Override
	public JButton agregarBoton(String nombre, ImageIcon imagen, int ubicacionX, int ubicacionY, int ancho,int alto, int tamanoFuente, boolean visible) {
		boton = new JButton(nombre,imagen);
		boton.setName(nombre);
		boton.setBounds(ubicacionX,ubicacionY,ancho,alto);
		boton.setBackground(new Color(220, 220, 220));
		boton.setFont(new Font("Arial", 1, tamanoFuente));
		boton.setForeground(new Color(0,0,0));
		boton.setEnabled(visible);
		return boton;
	}
		
	@Override
	public JLabel agregarLabel(String nombre, int ubicacionX, int ubicacionY, int ancho, int alto, int tamanoFuente) {
		label = new JLabel(nombre);
		label.setFont(new Font("Arial", Font.BOLD, tamanoFuente));
		label.setBounds(ubicacionX,ubicacionY ,ancho ,alto);
		label.setForeground(new Color(255,255,255));
		return label;	
	}
	

	@Override
	public JTextField agregarTextField(String nombre, int ubicacionX, int ubicacionY, int ancho, int alto, int tamanoFuente) {return null;}

	@Override
	public JPasswordField agregarPasswordField(String nombre, int ubicacionX, int ubicacionY, int ancho, int alto, int tamanoFuente) {return null;}

	@Override
	public JLabel agregarLabel(String rutaDeImagen, int ubicacionX, int ubicacionY, int ancho, int alto) {return null;}
}
