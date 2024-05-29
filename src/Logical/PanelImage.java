package Logical;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelImage extends JPanel {
	private Image image;
	private Icon icon;
	@Override
	protected void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D)g;
		if(image!=null) {
			g2d.drawImage(image,0, 0, getWidth(), getHeight(), null);
		}
	}
	public void setIcon(Icon icon) {
		this.icon=icon;
		if(icon!=null) {
			image=((ImageIcon)icon).getImage();
		}
	}
	public Icon getIcon() {
		return icon;
	}
	public void setImage(String ruta) {
		setIcon(new ImageIcon(getClass().getResource(ruta)));
	}
}
