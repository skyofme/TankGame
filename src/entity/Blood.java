package entity;
import idao.BloodIDao;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;
import java.util.Random;

import var.BloodVar;

public class Blood extends BloodVar implements BloodIDao{
	private static Random r = new Random();
	int RandomX = 0;
	int RandomY = 0;
	int RandomType = 0;
	public Blood(){
		RandomX = r.nextInt(770);
		RandomY = r.nextInt(540)+30;
		RandomType = r.nextInt(100)%4;
		this.setX(RandomX);
		this.setY(RandomY);
		this.setType(RandomType);
	}
	public void BloodConstruct(){
		RandomX = r.nextInt(770);
		RandomY = r.nextInt(540);
		RandomType = r.nextInt(100)%4;
		this.setX(RandomX);
		this.setY(RandomY);
		this.setType(RandomType);
	}
	public void draw(Graphics g) {
		if(this.isLive()==true&&this.getLife()>0){
			switch(this.getType()){
			case 0:
				g.drawImage(imgs.get("HP"), this.getX(), this.getY(),this.getWIDTH(),this.getHEIGHT(), null);
				break;
			case 1:
				g.drawImage(imgs.get("BOMB"), this.getX(), this.getY(),this.getWIDTH(),this.getHEIGHT(), null);
				break;
			case 2:
				g.drawImage(imgs.get("STAR"), this.getX(), this.getY(),this.getWIDTH(),this.getHEIGHT(), null);
				break;
			case 3:
				g.drawImage(imgs.get("TIMER"), this.getX(), this.getY(),this.getWIDTH(),this.getHEIGHT(), null);
				break;
			}
		}
	}
	public boolean Location(List<Water> was,Home home){
		int i=0;
		while(true){
			for(i=0;i<was.size();i++){
				if(this.getRect().intersects(was.get(i).getRect())&&this.getRect().intersects(home.getRect())){
					break;
				}
				else{
					continue;
				}
			}
			if(i==was.size()){
				break;
			}else{
				RandomX = r.nextInt(770);
				RandomY = r.nextInt(540)+30;
				RandomType = r.nextInt(100)%4;
				this.setX(RandomX);
				this.setY(RandomY);
				this.setType(RandomType);
			}
		}
		
		return true;
		
	}
	public Rectangle getRect() {
		return new Rectangle(this.getX(), this.getY(), this.getWIDTH() , this.getHEIGHT());
	}
}
