package entity;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;
import java.util.Vector;

import com.etc.TankClient;

import idao.WallIDao;
import var.WallVar;

public class Grass extends Wall {

	public Grass(int x, int y,TankClient tc){
		this.setX(x);
		this.setY(y);
		this.setTc(tc);
		this.setWIDTH(30);
		this.setHEIGHT(30);
	}
	public Grass(){}
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		List<Grass> grs = TankClient.grs;
		Grass grass = null;
		//画出草地
		for(int i=0;i<grs.size();i++){
			grass = grs.get(i);
			g.drawImage(imgs.get("T"), grass.getX(), grass.getY(),grass.getWIDTH(),grass.getHEIGHT(), null);
		}	
	}
	@Override
	public Rectangle getRect() {
		// TODO Auto-generated method stub
		return new Rectangle(this.getX(),this.getY(), this.getWIDTH(), this.getHEIGHT());
	}
	public void construct(){
		List<Grass> grs = TankClient.grs;
		Grass grass = null;
		TankClient tc = new TankClient();
		//tree创建
				for(int i=0;i<7;i++){
					grass = new Grass(0,i*30+60,tc);
					grs.add(grass);
				}
				for(int i=0;i<7;i++){
					grass = new Grass(30,i*30+60,tc);
					grs.add(grass);
				}
				for(int i=0;i<2;i++){
					grass = new Grass(i*30+60,210,tc);
					grs.add(grass);
				}
				for(int i=0;i<2;i++){
					grass = new Grass(i*30+60,240,tc);
					grs.add(grass);
				}
				for(int i=0;i<2;i++){
					grass = new Grass(i*30,450,tc);
					grs.add(grass);
				}
				for(int i=0;i<2;i++){
					grass = new Grass(240+i*30,330,tc);
					grs.add(grass);
				}
				for(int i=0;i<4;i++){
					grass = new Grass(300+i*30,270,tc);
					grs.add(grass);
				}
				for(int i=0;i<4;i++){
					grass = new Grass(300+i*30,300,tc);
					grs.add(grass);
				}
				for(int i=0;i<6;i++){
					grass = new Grass(180+i*30,150,tc);
					grs.add(grass);
				}
				for(int i=0;i<6;i++){
					grass = new Grass(180+i*30,120,tc);
					grs.add(grass);
				}
				for(int i=0;i<3;i++){
					grass = new Grass(660,360+i*30,tc);
					grs.add(grass);
				}
				for(int i=0;i<6;i++){
					grass = new Grass(600,180+i*30,tc);
					grs.add(grass);
				}
				for(int i=0;i<2;i++){
					grass = new Grass(540,60+i*30,tc);
					grs.add(grass);
				}
				TankClient.grs = grs;
	}

}
