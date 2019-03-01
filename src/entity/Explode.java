package entity;
import idao.ExplodeIDao;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import var.ExplodeVar;

import com.etc.MusicPlayer;
import com.etc.TankClient;

public class Explode extends ExplodeVar implements ExplodeIDao{
	public Explode(int x, int y, TankClient tc) {
		AePlayWave apw =new AePlayWave("Music/Explode Music.wav");
	apw.start();
		this.setX(x);
		this.setY(y);
		this.setTc(tc);
	}
	
	private static Toolkit tk = Toolkit.getDefaultToolkit();
	private static Image[] imgs = {
		tk.getImage(Explode.class.getClassLoader().getResource("images/0.gif")),
		tk.getImage(Explode.class.getClassLoader().getResource("images/1.gif")),
		tk.getImage(Explode.class.getClassLoader().getResource("images/2.gif")),
		tk.getImage(Explode.class.getClassLoader().getResource("images/3.gif")),
		tk.getImage(Explode.class.getClassLoader().getResource("images/4.gif")),
		tk.getImage(Explode.class.getClassLoader().getResource("images/5.gif")),
		tk.getImage(Explode.class.getClassLoader().getResource("images/6.gif")),
		tk.getImage(Explode.class.getClassLoader().getResource("images/7.gif")),
		tk.getImage(Explode.class.getClassLoader().getResource("images/8.gif")),
		tk.getImage(Explode.class.getClassLoader().getResource("images/9.gif")),
	};
	
	public void draw(Graphics g) {
		if(!this.isInit()){
			for (int i = 0; i < imgs.length; i++) {
				g.drawImage(imgs[i], -100, -100, null);
			}			
			this.setInit(true);
		}
		if(!this.isLive()) {
			this.getTc().explodes.remove(this);
			return;
		}
		if(this.getStep() == imgs.length) {
			this.setLive(false);
			this.setStep(0);
			return;
		}
		g.drawImage(imgs[this.getStep()], this.getX(), this.getY(), null);
		this.setStep(this.getStep()+1);
	}

	
}
