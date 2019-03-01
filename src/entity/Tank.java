package entity;


import idao.TankIDao;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import var.TankVar;

import com.etc.Direction;
import com.etc.MusicPlayer;
import com.etc.TankClient;

public class Tank extends TankVar implements TankIDao {
	
	private BloodBar bb = new BloodBar();
	private static Random r = new Random();
	private int step = r.nextInt(12) + 3;
	
	
	
	public Tank(int x, int y, boolean good) {
		this.setX(x);
		this.setY(y);
		this.setoOldX(x);
		this.setoOldY(y);
		this.setOldX(x);
		this.setOldY(y);
		this.setGood(good);
	}
	
	public Tank(int x, int y, boolean good, int player,Direction dir,  TankClient tc) {
		
		this.setX(x);
		this.setY(y);
		this.setoOldX(x);
		this.setoOldY(y);
		this.setOldX(x);
		this.setOldY(y);
		this.setGood(good);
		this.setPlayer(player);
		this.setDir(dir);
		this.setTc(tc);
		this.setPtDir(Direction.U);
	}
	
	public void draw(Graphics g) {
		if(!this.isLive()) {
			if(!this.isGood()) {
				this.getTc().tanks.remove(this);
			}
			return;
		}
		
		if(this.isGood()) this.drawBloodBar(g);
		if(this.getPlayer()==0){
			switch(this.getPtDir()) {
			case L:
				g.drawImage(imgs.get("0L"), this.getX(), this.getY(),this.getWidth(),this.getHeight(), null);
				break;
			
			case U:
				g.drawImage(imgs.get("0U"), this.getX(), this.getY(),this.getWidth(),this.getHeight(), null);
				break;
			
			case R:
				g.drawImage(imgs.get("0R"), this.getX(), this.getY(),this.getWidth(),this.getHeight(), null);
				break;
			
			case D:
				g.drawImage(imgs.get("0D"), this.getX(), this.getY(),this.getWidth(),this.getHeight(), null);
				break;
			}
		}
		else if(this.getPlayer()==1){
			switch(this.getPtDir()) {
			case L:
				g.drawImage(imgs.get("1L"), this.getX(), this.getY(),this.getWidth(),this.getHeight(), null);
				break;
				
			case U:
				g.drawImage(imgs.get("1U"), this.getX(), this.getY(),this.getWidth(),this.getHeight(), null);
				break;
				
			case R:
				g.drawImage(imgs.get("1R"), this.getX(), this.getY(),this.getWidth(),this.getHeight(), null);
				break;
				
			case D:
				g.drawImage(imgs.get("1D"), this.getX(), this.getY(),this.getWidth(),this.getHeight(), null);
				break;
			}
		}
		else if(this.getPlayer()==2){
			switch(this.getPtDir()) {
			case L:
				g.drawImage(imgs.get("2L"), this.getX(), this.getY(),this.getWidth(),this.getHeight(), null);
				break;
				
			case U:
				g.drawImage(imgs.get("2U"), this.getX(), this.getY(),this.getWidth(),this.getHeight(), null);
				break;
				
			case R:
				g.drawImage(imgs.get("2R"), this.getX(), this.getY(),this.getWidth(),this.getHeight(), null);
				break;
				
			case D:
				g.drawImage(imgs.get("2D"), this.getX(), this.getY(),this.getWidth(),this.getHeight(), null);
				break;
			}
		}
		if(this.getTc().a%2==0){
			move();
		}
	}
	
