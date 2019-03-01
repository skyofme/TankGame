package var;

import com.etc.TankClient;

public class ExplodeVar {
	private int x, y;
	private boolean live = true;
	
	private TankClient tc ;
	private int step = 0;
	
	private static boolean init = false;

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

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public static boolean isInit() {
		return init;
	}

	public static void setInit(boolean init) {
		ExplodeVar.init = init;
	}
	
}
