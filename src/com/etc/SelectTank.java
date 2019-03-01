package com.etc;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;


public class SelectTank {
	private int location=0; 
	private int x=210;
	private int y=320;
	private Login login;
	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public SelectTank(Login login){	
		this.setLogin(login);
	}
	
	public void draw (Graphics g,Image image){
		g.drawImage(image, this.x, this.y,45,45,null);
	}
	public int  keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch(key) {
		case KeyEvent.VK_UP :
			this.location--;
			this.location=this.location%2;
			this.y=320-40*this.location;
			break;
		case KeyEvent.VK_DOWN:
			this.location++;
			this.location=this.location%2;
			this.y=320+40*this.location;
			break;
		case KeyEvent.VK_ENTER:
			Login.a=true;
			this.getLogin().dispose();
			TankClient tc= new TankClient();
			tc.TcMain(this.location+1);
			return this.location+1;
		default:
			break;
		}
		return -1;
	}
}
