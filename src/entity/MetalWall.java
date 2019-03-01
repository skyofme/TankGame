package entity;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;
import java.util.Vector;

import idao.WallIDao;
import var.WallVar;

import com.etc.TankClient;

public class MetalWall extends Wall{
	public MetalWall(int x, int y,TankClient tc){
		this.setX(x);
		this.setY(y);
		this.setLife(5);
		this.setTc(tc);
		this.setWIDTH(30);
		this.setHEIGHT(30);
	}
	public MetalWall(){}
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		List<MetalWall> mws = TankClient.mws;
		MetalWall mw = null;
				//»­³öÌúÇ½
				for(int i=0;i<mws.size();i++){
					mw = mws.get(i);
					
					if(mw.getLife()>=1){
						g.drawImage(imgs.get("M"), mw.getX(), mw.getY(),mw.getWIDTH(),mw.getHEIGHT(), null);
					}
					if(mw.getLife()==0){
						mws.remove(mw);
					}
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
		List<MetalWall> mws = TankClient.mws;
		MetalWall mw = null;
		TankClient tc = new TankClient();
		
		for(int j = 0;j<4;j++){
			mw = new MetalWall(180,j*30,tc);
			mws.add(mw); 
		}
		for(int j = 0;j<4;j++){
			mw = new MetalWall(210,j*30,tc);
			mws.add(mw); 
		}
		for(int j = 0;j<2;j++){
			mw = new MetalWall(430,j*30,tc);
			mws.add(mw); 
		}
		for(int j = 0;j<2;j++){
			mw = new MetalWall(460,j*30,tc);
			mws.add(mw); 
		}
		for(int j = 0;j<2;j++){
			mw = new MetalWall(j*30,390,tc);
			mws.add(mw); 
		}
		for(int j = 0;j<2;j++){
			mw = new MetalWall(180+j*30,330,tc);
			mws.add(mw); 
		}
		for(int j = 0;j<2;j++){
			mw = new MetalWall(180+j*30,360,tc);
			mws.add(mw); 
		}
		for(int j = 0;j<2;j++){
			mw = new MetalWall(420+j*30,270,tc);
			mws.add(mw); 
		}
		for(int j = 0;j<2;j++){
			mw = new MetalWall(420+j*30,300,tc);
			mws.add(mw); 
		}
		for(int j = 0;j<2;j++){
			mw = new MetalWall(480+j*30,240,tc);
			mws.add(mw); 
		}
		for(int j = 0;j<2;j++){
			mw = new MetalWall(600+j*30,420,tc);
			mws.add(mw); 
		}
		for(int j = 0;j<2;j++){
			mw = new MetalWall(540+j*30,150,tc);
			mws.add(mw); 
		}
		for(int j = 0;j<2;j++){
			mw = new MetalWall(540+j*30,120,tc);
			mws.add(mw); 
		}
		for(int j = 0;j<2;j++){
			mw = new MetalWall(740+j*30,180,tc);
			mws.add(mw); 
		}
		for(int j = 0;j<2;j++){
			mw = new MetalWall(740+j*30,150,tc);
			mws.add(mw); 
		}
		TankClient.mws = mws;
	}
}
