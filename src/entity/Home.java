package entity;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.etc.TankClient;

import idao.WallIDao;
import var.WallVar;

public class Home extends Wall{

	public Home(int x, int y,TankClient tc){
		this.setX(x);
		this.setY(y);
		this.setTc(tc);
		this.setWIDTH(60);
		this.setHEIGHT(60);
	}
	public Home(){}
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		if(this.getLife()>0){
			g.drawImage(imgs.get("H"), this.getX(), this.getY(),60,60, null);
		}else{
			System.out.println("0000");
			g.drawImage(imgs.get("B"), this.getX(), this.getY(),60,60, null);
			this.setLife(this.getLife()-1);
		}
	}

	@Override
	public Rectangle getRect() {
		// TODO Auto-generated method stub
		return new Rectangle(this.getX(),this.getY(), this.getWIDTH(), this.getHEIGHT());
	}
	@Override
	public void construct() {
		
	}

}
