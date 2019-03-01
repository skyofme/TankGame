package var;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.Map;

import com.etc.Direction;
import com.etc.TankClient;

import entity.Missile;

public class MissileVar {
	public static final int XSPEED = 10;
	public static final int YSPEED = 10;
	
	public static final int WIDTH = 10;
	public static final int HEIGHT = 10;
	private int x, y;
	private Direction dir;
	private boolean good;
	private boolean live = true;
	
	private TankClient tc;
	
	private static Toolkit tk = Toolkit.getDefaultToolkit();
	private static Image[] missileImages = null;
	protected static Map<String, Image> imgs = new HashMap<String, Image>();
	static {
		missileImages = new Image[] {
				tk.getImage(Missile.class.getClassLoader().getResource("images/missileL.gif")),
				tk.getImage(Missile.class.getClassLoader().getResource("images/missileD.gif")),
				tk.getImage(Missile.class.getClassLoader().getResource("images/missileR.gif")),
				tk.getImage(Missile.class.getClassLoader().getResource("images/missileU.gif")),
		};
		
		imgs.put("L", missileImages[0]);
		imgs.put("U", missileImages[1]);
		imgs.put("R", missileImages[2]);
		imgs.put("D", missileImages[3]);
		
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

	public Direction getDir() {
		return dir;
	}

	public void setDir(Direction dir) {
		this.dir = dir;
	}

	public boolean isGood() {
		return good;
	}

	public void setGood(boolean good) {
		this.good = good;
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

	public static int getXspeed() {
		return XSPEED;
	}

	public static int getYspeed() {
		return YSPEED;
	}

	public static int getWidth() {
		return WIDTH;
	}

	public static int getHeight() {
		return HEIGHT;
	}
	
	
}
