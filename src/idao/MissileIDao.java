package idao;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;

import com.etc.Direction;

import entity.CommonWall;
import entity.Home;
import entity.MetalWall;
import entity.Missile;
import entity.Tank;
import entity.Wall;
/**
 * MissileIDao接口包含所有Missile类的方法
 * @author Administrator
 *
 */
public interface MissileIDao {
	/**
	 * draw方法 用于画出子弹 
	 * @param GraphicsL类型的画笔
	 */
	public void draw(Graphics g);
	/**
	 * move方法 用于子弹的移动
	 */
	public void move();
	/**
	 * getRect函数 获得子弹的面积
	 * @return 返回Rectangle类型值 
	 */
	public Rectangle getRect();
	/**
	 * hitTank方法用于判断子弹是否击中坦克
	 * @param 坦克类 参数
	 * @return 返回boolean 类型
	 */
	public boolean hitTank(Tank t);
	public boolean hitTanks(List<Tank> tanks);
	public boolean hitWalls(List<CommonWall> cws,List<MetalWall> mws,Home home);
	public boolean hitMissile(List<Missile> missiles);
}
