package var;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.Map;

import com.etc.Direction;
import com.etc.TankClient;

import entity.Tank;


public class TankVar {
	private static  int XSPEED = 5;
	private static  int YSPEED = 5;
	private static  int WIDTH = 30;
	private static  int HEIGHT = 30;
	public static int getWIDTH() {
		return WIDTH;
	}
	public static void setWIDTH(int wIDTH) {
		WIDTH = wIDTH;
	}
	public static int getHEIGHT() {
		return HEIGHT;
	}
	public static void setHEIGHT(int hEIGHT) {
		HEIGHT = hEIGHT;
	}
	
	private TankClient tc;
	private int x, y;
	private int oldX, oldY;
	public static int getXSPEED() {
		return XSPEED;
	}
	public static void setXSPEED(int xSPEED) {
		XSPEED = xSPEED;
	}
	public static int getYSPEED() {
		return YSPEED;
	}
	public static void setYSPEED(int ySPEED) {
		YSPEED = ySPEED;
	}
	private int oOldX,oOldY;
	public int getoOldX() {
		return oOldX;
	}
	public void setoOldX(int oOldX) {
		this.oOldX = oOldX;
	}
	public int getoOldY() {
		return oOldY;
	}
	public void setoOldY(int oOldY) {
		this.oOldY = oOldY;
	}
	private int player;
	public int getPlayer() {
		return player;
	}
	public void setPlayer(int player) {
		this.player = player;
	}
	public static Toolkit getTk() {
		return tk;
	}
	public static void setTk(Toolkit tk) {
		TankVar.tk = tk;
	}
	public static Image[] getTankImages() {
		return tankImages;
	}
	public static void setTankImages(Image[] tankImages) {
		TankVar.tankImages = tankImages;
	}
	public static Map<String, Image> getImgs() {
		return imgs;
	}
	public static void setImgs(Map<String, Image> imgs) {
		TankVar.imgs = imgs;
	}
	private boolean good;
	private int life = 100;
	private boolean live = true;
	private boolean bL=false, bU=false, bR=false, bD = false;
	private Direction dir = Direction.STOP;
	private Direction ptDir = Direction.D;
	private static Toolkit tk = Toolkit.getDefaultToolkit();
	private static Image[] tankImages = null;
	protected static Map<String, Image> imgs = new HashMap<String, Image>();
	static {
		tankImages = new Image[] {
				tk.getImage(Tank.class.getClassLoader().getResource("images/enemy0L.gif")),
				tk.getImage(Tank.class.getClassLoader().getResource("images/enemy0U.gif")),
				tk.getImage(Tank.class.getClassLoader().getResource("images/enemy0R.gif")),
				tk.getImage(Tank.class.getClassLoader().getResource("images/enemy0D.gif")),
				tk.getImage(Tank.class.getClassLoader().getResource("images/hero1L.gif")),
				tk.getImage(Tank.class.getClassLoader().getResource("images/hero1U.gif")),
				tk.getImage(Tank.class.getClassLoader().getResource("images/hero1R.gif")),
				tk.getImage(Tank.class.getClassLoader().getResource("images/hero1D.gif")),
				tk.getImage(Tank.class.getClassLoader().getResource("images/hero2L.gif")),
				tk.getImage(Tank.class.getClassLoader().getResource("images/hero2U.gif")),
				tk.getImage(Tank.class.getClassLoader().getResource("images/hero2R.gif")),
				tk.getImage(Tank.class.getClassLoader().getResource("images/hero2D.gif")),
		};
		
		imgs.put("0L", tankImages[0]);
		imgs.put("0U", tankImages[1]);
		imgs.put("0R", tankImages[2]);
		imgs.put("0D", tankImages[3]);
		imgs.put("1L", tankImages[4]);
		imgs.put("1U", tankImages[5]);
		imgs.put("1R", tankImages[6]);
		imgs.put("1D", tankImages[7]);
		imgs.put("2L", tankImages[8]);
		imgs.put("2U", tankImages[9]);
		imgs.put("2R", tankImages[10]);
		imgs.put("2D", tankImages[11]);
		
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
	public int getOldX() {
		return oldX;
	}
	public void setOldX(int oldX) {
		this.oldX = oldX;
	}
	public int getOldY() {
		return oldY;
	}
	public void setOldY(int oldY) {
		this.oldY = oldY;
	}
	public boolean isGood() {
		return good;
	}
	public void setGood(boolean good) {
		this.good = good;
	}
	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
	public boolean isbL() {
		return bL;
	}
	public void setbL(boolean bL) {
		this.bL = bL;
	}
	public boolean isbU() {
		return bU;
	}
	public void setbU(boolean bU) {
		this.bU = bU;
	}
	public boolean isbR() {
		return bR;
	}
	public void setbR(boolean bR) {
		this.bR = bR;
	}
	public boolean isbD() {
		return bD;
	}
	public void setbD(boolean bD) {
		this.bD = bD;
	}
	public Direction getDir() {
		return dir;
	}
	public void setDir(Direction dir) {
		this.dir = dir;
	}
	public Direction getPtDir() {
		return ptDir;
	}
	public void setPtDir(Direction ptDir) {
		this.ptDir = ptDir;
	}
	public static int getXspeed() {
		return XSPEED;
	}
	public TankClient getTc() {
		return tc;
	}
	public void setTc(TankClient tc) {
		this.tc = tc;
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