	public void move() {
		this.setOldX(this.getX());
		this.setOldY(this.getY());
		switch(this.getDir()) {
		case L:
			this.setX(this.getX()-this.getXSPEED());
			break;
		
		case U:
			this.setY(this.getY()-this.getYSPEED());
			break;
		
		case R:
			this.setX(this.getX()+this.getXSPEED());
			break;
		
		case D:
			this.setY(this.getY()+this.getYSPEED());
			break;
		
		case STOP:
			break;
		}
		if(this.getDir() != Direction.STOP) {
			this.setPtDir(this.getDir());
		}
		if(this.getX() < -4) this.setX(-4);
		if(this.getY() < 20) this.setY(20);
		if(this.getX() + Tank.getWidth()  > TankClient.GAME_WIDTH) this.setX(TankClient.GAME_WIDTH - Tank.getWidth());
		if(this.getY() + Tank.getHeight()  > TankClient.GAME_HEIGHT) this.setY(TankClient.GAME_HEIGHT - Tank.getHeight());
		if(!this.isGood()) {
			Direction[] dirs = Direction.values();
			if(step == 0) {
				step = r.nextInt(12) + 3;
				int rn = r.nextInt(dirs.length);
				this.setDir(dirs[rn]);
				}			
			step --;
			
			if(r.nextInt(40) > 38) this.fire();
		}		
	}
	public void stay() {
		this.setX(this.getOldX());
		this.setY(this.getOldY());
	}
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(this.getPlayer()==1){
			switch(key) {
			case KeyEvent.VK_F2 :
				//if(!this.isLive()) {
					this.getTc().explodes.clear();
					this.getTc().missiles.clear();
					this.getTc().tanks.clear();
					this.getTc().cws.clear();
					this.getTc().mws.clear();
					this.getTc().grs.clear();
					this.getTc().was.clear();
					this.getTc().myTanks.clear();
					this.getTc().construct(this.getTc().p);
					this.setLive(true);
					this.setLife(100);
				//}
				break;
			case KeyEvent.VK_LEFT :
				this.setbL(true);
				break;
			case KeyEvent.VK_UP :
				this.setbU(true);
				break;
			case KeyEvent.VK_RIGHT :
				this.setbR(true);
				break;
			case KeyEvent.VK_DOWN :
				this.setbD(true);
				break;
			case KeyEvent.VK_SPACE :
				this.getTc().a += 1;
				break;
			}
			locateDirection();
		}
		if(this.getPlayer()==2){
			switch(key) {
			case KeyEvent.VK_F3 :
				if(!this.isLive()) {
					this.setLive(true);
					this.setLife(100);
				}
				break;
			case KeyEvent.VK_A :
				this.setbL(true);
				break;
			case KeyEvent.VK_W :
				this.setbU(true);
				break;
			case KeyEvent.VK_D :
				this.setbR(true);
				break;
			case KeyEvent.VK_S :
				this.setbD(true);
				break;
			}
			locateDirection();
		}
	}
	
	public void locateDirection() {
		if(this.isbL() && !this.isbU() && !this.isbR() && !this.isbD()) this.setDir(Direction.L);
		else if(!this.isbL() && this.isbU() && !this.isbR() && !this.isbD()) this.setDir(Direction.U);
		else if(!this.isbL() && !this.isbU() && this.isbR() && !this.isbD()) this.setDir(Direction.R);
		else if(!this.isbL() && !this.isbU() && !this.isbR() && this.isbD()) this.setDir(Direction.D);
		else if(!this.isbL() && !this.isbU() && !this.isbR() && !this.isbD()) this.setDir(Direction.STOP);
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if(this.getPlayer()==1){
			switch(key) {
			case KeyEvent.VK_J:
					fire();
				break;
			case KeyEvent.VK_LEFT :
				this.setbL(false);
				break;
			case KeyEvent.VK_UP :
				this.setbU(false);
				break;
			case KeyEvent.VK_RIGHT :
				this.setbR(false);
				break;
			case KeyEvent.VK_DOWN :
				this.setbD(false);
				break;
			}
			locateDirection();	
		}
		if(this.getPlayer()==2){
			switch(key) {
			case KeyEvent.VK_F:
				fire();
				break;
			case KeyEvent.VK_A :
				this.setbL(false);
				break;
			case KeyEvent.VK_W :
				this.setbU(false);
				break;
			case KeyEvent.VK_D :
				this.setbR(false);
				break;
			case KeyEvent.VK_S :
				this.setbD(false);
				break;
				
			}
			locateDirection();	
		}
	}
	
	public Missile fire() {
		AePlayWave apw =new AePlayWave("Music/Fire Music.wav");
		apw.start();
		if(!this.isLive()) return null;
		int x = this.getX() + Tank.getWIDTH()/2 - Missile.WIDTH/2;
		int y = this.getY() + Tank.getHEIGHT()/2 - Missile.HEIGHT/2;
		Missile m = new Missile(x, y, this.isGood(), this.getPtDir(), this.getTc());
		this.getTc().missiles.add(m);
		return m;
	}
	
	public Missile fire(Direction dir) {
		if(!this.isLive()) return null;
		int x = this.getX() + Tank.getWIDTH()/2 - Missile.WIDTH/2;
		int y = this.getY() + Tank.getHEIGHT()/2 - Missile.HEIGHT/2;
		Missile m = new Missile(x, y, this.isGood(), this.getDir(), this.getTc());
		this.getTc().missiles.add(m);
		return m;
	}
	public Rectangle getRect() {
		return new Rectangle(this.getX(), this.getY(), this.getWidth(), this.getHeight());
	}

	/**
	 * 撞墙
	 * @param w 被撞的墙
	 * @return 撞上了返回true，否则false
	 */

	public boolean collidesWithTanks(java.util.List<Tank> tanks) {
		for(int i=0; i<tanks.size(); i++) {
			Tank t = tanks.get(i);
			if(this != t) {
				if(this.isLive() && t.isLive() && this.getRect().intersects(t.getRect())) {
					this.stay();
					t.stay();
					return true;
				}
			}
		}
		return false;
	}
	public void superFire() {
		Direction[] dirs = Direction.values();
		for(int i=0; i<3; i++) {
			this.fire(dirs[i]);
		}
	}
	//血条
	class BloodBar{
		
	}
	public void drawBloodBar(Graphics g){
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.drawRect(this.getX()+5, this.getY()-10, this.getWidth()-10, 10);
		int w = (this.getWidth()-10) * this.getLife()/100 ;
		g.fillRect(this.getX()+5, this.getY()-10, w, 10);
		g.setColor(c);
	}
	public boolean eat(Blood b) {
		if(this.isLive() && b.isLive() && this.getRect().intersects(b.getRect())) {
			if(b.getType()==0){
				this.setLife(100);
				this.getTc().phNum++;
				b.setLive(false);
			}else if(b.getType()==1){
				for(int i=0;i<this.getTc().tanks.size();i++){
					this.getTc().q++;
					this.getTc().t--;
					Explode e = new Explode(this.getTc().tanks.get(i).getX(),this.getTc().tanks.get(i).getY(), this.getTc());
					this.getTc().explodes.add(e);
					if(this.getTc().t<=0){
						this.getTc().tanks.get(i).setLive(false);
					}else{
						this.getTc().tanks.get(i).setX(this.getTc().tanks.get(i).getoOldX());
						this.getTc().tanks.get(i).setY(this.getTc().tanks.get(i).getoOldY());
					}
				}
				b.setLive(false);
				this.getTc().bombNum++;
			}else if(b.getType()==2){
				b.setLive(false);
				this.getTc().starNum++;
			}else if(b.getType()==3){
				b.setLive(false);
				this.getTc().time = true;
				this.getTc().timerNum++;
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean collidesWithWall(List<CommonWall> cws,List<MetalWall> mws,List<Water> was) {
		for(int i=0; i<cws.size(); i++) {
			CommonWall cw = cws.get(i);
				if(this.isLive() && cw.getLife()>=0 && this.getRect().intersects(cw.getRect())) {
					this.stay();
					return true;
				}
			}
		for(int i=0; i<mws.size(); i++) {
			MetalWall mw = mws.get(i);
			if(this.isLive() && mw.getLife()>=0 && this.getRect().intersects(mw.getRect())) {
				this.stay();
				return true;
			}
		}
		for(int i=0; i<was.size(); i++) {
			Water water = was.get(i);
			if(this.isLive() && water.getLife()>=0 && this.getRect().intersects(water.getRect())) {
				this.stay();
				return true;
			}
		}
		
		return false;
	}
	
	
}