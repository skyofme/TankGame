package var;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.Map;

import com.etc.TankClient;

import entity.Tank;

public class BloodVar {
	private int x, y, w, h;
	private int WIDTH = 30;
	private int HEIGHT = 30;
	private int type = 0;
	public int getHEIGHT() {
		return HEIGHT;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public void setHEIGHT(int hEIGHT) {
		HEIGHT = hEIGHT;
	}

	public int getWIDTH() {
		return WIDTH;
	}
	public void setWIDTH(int wIDTH) {
		WIDTH = wIDTH;
	}

	private TankClient tc; 
	private  int Life = 1000;
	
	private static Toolkit tk = Toolkit.getDefaultToolkit();
	private static Image[] tankImages = null;
	protected static Map<String, Image> imgs = new HashMap<String, Image>();
	static {
		tankImages = new Image[] {
				tk.getImage(Tank.class.getClassLoader().getResource("images/hp.png")),
				tk.getImage(Tank.class.getClassLoader().getResource("images/bomb.gif")),
				tk.getImage(Tank.class.getClassLoader().getResource("images/star.gif")),
				tk.getImage(Tank.class.getClassLoader().getResource("images/timer.gif")),
				
		};
		
		imgs.put("HP", tankImages[0]);
		imgs.put("BOMB", tankImages[1]);
		imgs.put("STAR", tankImages[2]);
		imgs.put("TIMER", tankImages[3]);
		
	}
	public int getLife() {
		return Life;
	}
	public void setLife(int life) {
		Life = life;
	}

	private boolean live = true;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	public TankClient getTc() {
		return tc;
	}
	public void setTc(TankClient tc) {
		this.tc = tc;
	}
	
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
}
