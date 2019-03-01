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
 * MissileIDao�ӿڰ�������Missile��ķ���
 * @author Administrator
 *
 */
public interface MissileIDao {
	/**
	 * draw���� ���ڻ����ӵ� 
	 * @param GraphicsL���͵Ļ���
	 */
	public void draw(Graphics g);
	/**
	 * move���� �����ӵ����ƶ�
	 */
	public void move();
	/**
	 * getRect���� ����ӵ������
	 * @return ����Rectangle����ֵ 
	 */
	public Rectangle getRect();
	/**
	 * hitTank���������ж��ӵ��Ƿ����̹��
	 * @param ̹���� ����
	 * @return ����boolean ����
	 */
	public boolean hitTank(Tank t);
	public boolean hitTanks(List<Tank> tanks);
	public boolean hitWalls(List<CommonWall> cws,List<MetalWall> mws,Home home);
	public boolean hitMissile(List<Missile> missiles);
}
