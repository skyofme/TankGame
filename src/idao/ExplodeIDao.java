package idao;

import java.awt.Graphics;

import com.etc.TankClient;
/**
 * ExplodeIDao爆炸类接口
 * @author 刘小燕
 *
 */
public interface ExplodeIDao {
	/**
	 * draw方法 用于画出爆照图片
	 * @param Graphics 类型的 画笔
	 */
	public void draw(Graphics g);
}
