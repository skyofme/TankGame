package entity;
import idao.MissileIDao;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import var.MissileVar;

import com.etc.Direction;
import com.etc.TankClient;

public class Missile extends MissileVar implements MissileIDao{

	
	public Missile(int x, int y, Direction dir) {
		this.setX(x);
		this.setY(y);
		this.setDir(dir);
	}
	
	public Missile(int x, int y, boolean good, Direction dir, TankClient tc) {
		this.setX(x);
		this.setY(y);
		this.setDir(dir);
		this.setGood(good);
		this.setTc(tc);
	}

	
	public void draw(Graphics g) {
		if(!this.isLive()) {
			this.getTc().missiles.remove(this);
			return;
		}
		
		switch(this.getDir()) {
		case L:
			g.drawImage(imgs.get("L"),this.getX(),this.getY(), null);
			break;
		
		case U:
			g.drawImage(imgs.get("U"),this.getX(),this.getY(), null);
			break;
		
		case R:
			g.drawImage(imgs.get("R"),this.getX(),this.getY(), null);
			break;
		
		case D:
			g.drawImage(imgs.get("D"),this.getX(),this.getY(), null);
			break;
		
		}
		
		
	}

	public void move() {
		
		
		switch(this.getDir()) {
		case L:
			this.setX(this.getX()-XSPEED);
			break;
		
		case U:
			this.setY(this.getY()-YSPEED);
			break;
		
		case R:
			this.setX(this.getX()+XSPEED);
			break;
		
		case D:
			this.setY(this.getY()+YSPEED);
			break;
		
		case STOP:
			break;
		}
		
		if(this.getX() < 0 || this.getY() < 0 || this.getX() > TankClient.GAME_WIDTH || this.getY() > TankClient.GAME_HEIGHT) {
			this.setLive(false);
		}		
	}
	public Rectangle getRect() {
		return new Rectangle(this.getX(), this.getY(), WIDTH, HEIGHT);
	}
	
	public boolean hitTank(Tank t) {
		if(this.isLive() && this.getRect().intersects(t.getRect()) && t.isLive() && this.isGood() != t.isGood()) {
			if(t.isGood()) {
				t.setLife(t.getLife()-20);
				if(t.getLife() <= 0){
					if(this.getTc().m<=0){
						t.setLive(false);
					}else{
						this.getTc().m--;
						t.setX(300);
						t.setY(560);
						t.setLife(100);
						t.setDir(Direction.STOP);
					}
				}
				
			} else {
				this.getTc().q++;
				this.getTc().t--;
				this.getTc().b.BloodConstruct();
				this.getTc().b.setLife(1000);
				this.getTc().b.setLive(true);
				if(this.getTc().t<=0){
					t.setLive(false);
				}else{
					t.setX(t.getoOldX());
					t.setY(t.getoOldY());
				}
			}
			
			this.setLive(false);
			Explode e = new Explode(this.getX(), this.getY(), this.getTc());
			this.getTc().explodes.add(e);
			return true;
		}
		return false;
	}
	
	public boolean hitTanks(List<Tank> tanks) {
		for(int i=0; i<tanks.size(); i++) {
			if(hitTank(tanks.get(i))) {
				return true;
			}
		}
		return false;
	}
	public boolean hitWalls(List<CommonWall> cws,List<MetalWall> mws,Home home) {
		CommonWall cw = null;
		MetalWall mw = null;
		for(int i=0; i<cws.size(); i++) {
			cw = cws.get(i);
			if(this.isLive() && this.getRect().intersects(cw.getRect())) {
				cw.setLife(cw.getLife()-1);
				Explode e = new Explode(this.getX()-15, this.getY(), this.getTc());
				this.getTc().explodes.add(e);
				this.setLive(false);
				if(cw.getLife()<=0){
					cws.remove(i);
				}
			}
		}
		for(int i=0; i<mws.size(); i++) {
			mw = mws.get(i);
			if(this.isLive() && this.getRect().intersects(mw.getRect())) {
				mw.setLife(mw.getLife()-1);
				Explode e = new Explode(this.getX()-15, this.getY(), this.getTc());
				this.getTc().explodes.add(e);
				this.setLive(false);
				if(mw.getLife()<=0){
					mws.remove(i);
				}
			}
		}
		if(this.isLive() && this.getRect().intersects(home.getRect())) {
			home.setLife(home.getLife()-1);
			this.setLive(false);
			home.setLife(home.getLife()-1);
			}
		return false;
	}
	public boolean hitMissile(List<Missile> missiles){
		for(int i=0;i<missiles.size();i++){
			if(missiles.get(i)!=this){
				if(this.isLive() && this.getRect().intersects(missiles.get(i).getRect())){
					this.setLive(false);
					missiles.get(i).setLive(false);
					return true;
				}
			}
		}
		return false;
	}
}
