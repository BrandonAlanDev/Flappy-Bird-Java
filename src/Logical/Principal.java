package Logical;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jPanel1;
	public PanelImage panelImage1;
	public PanelImage jSuelo;
	public JLabel jFlappy;
	public Point posicionFlappy;
	MvnFlappy mvn_Flappy;
	MvnTubos mvn_Tubos;
	public JLabel JTubo_abajo1;
	public JLabel JTubo_arriba1;
	public JLabel JTubo_abajo2;
	public JLabel JTubo_arriba2;
	
	public boolean colision(JLabel tubo) {
		Rectangle rtFlappy= jFlappy.getBounds();
		Rectangle rtTubo= tubo.getBounds();
		if(rtFlappy.intersects(rtTubo)){
			return true;
		}else return false;
	}
	
	MouseListener ml = new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			mvn_Flappy.setSaltar(true);
			jFlappy.requestFocus(true);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			mvn_Flappy.setSaltar(false);
			jFlappy.requestFocus(true);
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	
	};
	
	public void iniciarComponentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		jPanel1 = new JPanel();
		jPanel1.setBackground(new Color(255,255,255));
		panelImage1.setIcon(new ImageIcon(getClass().getResource("/Images/MAPA_NRO1.png")));
		panelImage1.setLayout(null);
		panelImage1.addMouseListener(ml);
		jPanel1.add(panelImage1);
		jSuelo.setIcon(new ImageIcon(getClass().getResource("/Images/piso.png")));
		panelImage1.add(jSuelo);
		jSuelo.setBounds(-130,470,580,180);
		jFlappy.setIcon(new ImageIcon(getClass().getResource("/Images/pezRojo1.png")));
		panelImage1.add(jFlappy);
		jFlappy.setBounds(70,230,34,24);
		JTubo_arriba1.setIcon(new ImageIcon(getClass().getResource("/Images/Tubo_1.png")));
		JTubo_abajo1.setIcon(new ImageIcon(getClass().getResource("/Images/Tubo_2.png")));
		JTubo_arriba2.setIcon(new ImageIcon(getClass().getResource("/Images/Tubo_1.png")));
		JTubo_abajo2.setIcon(new ImageIcon(getClass().getResource("/Images/Tubo_2.png")));
		JTubo_arriba1.setBounds(70,-120,52,320);
		JTubo_abajo1.setBounds(70,280,52,320);
		JTubo_arriba2.setBounds(290,-120,52,320);
		JTubo_abajo2.setBounds(290,280,52,320);
		panelImage1.add(JTubo_arriba1);
		panelImage1.add(JTubo_abajo1);
		panelImage1.add(JTubo_arriba2);
		panelImage1.add(JTubo_abajo2);
		
		this.add(panelImage1);
		GroupLayout jpl = new GroupLayout(jPanel1);
		jPanel1.setLayout(jpl);
		jpl.setHorizontalGroup(jpl.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpl.createSequentialGroup().addComponent(panelImage1,GroupLayout.DEFAULT_SIZE,400,Short.MAX_VALUE).addGap(0,0,0)));
		jpl.setVerticalGroup(jpl.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(panelImage1,GroupLayout.PREFERRED_SIZE,600,Short.MAX_VALUE));
		pack();
	}
	
	public Principal() {
		setBounds(100,100,450,600);
		jPanel1= new JPanel();
		panelImage1= new PanelImage();
		setContentPane(jPanel1);
		jSuelo=new PanelImage();
		jFlappy = new JLabel();
		JTubo_arriba1 = new JLabel();
		JTubo_abajo1 = new JLabel();
		JTubo_arriba2 = new JLabel();
		JTubo_abajo2 = new JLabel();
		iniciarComponentes();
		setLocationRelativeTo(null);
		mvn_Flappy = new MvnFlappy(this);
		mvn_Tubos = new MvnTubos(this);
		posicionFlappy=jFlappy.getLocation();
		this.jPanel1.setSize(400,600);
		mvn_Flappy.start();
		mvn_Tubos.start();
	}

}
