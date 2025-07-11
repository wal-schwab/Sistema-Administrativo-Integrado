package controlador.gasto;

import java.awt.Component;

import javax.swing.JButton;

import controlador.estandar.ControladorGeneral;
import modelo.dao.GastoDAO;
import modelo.entidades.Usuario;
import vista.gasto.VentanaGestionGasto;

public class ControladorGestionGasto extends ControladorGeneral{

	VentanaGestionGasto vista;
	GastoDAO modelo;
	Usuario usuario;

	public ControladorGestionGasto(VentanaGestionGasto vista, GastoDAO modelo, Usuario usuario) {
		super();
		this.vista = vista;
		this.modelo = modelo;
		this.usuario = usuario;

		for (Component c : vista.getPanel().getComponents()) {
			JButton boton;
			if (c instanceof JButton && "Listar Gastos".equals(c.getName())){
				boton = (JButton) c;
				boton.addActionListener(e -> {
					String rolUsuario = usuario.getRolUsuario().getNombreRol();
					if(rolUsuario.equals("Lectura/Escritura") || rolUsuario.equals("Administrador")	){
						vista.activarOpciones();
					}
					manejarListarGastos();

				});	
			}
			if (c instanceof JButton && "Crear Gasto".equals(c.getName())){
				boton = (JButton) c;
				boton.addActionListener(e -> {
					manejarCrearGasto();
				});	
			}
			if (c instanceof JButton && "Modificar Gasto".equals(c.getName())){
				boton = (JButton) c;
				boton.addActionListener(e -> {
					manejarModificarGasto();
				});	
			}
			if (c instanceof JButton && "Cargar Nota D/C".equals(c.getName())){
				boton = (JButton) c;
				boton.addActionListener(e -> {
					manejarCargarNota();
				});	
			}
			if (c instanceof JButton && "Eliminar Gasto".equals(c.getName())){
				boton = (JButton) c;
				boton.addActionListener(e -> {
					manejarEliminarGasto();
				});	
			}
			if (c instanceof JButton && "Volver".equals(c.getName())) {
				boton = (JButton) c;
				boton.addActionListener(e -> {
					abrirVentanaAplicacion(vista, usuario);
				});
			}
			if (c instanceof JButton && "Cerrar Sesión".equals(c.getName())) {
				boton = (JButton) c;
				boton.addActionListener(e -> {
					abrirVentanaPrincipal(vista);
				});
			}
			if (c instanceof JButton && "Salir".equals(c.getName())) {
				boton = (JButton) c;
				boton.addActionListener(e -> {
					salir();
				});
			}
		}
	}

	private void manejarListarGastos() {

	}

	private void manejarCrearGasto() {

	}

	private void manejarModificarGasto() {

	}

	private void manejarCargarNota() {

	}

	private void manejarEliminarGasto() {

	}

}
