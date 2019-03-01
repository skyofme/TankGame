package com.etc;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import entity.Blood;
import entity.CommonWall;
import entity.Explode;
import entity.Grass;
import entity.Home;
import entity.MetalWall;
import entity.Missile;
import entity.Tank;
import entity.Water;

/**
 * 这个类的作用是坦克游戏的主窗口
 * @author mashibing
 *
 */

public class TankClient extends Frame {
	/**
	 * 整个坦克游戏的宽度
	 */
	public static final int GAME_WIDTH = 800;
	public static final int GAME_HEIGHT = 600;
	public static  int a = 0;//用于计算空格键按下的次数
	public static  int p = 1;//几个玩家
	public static  int m = 3;//我方可复活几次
	public static  int t = 10;//敌方可复活几次
	public static int q = 0;//计算敌方共死了多少坦克
	public static boolean time = false;
	public static int timeNum = 0;
	public static int timerNum = 0;
	public static int phNum = 0;
	public static int starNum = 0;
	public static int bombNum = 0;
	public static boolean over = false;
	public static TankClient tc = null;
	public static List<Explode> explodes = new ArrayList<Explode>();
	public static List<Missile> missiles = new ArrayList<Missile>();
	public static List<Tank> tanks = new ArrayList<Tank>();
	public static  List<CommonWall> cws = new ArrayList<CommonWall>();
	public static List<MetalWall> mws = new ArrayList<MetalWall>();
	public static List<Grass> grs = new ArrayList<Grass>();
	public static List<Water> was = new ArrayList<Water>();
	public static List<Tank> myTanks = new ArrayList<Tank>();
	
	public static Thread thread = null;
	Image offScreenImage = null;
	
	public static Blood b = new Blood();
	Water water = new Water();
	Home home = new Home(370,540,this);
	CommonWall commonWall = new CommonWall();
	MetalWall metalWall = new MetalWall();
	Grass grass = new Grass();
	public static Login login = null;
	public void paint(Graphics g) {
		/*
		 * 指明子弹-爆炸-坦克的数量
		 * 以及坦克的生命值
		 */
		if(home.getLife()>0&&myTanks.size()>0){
			if(tanks.size()>0){
				//showInfo(g);
				if(a%2==0){//用于暂停判断
					//取出没颗子弹 子弹打敌人 打我方坦克 打墙 画出子弹
					for(int i=0; i<missiles.size(); i++) {
						Missile m = missiles.get(i);
						m.hitTanks(tanks);
						m.hitTanks(myTanks);
						m.hitWalls(cws, mws,home);
						m.hitMissile(missiles);
						m.move();
					}
					//画出炸弹
					for(int i=0; i<explodes.size(); i++) {
						Explode e = explodes.get(i);
						e.draw(g);
						//取出没一个敌人坦克 判断是否碰墙 是否碰到我方坦克  画出每个敌人坦克
						}
					if(this.time==false){
						for(int i=0; i<tanks.size(); i++) {
							Tank t = tanks.get(i);
							t.collidesWithWall(cws,mws,was);
							t.collidesWithTanks(tanks);
						}
					}else{
						timeNum++;
						if(timeNum==500){
							this.time = false;
							timeNum=0;
						}
					}
					for(int i=0; i<myTanks.size(); i++) {
						Tank t = myTanks.get(i);
						t.collidesWithWall(cws,mws,was);
						t.collidesWithTanks(myTanks);
						t.collidesWithTanks(tanks);
						System.out.println(i);
					}
				}
				//画出地方坦克
				for(int i=0; i<tanks.size(); i++) {
					Tank t = tanks.get(i);
					t.draw(g);
				}
				//画出我方坦克
				for(int i=0; i<myTanks.size(); i++) {
					Tank t = myTanks.get(i);
					t.draw(g);
					t.eat(b);
				}
				//取出没颗子弹 子弹打敌人 打我方坦克 打墙 画出子弹
				for(int i=0; i<missiles.size(); i++) {
					Missile m = missiles.get(i);
					m.draw(g);
				}
				//判断我方坦克是否碰墙 
				//画出水墙
				water.draw(g);
				//画出家
				home.draw(g);
				//画出金属墙
				metalWall.draw(g);
				//画出普通墙
				commonWall.draw(g);
				//画出草地
				grass.draw(g);
				//画出血块
				if(b.isLive()==true){
					b.Location(was, home);
					b.draw(g);
					b.setLife(b.getLife()-1);
					if(b.getLife()<=0){
						b.setLive(false);
					}
				}
			}
			else{
				this.overShowInfo(g);
				this.over = true;
				g.setColor(Color.CYAN);
				g.setFont(new Font("宋体",1,50));
				g.drawString("WIN", 350, 150);
			}
		}
			else{
				this.overShowInfo(g);
				this.over = true;
				g.setColor(Color.CYAN);
				g.setFont(new Font("宋体",1,50));
				g.drawString("LOSE", 350, 150);
			}
		}
	
