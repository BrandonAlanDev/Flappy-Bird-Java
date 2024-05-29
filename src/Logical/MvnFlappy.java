package Logical;

import java.awt.Point;

public class MvnFlappy extends Thread {
	private Principal pr;
	private boolean saltar;
	public boolean isSaltar() {
		return saltar;
	}
	public void setSaltar(boolean s_saltar) {
		this.saltar=s_saltar;
	}
	public MvnFlappy(Principal n_pr) {
		this.pr=n_pr;
	}
	@Override
	public void run() {
		while(true) {
			if(saltar) {
				Point pos=pr.jFlappy.getLocation();
				try {
					Thread.sleep(20);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
				pos.y-=10;
				pr.jFlappy.setLocation(pos);
			} else{
				Point pos=pr.jFlappy.getLocation();
				try {
					Thread.sleep(20);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
				pos.y+=5;
				pr.jFlappy.setLocation(pos);
			}
		}
	}
}
