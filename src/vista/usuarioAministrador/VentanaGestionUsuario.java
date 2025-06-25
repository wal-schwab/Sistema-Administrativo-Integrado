package vista.usuarioAministrador;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import vista.estandar.VentanaEstandarAplicacion;

public class VentanaGestionUsuario extends VentanaEstandarAplicacion{
	
	private JTable tablaUsuarios;
	private JComboBox<Integer> legajos;
	private JComboBox<String> roles;
	
	public VentanaGestionUsuario(String nombreVentana,String nombreUsuario,String apellidoUsuario, String nombreRol) {
		super(nombreVentana, nombreUsuario, apellidoUsuario, nombreRol);
	
		panel.add(agregarBoton("Volver", new ImageIcon("resources/images/imageBack.png"), 10, 10, 60, 40, 0, true));
		panel.add(agregarLabel("Menu", 180, 40, 200, 50, 22));
		panel.add(agregarBoton("Listar Usuarios", 650, 90, 270, 30, 16, true));
		panel.add(agregarBoton("Crear Usuario", 80, 90, 270, 60, 16, false));
		panel.add(agregarBoton("Modificar Usuario", 80, 155, 270, 60, 16, false));
		panel.add(agregarBoton("Eliminar Usuario", 80, 220, 270, 60, 16, false));
		panel.add(agregarBoton("Asignar Rol", 80, 285, 270, 60, 16, false));
		panel.add(agregarBoton("Cerrar Sesión", 80, 520, 270, 60, 16, true));
		panel.add(agregarBoton("Salir", 80, 585, 270, 60, 16, true));
		panel.add(agregarLabel("Elegir legajo: ", 470, 515,130 ,60 ,14));
		panel.add(agregarLabel("Elegir nuevo rol: ", 690, 515,130 ,60 ,14));
		
	}
	
	public JComboBox<Integer> getLegajos() {
		return legajos;
	}

	public JComboBox<String> getRoles() {
		return roles;
	}

	public void mostrarUsuariosEnTabla(String[] nombresColumnas, List <Object[]> filas) {	
		DefaultTableModel tablaModelo = new DefaultTableModel();
		for (int i = 0; i < nombresColumnas.length; i++) {
			tablaModelo.addColumn(nombresColumnas[i]);
		}
		for(Object[] fila : filas) {
			tablaModelo.addRow(fila);
		}
		tablaUsuarios = new JTable();
		tablaUsuarios.setModel(tablaModelo);
		tablaUsuarios.setBounds(450, 130, 650, 380);
		JScrollPane scrollTabla = new JScrollPane(tablaUsuarios);
		scrollTabla.setBounds(450, 130, 650, 380);
		panel.add(scrollTabla);
		activarOpciones();
	}
	
	private void activarOpciones() {
		for (Component c : panel.getComponents()) {
			JButton boton = null;
			if (c instanceof JButton) {
				boton = (JButton) c;
				boton.setEnabled(true);
			}
		}
	}
	
	public int pedirConfirmacion(int legajo, String nombreRol) {
		int repuesta = JOptionPane.showConfirmDialog(this, "¿Estas seguro de realizar la asignación del rol?\nEl legajo "+ legajo + " "
															+ "pasará a tener el rol de " + nombreRol, "Asignación de Rol", JOptionPane.OK_CANCEL_OPTION);
		return repuesta;
	}
	
	public void mostrarCambioExitoso() {
		JOptionPane.showMessageDialog(null, "¡El cambio fue exitoso!");
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
	
	public void agregarComboBox(String[] listaRoles,Integer[] listaLegajos) {
		legajos = new JComboBox<>(listaLegajos);
		roles = new JComboBox<String>(listaRoles);
		legajos.setBounds(575, 530, 100, 30);
		roles.setBounds(820, 530, 140, 30);
		panel.add(roles);
		panel.add(legajos);
	}

	@Override
	public JTextField agregarTextField(String nombre, int ubicacionX, int ubicacionY, int ancho, int alto, int tamanoFuente) {return null;}

	@Override
	public JPasswordField agregarPasswordField(String nombre, int ubicacionX, int ubicacionY, int ancho, int alto, int tamanoFuente) {return null;}

	@Override
	public JLabel agregarLabel(String rutaDeImagen, int ubicacionX, int ubicacionY, int ancho, int alto) {return null;}
}