	public void update(Graphics g) {
		if(offScreenImage == null) {
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.BLACK);
		gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}
	public void showInfo(Graphics g){
		g.setColor(Color.CYAN);
		g.drawString("missiles count:" + missiles.size(), 10, 40);
		g.drawString("explodes count:" + explodes.size(), 10, 50);
		g.drawString("tanks    count:" + tanks.size(), 10, 60);
		//g.drawString("tanks     life:" + myTanks.size(), 10, 110);
	}
	public void overShowInfo(Graphics g){
		g.setColor(Color.CYAN);
		g.setFont(new Font("宋体",1,20));
		g.drawString("TYPE",200,220);
		g.drawString("NUM",300,220);
		g.drawString("PRICE",400,220);
		g.drawString("SCORE",500,220);
		g.setFont(new Font("宋体",1,17));
		Tank tank = new Tank(200,250,false,0,Direction.R,this);
		tank.draw(g);
		g.drawString(q+"",300,260);
		g.drawString("*",350,260);
		g.drawString("200",400,260);
		g.drawString("==",450,260);
		g.drawString(q*200+"",510,260);
		Blood blood = new Blood();
		blood.setX(200);
		blood.setY(300);
		blood.setType(0);
		blood.draw(g);
		g.drawString(phNum+"",300,310);
		g.drawString("*",350,310);
		g.drawString("100",400,310);
		g.drawString("==",450,310);
		g.drawString(phNum*100+"",510,310);
		blood.setX(200);
		blood.setY(350);
		blood.setType(1);
		blood.draw(g);
		g.drawString(bombNum+"",300,360);
		g.drawString("*",350,360);
		g.drawString("500",400,360);
		g.drawString("==",450,360);
		g.drawString(bombNum*500+"",510,360);
		blood.setX(200);
		blood.setY(400);
		blood.setType(2);
		blood.draw(g);
		g.drawString(starNum+"",300,410);
		g.drawString("*",350,410);
		g.drawString("1000",400,410);
		g.drawString("==",450,410);
		g.drawString(starNum*1000+"",510,410);
		blood.setX(200);
		blood.setY(450);
		blood.setType(3);
		blood.draw(g);
		g.drawString(timerNum+"",300,460);
		g.drawString("*",350,460);
		g.drawString("100",400,460);
		g.drawString("==",450,460);
		g.drawString(timerNum*100+"",510,460);
		g.drawString("___________________________________________________", 200, 500);
		g.drawString(q*200+phNum*100+bombNum*500+starNum*1000+timerNum*100+"",510,540);
	}
	public void construct(int a){
		this.p= a;
		water.construct();
		grass.construct();
		commonWall.construct();
		metalWall.construct();
		for(int i=0; i<p; i++) {
			Tank tank = new Tank( 300+ 180*i, 560, true,i+1, Direction.STOP, this);
			myTanks.add(tank);
		}
		for(int i=0; i<Integer.parseInt(PropertyMgr.getProperty("reProduceTankCount")); i++) {
			Tank tank = new Tank( 300+ 40*i, 10, false,0, Direction.STOP, this);
			tanks.add(tank);
		}
	}
	/**
	 * 本方法显示坦克主窗口
	 *
	 */
	public void lauchFrame() {
		this.setLocation(300, 100);
		this.setSize(GAME_WIDTH, GAME_HEIGHT);
		this.setTitle("TankWar");
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		this.setResizable(false);
		this.setBackground(Color.GREEN);
		//设置键盘监听
		this.addKeyListener(new KeyMonitor());
		//窗口可见
		setVisible(true);
		//开启画线程
		thread = new Thread(new PaintThread());
		thread.start();
	}

	public  void TcMain(int a) {
		//创建窗口对象
		tc = new TankClient();
		tc.lauchFrame();
		//设置窗口属性
		tc.construct(a);
		tc.over = false;
	}
	//画线程
	private class PaintThread implements Runnable {
		public void run() {
			if(tc.over == false){
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
	public void clear(){
		explodes.clear();
		missiles.clear();
		tanks.clear();
		cws.clear();
		mws.clear();
		grs.clear();
		was.clear();
		myTanks.clear();
		//
		home.setLive(true);
		home.setLife(1);
		b.BloodConstruct();
		a = 0;//用于计算空格键按下的次数
		p = 1;//几个玩家
		m = 3;//我方可复活几次
		t = 10;//敌方可复活几次
		q = 0;//计算敌方共死了多少坦克
		time = false;
		timeNum = 0;
		timerNum = 0;
		phNum = 0;
		starNum = 0;
		bombNum = 0;
		//Login.a = false;
	}
	//键盘监听类
	private class KeyMonitor extends KeyAdapter {

		public void keyReleased(KeyEvent e) {
			for(int i=0; i<myTanks.size(); i++) {
				Tank t = myTanks.get(i);
				t.keyReleased(e);
			}
		}

		public void keyPressed(KeyEvent e) {
			for(int i=0; i<myTanks.size(); i++) {
				Tank t = myTanks.get(i);
				t.keyPressed(e);
			}
			if(over == true){
				int key = e.getKeyCode();
				if(key == KeyEvent.VK_V ){
					clear();
					tc.construct(p);
					over = false;
				}
				if(key == KeyEvent.VK_B){
					Login login = new Login();
					login.loginMain();
					clear();
					tc.dispose();
					over = false;
				}
			}
		}
	}
}
