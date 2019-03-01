package var;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.Map;

import com.etc.TankClient;

import entity.Tank;

public class WallVar {
	private int x, y;
	private boolean live=true;
	private int life = 1;
	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}
	public static Toolkit getTk() {
		return tk;
	}
	public static void setTk(Toolkit tk) {
		WallVar.tk = tk;
	}
	public static Image[] getTankImages() {
		return tankImages;
	}
	public static void setTankImages(Image[] tankImages) {
		WallVar.tankImages = tankImages;
	}
	public static Map<String, Image> getImgs() {
		return imgs;
	}
	public static void setImgs(Map<String, Image> imgs) {
		WallVar.imgs = imgs;
	}
	
	
	private   int WIDTH = 30;
	private   int HEIGHT = 30;
	
	public int getWIDTH() {
		return WIDTH;
	}
	public void setWIDTH(int wIDTH) {
		WIDTH = wIDTH;
	}
	public int getHEIGHT() {
		return HEIGHT;
	}
	public void setHEIGHT(int hEIGHT) {
		HEIGHT = hEIGHT;
	}


	TankClient tc ;
	
	private static Toolkit tk = Toolkit.getDefaultToolkit();
	private static Image[] tankImages = null;
	protected static Map<String, Image> imgs = new HashMap<String, Image>();
	static {
		tankImages = new Image[] {
				tk.getImage(Tank.class.getClassLoader().getResource("images/tree.gif")),
				tk.getImage(Tank.class.getClassLoader().getResource("images/commonWall.gif")),
				tk.getImage(Tank.class.getClassLoader().getResource("images/base3.png")),
				tk.getImage(Tank.class.getClassLoader().getResource("images/metalWall.gif")),
				tk.getImage(Tank.class.getClassLoader().getResource("images/river.jpg")),
				tk.getImage(Tank.class.getClassLoader().getResource("images/base4.png")),
		};
		
		imgs.put("T", tankImages[0]);
		imgs.put("C", tankImages[1]);
		imgs.put("H", tankImages[2]);
		imgs.put("M", tankImages[3]);
		imgs.put("R", tankImages[4]);
		imgs.put("B", tankImages[5]);
		
	}
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
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
	public TankClient getTc() {
		return tc;
	}
	public void setTc(TankClient tc) {
		this.tc = tc;
	}
	
	
}
