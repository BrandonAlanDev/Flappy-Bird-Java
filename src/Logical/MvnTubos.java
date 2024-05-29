package Logical;

import java.awt.Point;

public class MvnTubos extends Thread {
	private int tbn1;
	private int tbn2;
	private Point pos1;
	private Point pos2;
	private Principal pr;
	private int velocidad;
	public MvnTubos(Principal n_pr) {
		this.pr=n_pr;
		velocidad=7;
	}
	public int numeroAleatorio() {
		return (int)(Math.random()*(0-(-200))+200);
	}
	@Override
	public void run() {
		pos1=pr.JTubo_arriba1.getLocation();
		pos2=pr.JTubo_arriba2.getLocation();
		tbn1=pos1.x;
		tbn2=pos2.x;
		while(true) {
			try {
				Thread.sleep(velocidad);
				tbn1--;
				tbn2--;
				pr.JTubo_abajo1.setLocation(tbn1,pos1.y+450);
				pr.JTubo_arriba1.setLocation(tbn1,pos1.y);
				pr.JTubo_abajo2.setLocation(tbn2,pos2.y+450);
				pr.JTubo_arriba2.setLocation(tbn2,pos2.y);
				if((pr.colision(pr.JTubo_arriba1)||pr.colision(pr.JTubo_abajo1))||(pr.colision(pr.JTubo_arriba2)||pr.colision(pr.JTubo_abajo2))) {
					System.out.println("Choque");
				}
				if(tbn1<=-51) {
					pos1.y=numeroAleatorio();
					tbn1=425;
				}
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}
