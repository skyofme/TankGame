package entity;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;
import java.util.Vector;

import com.etc.TankClient;

import var.WallVar;
import idao.WallIDao;

public class CommonWall extends Wall{
	
	public CommonWall(int x, int y,TankClient tc){
		this.setX(x);
		this.setY(y);
		this.setLife(1);
		this.setWIDTH(30);
		this.setHEIGHT(30);
		this.setTc(tc);
	}
	public CommonWall(){}
	public void draw(Graphics g){
		List<CommonWall> cws = TankClient.cws;
		CommonWall cw = null;
				//»­³öÆÕÍ¨Ç½
				for(int i=0;i<cws.size();i++){
					cw = cws.get(i);
					
					if(cw.getLife()>=1){
						g.drawImage(imgs.get("C"), cw.getX(), cw.getY(),cw.getWIDTH(),cw.getHEIGHT(), null);
					}
					if(cw.getLife()==0){
						cws.remove(cw);
					}
				}
	}
	public Rectangle getRect() {
		return new Rectangle(this.getX(),this.getY(), this.getWIDTH(), this.getHEIGHT());
	}
	@Override
	public void construct() {
		// TODO Auto-generated method stub
		List<CommonWall> cws = TankClient.cws;
		CommonWall cw = null;
		TankClient tc = new TankClient();
		for(int j=0;j<4;j++){
			cw = new CommonWall(j*30,570,tc);
			cws.add(cw);
		}
		for(int j=0;j<4;j++){
			cw = new CommonWall(j*30,540,tc);
			cws.add(cw);
		}
		for(int j=0;j<2;j++){
			cw = new CommonWall(j*30,510,tc);
			cws.add(cw);
		}
		for(int j=0;j<2;j++){
			cw = new CommonWall(j*30,480,tc);
			cws.add(cw);
		}
		for(int j=0;j<2;j++){
			cw = new CommonWall(j*30+180,570,tc);
			cws.add(cw);
		}
		for(int j=0;j<2;j++){
			cw = new CommonWall(j*30+180,540,tc);
			cws.add(cw);
		}
		for(int j=0;j<3;j++){
			cw = new CommonWall(340,600-(j+1)*30,tc);
			cws.add(cw);
		}
		for(int j=0;j<3;j++){
			cw = new CommonWall(j*30+370,510,tc);
			cws.add(cw);
		}
		for(int j=0;j<2;j++){
			cw = new CommonWall(430,600-(j+1)*30,tc);
			cws.add(cw);
		}
		for(int j=0;j<6;j++){
			cw = new CommonWall(j*30+560,570,tc);
			cws.add(cw);
		}
		for(int j=0;j<6;j++){
			cw = new CommonWall(j*30+560,540,tc);
			cws.add(cw);
		}
		for(int j=0;j<2;j++){
			cw = new CommonWall(j*30+560,510,tc);
			cws.add(cw);
		}
		for(int j=0;j<2;j++){
			cw = new CommonWall(j*30+680,510,tc);
			cws.add(cw);
		}
		for(int j=0;j<2;j++){
			cw = new CommonWall(430,j*30+60,tc);
		//	cw.setCws(cws);
			cws.add(cw);
		}
		for(int j=0;j<2;j++){
			cw = new CommonWall(460,j*30+60,tc);
		//	cw.setCws(cws);
			cws.add(cw);
		}
		for(int j=0;j<2;j++){
			cw = new CommonWall(560,j*30+60,tc);
		//	cw.setCws(cws);
			cws.add(cw);
		}
		for(int j=0;j<2;j++){
			cw = new CommonWall(590,j*30+60,tc);
		//	cw.setCws(cws);
			cws.add(cw);
		}
		for(int j=0;j<2;j++){
			cw = new CommonWall(680,j*30+60,tc);
			cws.add(cw);
		}
		for(int j=0;j<2;j++){
			cw = new CommonWall(710,j*30+60,tc);
			cws.add(cw);
		}
		for(int j=0;j<3;j++){
			cw = new CommonWall(60,j*30+60,tc);
			cws.add(cw);
		}
		for(int j=0;j<3;j++){
			cw = new CommonWall(90,j*30+60,tc);
			cws.add(cw);
		}
		for(int j=0;j<8;j++){
			cw = new CommonWall(j*30+60,270,tc);
			cws.add(cw);
		}
		for(int j=0;j<8;j++){
			cw = new CommonWall(j*30+60,300,tc);
			cws.add(cw);
		}
		for(int j=0;j<6;j++){
			cw = new CommonWall(j*30+180,210,tc);
			cws.add(cw);
		}
		for(int j=0;j<6;j++){
			cw = new CommonWall(j*30+180,240,tc);
			cws.add(cw);
		}
		
		for(int j=0;j<3;j++){
			cw = new CommonWall(60,600+j*30-210,tc);
			cws.add(cw);
		}
		for(int j=0;j<3;j++){
			cw = new CommonWall(90,600+j*30-210,tc);
			cws.add(cw);
		}
		for(int j=0;j<4;j++){
			cw = new CommonWall(300,330+j*30,tc);
			cws.add(cw);
		}
		for(int j=0;j<4;j++){
			cw = new CommonWall(330,330+j*30,tc);
			cws.add(cw);
		}
		for(int j=0;j<2;j++){
			cw = new CommonWall(360,390+j*30,tc);
			cws.add(cw);
		}
		for(int j=0;j<2;j++){
			cw = new CommonWall(390,390+j*30,tc);
			cws.add(cw);
		}
		for(int j=0;j<4;j++){
			cw = new CommonWall(420,330+j*30,tc);
			//cw.setCws(cws);
			cws.add(cw);
		}
		for(int j=0;j<4;j++){
			cw = new CommonWall(450,330+j*30,tc);
			//cw.setCws(cws);
			cws.add(cw);
		}
		for(int j=0;j<3;j++){
			cw = new CommonWall(180,390+j*30,tc);
			//cw.setCws(cws);
			cws.add(cw);
		}
		for(int j=0;j<3;j++){
			cw = new CommonWall(210,390+j*30,tc);
			//cw.setCws(cws);
			cws.add(cw);
		}
		for(int j=0;j<2;j++){
			cw = new CommonWall(300+j*30,180,tc);
			cws.add(cw);
		}
		for(int j=0;j<2;j++){
			cw = new CommonWall(180+j*30,180,tc);
			cws.add(cw);
		}
		for(int j=0;j<2;j++){
			cw = new CommonWall(480+j*30,270,tc);
			cws.add(cw);
		}
		for(int j=0;j<2;j++){
			cw = new CommonWall(480+j*30,300,tc);
			cws.add(cw);
		}
		for(int j=0;j<5;j++){
			cw = new CommonWall(540,210+j*30,tc);
			cws.add(cw);
		}
		for(int j=0;j<5;j++){
			cw = new CommonWall(570,210+j*30,tc);
			cws.add(cw);
		}
		for(int j=0;j<2;j++){
			cw = new CommonWall(540+j*30,420,tc);
			cws.add(cw);
		}
		for(int j=0;j<6;j++){
			cw = new CommonWall(680,270+j*30,tc);
			cws.add(cw);
		}
		for(int j=0;j<6;j++){
			cw = new CommonWall(710,270+j*30,tc);
			cws.add(cw);
		}
		for(int j=0;j<2;j++){
			cw = new CommonWall(540+j*30,180,tc);
			cws.add(cw);
		}
		for(int j=0;j<2;j++){
			cw = new CommonWall(680+j*30,180,tc);
			cws.add(cw);
		}
		for(int j=0;j<2;j++){
			cw = new CommonWall(740+j*30,120,tc);
			cws.add(cw);
		}
		TankClient.cws = cws;
	}
}
