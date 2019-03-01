package entity;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;
import java.util.Vector;

import com.etc.TankClient;

import idao.WallIDao;
import var.WallVar;

public class Water extends Wall{
	
	public Water(int x, int y,TankClient tc){
		this.setX(x);
		this.setY(y);
		this.setTc(tc);
		this.setWIDTH(30);
		this.setHEIGHT(30);
	}
	public Water(){}
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		List<Water> wat = TankClient.was;
		Water water = null;
	//画出水
				//画出水
				for(int i=0;i<wat.size();i++){
					water = wat.get(i);
					g.drawImage(imgs.get("R"), water.getX(), water.getY(),water.getWIDTH(),water.getHEIGHT(), null);
				}
	}

	@Override
	public Rectangle getRect() {
		// TODO Auto-generated method stub
		return new Rectangle(this.getX(),this.getY(), this.getWIDTH(), this.getHEIGHT());
	}
	@Override
	public void construct() {
		// TODO Auto-generated method stub
		List<Water> was = TankClient.was;
		Water water = null;
		TankClient tc = new TankClient();
		for(int i=0;i<2;i++){
			water = new Water(i*30,420,tc);
			was.add(water);
		}
		for(int i=0;i<4;i++){
			water = new Water(540+i*30,360,tc);
			was.add(water);
		}
		for(int i=0;i<4;i++){
			water = new Water(540+i*30,390,tc);
			was.add(water);
		}
		for(int i=0;i<6;i++){
			water = new Water(740,360+i*30,tc);
			was.add(water);
		}
		for(int i=0;i<6;i++){
			water = new Water(770,360+i*30,tc);
			was.add(water);
		}
		TankClient.was = was;
	}

}
