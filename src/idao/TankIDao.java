package idao;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.List;

import com.etc.Direction;

import entity.Blood;
import entity.CommonWall;
import entity.Home;
import entity.MetalWall;
import entity.Missile;
import entity.Tank;
import entity.Water;

public interface TankIDao {
	public void draw(Graphics g);
	public void move();
	public void stay();
	public void keyPressed(KeyEvent e);
	public void locateDirection();
	public void keyReleased(KeyEvent e);
	public Missile fire();
	public Missile fire(Direction dir);
	public Rectangle getRect();
	public boolean isLive();
	public void superFire();
	public boolean eat(Blood b);
	public void drawBloodBar(Graphics g);
	public boolean collidesWithWall(List<CommonWall> cws,List<MetalWall> mws,List<Water> was);
	public boolean collidesWithTanks(java.util.List<Tank> tanks);
}
