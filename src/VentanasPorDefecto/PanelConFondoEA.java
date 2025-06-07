package VentanasPorDefecto;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelConFondoEA extends JPanel {
	
	ImageIcon imagenFondo;
	JLabel fondo;
	
	public PanelConFondoEA() {
		
		imagenFondo = new ImageIcon("images/logoFondo.png");
		fondo = new JLabel(imagenFondo);
		fondo.setBounds(500, 40, 600, 600);
		add(fondo);
		
		setLayout(null);
		setBackground(new Color(15,55,43));			
				
	}	
}
