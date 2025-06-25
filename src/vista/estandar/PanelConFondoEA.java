package vista.estandar;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelConFondoEA extends JPanel {
	
	private ImageIcon imagenFondo;
	private JLabel fondo;
	
	public PanelConFondoEA() {
		imagenFondo = new ImageIcon("resources/images/logoFondo.png");
		fondo = new JLabel(imagenFondo);
		fondo.setBounds(500, 120, 550, 420);
		add(fondo);
		
		setLayout(null);
		setBackground(new Color(15,55,43));			
				
	}

	public JLabel getFondo() {
		return fondo;
	}	
	
}
