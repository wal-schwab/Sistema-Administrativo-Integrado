package controlador.centroDeCosto;

import java.awt.Component;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import controlador.estandar.ControladorGeneral;
import modelo.dao.CentroDeCostoDAO;
import modelo.entidades.CentroDeCosto;
import modelo.entidades.Usuario;
import vista.centroDeCosto.VentanaGestionCentroDeCosto;

public class ControladorGestionCentroCosto extends ControladorGeneral {

	CentroDeCostoDAO modelo;
	VentanaGestionCentroDeCosto vista;
	Usuario usuario;

	public ControladorGestionCentroCosto(VentanaGestionCentroDeCosto vista, CentroDeCostoDAO modelo ,Usuario usuario) {
		super();
		this.modelo = modelo;
		this.vista = vista;
		this.usuario = usuario;

		for (Component c : vista.getPanel().getComponents()) {
			JButton boton;
			if (c instanceof JButton && "Listar Centros de Costos".equals(c.getName())){
				boton = (JButton) c;
				boton.addActionListener(e -> {
					manejarListarCentrosCostos();
				});	
			}
			if (c instanceof JButton && "Eliminar Centro de Costo".equals(c.getName())) {
				boton = (JButton) c;
				boton.addActionListener(e -> {
					manejarEliminarCentroCosto();
				});
			}
			if (c instanceof JButton && "Crear Centro de Costo".equals(c.getName())) {
				boton = (JButton) c;
				boton.addActionListener(e -> {
					manejarCrearCentroCosto();
				});
			}
			if (c instanceof JButton && "Modificar Centro de Costo".equals(c.getName())) {
				boton = (JButton) c;
				boton.addActionListener(e -> {
					manejarModificarCentroCosto();
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

	private void manejarListarCentrosCostos() {
		String rolUsuario = usuario.getRolUsuario().getNombreRol();
		if(rolUsuario.equals("Lectura/Escritura") || rolUsuario.equals("Administrador")	){
			vista.activarOpciones();
		}
		vista.getPanel().getFondo().setVisible(false);
		try {
			String[] nombresColumnas = {"ID","Área","Direccion"};
			List <Object[]> filas = new ArrayList<Object[]>();
			List <CentroDeCosto> centrosDeCostos = modelo.listarTodos();
			for(CentroDeCosto cc : centrosDeCostos) {
				Object[] fila = {
						cc.getIdCentro(),
						cc.getNombreCentro(),
						cc.getDireccion()
				};
				filas.add(fila);
			}	
			vista.mostrarCentrosDeCostosEnTabla(nombresColumnas, filas);
		} catch (SQLException ex) {
			vista.mostrarMensajeErrorBD(ex.getLocalizedMessage());   		
		}
	}

	private void manejarEliminarCentroCosto() {
		try {
			List <CentroDeCosto> centrosDeCostos = modelo.listarTodos();	
			String idCentros[] = new String[centrosDeCostos.size()];
			int i = 0;
			for (CentroDeCosto cc : centrosDeCostos) {
				idCentros[i] = String.valueOf(cc.getIdCentro());
				i++;
			}
			String idCentro = vista.mostrarCuadroEliminacionCentroDeCosto(idCentros);
			if(idCentro.length() > 0) {
				Integer numIdCentro = Integer.parseInt(idCentro);
				boolean esExitoso = modelo.eliminar(numIdCentro);
				if(esExitoso) {

					vista.mostrarEliminacionExitoso(String.valueOf(numIdCentro));
				}	
			}
		} catch (Exception ex) {
			vista.mostrarMensajeErrorBD(ex.getLocalizedMessage());
		}
	}

	private void manejarCrearCentroCosto() {
		try {
			List<String> datos = vista.mostrarVentanasCrearCentroDeCosto();

			if (datos.get(0) != null && datos.get(1) != null && datos.get(2) != null) {
				int idCentro = Integer.parseInt(datos.get(0));
				CentroDeCosto nuevoCentro = new CentroDeCosto(idCentro, datos.get(1), datos.get(2));
				boolean creado = modelo.crear(nuevoCentro);
				if (creado) {
					JOptionPane.showMessageDialog(vista, "¡Centro de Costo creado exitosamente!");
				} else {
					JOptionPane.showMessageDialog(vista, "Error al crear el centro de costo.");
				}
			} else {
				JOptionPane.showMessageDialog(vista, "Operación cancelada.");
			}
		} catch (Exception ex) {
			vista.mostrarMensajeErrorBD("Error: " + ex.getMessage());
		}
	}

	private void manejarModificarCentroCosto() {
		try {
			List<CentroDeCosto> centrosDeCostos = modelo.listarTodos();
			String[] opciones = new String[centrosDeCostos.size()];
			int i = 0;
			for(CentroDeCosto cc : centrosDeCostos) {
				opciones[i] = String.valueOf(cc.getIdCentro());
				i++;
			}
			int indice = vista.mostrarListaDeCentrosDeCostos(opciones);
			if (indice > -1) {
				List<String> nuevosDatos = vista.mostrarVentanasModificarCentrosDeCostos();
				CentroDeCosto centroCostoSeleccionado = centrosDeCostos.get(indice);
				if (nuevosDatos.get(0) != null && nuevosDatos.get(1) != null) {
					centroCostoSeleccionado.setNombreCentro(nuevosDatos.get(0));
					centroCostoSeleccionado.setDireccion(nuevosDatos.get(1));

					boolean exito = modelo.modificar(centroCostoSeleccionado);
					if (exito) {
						vista.mostrarModificacionExitoso(centroCostoSeleccionado.getIdCentro());
					}
				}
			}
		} catch (Exception ex) {
			vista.mostrarMensajeErrorBD("Error al modificar centro de costo: " + ex.getMessage());
		}
	}
}
