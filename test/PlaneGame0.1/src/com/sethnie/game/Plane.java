package com.sethnie.game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

public class Plane extends GameObject {
	int speed ;
	boolean left,up,right,down;
	boolean live = true;
	
	// �����������Ҽ�����ı䷽��ֵ��
    // ���磺�����ϼ�����e.getKeyCode()��ֵ����VK_UP����ô�ã�up=true;
	public void addDrication(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_LEFT  :left  = true;break;
		case KeyEvent.VK_UP    :up    = true;break;
		case KeyEvent.VK_RIGHT :right = true;break;
		case KeyEvent.VK_DOWN  :down  = true;break;
		default :break;
		}
	}
	// �ɿ��������Ҽ�����ı䷽��ֵ��
    // ���磺�ɿ��ϼ�����e.getKeyCode()��ֵ����VK_UP����ô�ã�up=false;
	public void minusDirection(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_LEFT  :left  = false;break;
		case KeyEvent.VK_UP    :up    = false;break;
		case KeyEvent.VK_RIGHT :right = false;break;
		case KeyEvent.VK_DOWN  :down  = false;break;
		default :break;
		}
	}
	@Override
	public void drawMySelf(Graphics g) {
		// ���ݷ��򣬼���ɻ��µ�����
		if(live) {
			g.drawImage(img, (int)x,(int)y,null);
			if (left) {
				x -= speed;
			}
			if (right) {
				x += speed;
			}
			if (up) {
				y -= speed;
			}
			if (down) {
				y += speed;
			}
		}
		else {
			
		}
		
	}
	public Plane(Image img,double x,double y) {
		super(img,x,y);
		this.x = x;
		this.y = y;
		this.speed = 4;
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
	}
}
