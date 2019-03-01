//1：进入结算界面时，坦克还存在，依然能发出声音
//2:重新开始时，music play线程还没有停掉，，并且会重开
package com.etc;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
public class Login extends Frame{
	private static Image BackGroundImage;
	private static Image SelectTankImage;
	private static Image StratImage;
	private boolean init;
	private SelectTank st = new SelectTank(this);
	Image offScreenImage = null;
	public static Login login = null;
	public static PaintThread paintThread = null;
	public static MusicPlayThread musicPlayThread =null;
	public static Thread thread = null;
	public static boolean a = false;
	public static int b =0;
	public Login() {  
		}
	public void update(Graphics g) {
		if(offScreenImage == null) {
			offScreenImage = this.createImage(800, 600);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.GREEN);
		gOffScreen.fillRect(0, 0, 800, 600);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}
	public void paint (Graphics g){
		try {
			BackGroundImage = ImageIO.read(new FileImageInputStream(new File("images/Login.jpg")));
			SelectTankImage = ImageIO.read(new FileImageInputStream(new File("images/Select Tank.jpg")));
			StratImage = ImageIO.read(new FileImageInputStream(new File("images/Start Image.jpg")));
//			StartImage = ImageIO.read(new FileImageInputStream(new File("images/Start Image.jpg")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(!this.init){
			for (int i=0;i<1000;i++){
				g.drawImage(StratImage, 0, 0,800, 600, null);
			}
			this.init=true;
		}
		g.drawImage(BackGroundImage,0,0,800,600,null );
		st.draw(g, SelectTankImage);
	}
	
	public void lauchFrame (){
     	this.setLocation(300, 100);
		this.setSize(800, 600);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
			 System.exit(0);
			}
		});
		
		this.setTitle("TankWarLogin");
		this.setResizable(false);
		this.addKeyListener((KeyListener) new KeyMonitor());
		paintThread = new PaintThread();
		thread = new Thread(paintThread);
		musicPlayThread=new MusicPlayThread();
		thread = new Thread(musicPlayThread);
		thread.start();
		setVisible(true);
	}
	public static void main(String[] args) {
		Login login=new Login();
		login.lauchFrame();
		}
	public static void loginMain(){
		b++;
		Login login=new Login();
		login.a = false;
		login.lauchFrame();
	}
	private class PaintThread implements Runnable {
		public void run() {
			if(login.a==false){
				while(true) {
					repaint();
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
	}
	private class MusicPlayThread implements Runnable {
		public void run() {
			while(true){
				MusicPlayer.play("Music/BackGround Music.wav");
				}
		}
		
	}
	
	private class KeyMonitor extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			st.keyPressed(e);
		}
		
	}
}

