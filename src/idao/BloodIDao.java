package idao;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * ����һ��BloodIDao��ӿ�
 * @author ��С��
 *
 */
public interface BloodIDao {
	/**
	 * draw���� ���ڻ���Ѫ��
	 * @param Graphics ��Ļ���
	 */
	public void draw(Graphics g);
	/**
	 * getRect�������ڻ�ȡ��Ѫ������
	 * @return ����Rectangle���͵�ֵ
	 */
	public Rectangle getRect();
}
