package vista.centroDeCosto;

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

public class VentanaGestionCentroDeCosto extends VentanaEstandarAplicacion{

	public VentanaGestionCentroDeCosto(String nombreUsuario,String apellidoUsuario, String nombreRol) {
		super("Gestión de Centros de Costos", nombreUsuario, apellidoUsuario, nombreRol);

		panel.add(agregarBoton("Volver", new ImageIcon("resources/images/imageBack.png"), 10, 10, 60, 40, 0, true));
		panel.add(agregarLabel("Menu", 180, 40, 200, 50, 22));
		panel.add(agregarLabel("Presione en 'Listar' para comenzar", 685, 65, 200, 30, 12));
		panel.add(agregarBoton("Listar Centros de Costos", 650, 90, 270, 30, 16, true));
		panel.add(agregarBoton("Crear Centro de Costo", 80, 90, 270, 60, 16, false));
		panel.add(agregarBoton("Modificar Centro de Costo", 80, 155, 270, 60, 16, false));
		panel.add(agregarBoton("Eliminar Centro de Costo", 80, 220, 270, 60, 16, false));
		panel.add(agregarBoton("Cerrar Sesión", 80, 520, 270, 60, 16, true));
		panel.add(agregarBoton("Salir", 80, 585, 270, 60, 16, true));	
	}
		
	public void mostrarCentrosDeCostosEnTabla(String[] nombresColumnas, List <Object[]> filas) {	
		JScrollPane scrollTabla = mostrarEnTabla(nombresColumnas, filas, 450, 130, 650, 380);
		panel.add(scrollTabla);
	
	}	
	
	public String mostrarCuadroEliminacionCentroDeCosto(String[] idCentro) {
		JComboBox<String> opciones = new JComboBox<String>(idCentro);
		String seleccion = "";
		int resultado = JOptionPane.showConfirmDialog(
				this,
				opciones,
				"Selecciona un centro de costo a eliminar",
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
	
	public void mostrarEliminacionExitoso(String idCentro) {
		JOptionPane.showMessageDialog(null, "¡Se ha eliminado el centro de costo " + idCentro + "!");
	}
	
	public void mostrarModificacionExitoso(int idCentro) {
		JOptionPane.showMessageDialog(null, "¡Se ha modificado el centro de costo " + idCentro + "!");
	}
	
	public int mostrarListaDeCentrosDeCostos(String[] opciones) {
		JComboBox<String> combo = new JComboBox<>(opciones);
		int indice = -1;
		int seleccion = JOptionPane.showConfirmDialog(this, combo, "Seleccioná un centro de costo", JOptionPane.OK_CANCEL_OPTION);
		if (seleccion == JOptionPane.OK_OPTION) {
            indice = combo.getSelectedIndex();
		}
		return indice;
	}
	
	public List<String> mostrarVentanasModificarCentrosDeCostos() {
		List<String> datos = new ArrayList<String>();
        String nombre = JOptionPane.showInputDialog("Nuevo área:");
        datos.add(nombre);
        String contacto = JOptionPane.showInputDialog("Nuevo dirección:");
        datos.add(contacto);
		return datos;
	}
	
	public List<String> mostrarVentanasCrearCentroDeCosto(){
		List<String> datos = new ArrayList<String>();
		  String idCentro = JOptionPane.showInputDialog("ID del centro de costo (10 dígitos):");
		  datos.add(idCentro);
          String nombre = JOptionPane.showInputDialog("Nombre del área:");
          datos.add(nombre);
          String direccion = JOptionPane.showInputDialog("Direccion a la que pertenece:");
          datos.add(direccion);
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

