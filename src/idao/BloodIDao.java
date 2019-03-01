package idao;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * 这是一个BloodIDao类接口
 * @author 刘小燕
 *
 */
public interface BloodIDao {
	/**
	 * draw方法 用于画出血块
	 * @param Graphics 类的画笔
	 */
	public void draw(Graphics g);
	/**
	 * getRect方法用于获取该血块的面积
	 * @return 返回Rectangle类型的值
	 */
	public Rectangle getRect();
}
