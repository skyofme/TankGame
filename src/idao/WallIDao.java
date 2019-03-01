package idao;

import java.awt.Graphics;
import java.awt.Rectangle;

public interface WallIDao {
	public void draw(Graphics g);
	public Rectangle getRect();
	public void construct();
}
