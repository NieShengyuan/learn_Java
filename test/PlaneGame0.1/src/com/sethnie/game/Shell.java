package com.sethnie.game;

import java.awt.Color;
import java.awt.Graphics;

public class Shell extends GameObject {
	double degree;
	
	public Shell() {
		degree = Math.random()*Math.PI*2;
		x = 200;
		y = 200;
		width = 10;
		height = 10;
		speed = 3;
	}
	
	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.yellow);
		g.fillOval((int)x, (int)y, width, height);
		
		x += speed*Math.cos(degree);
		y += speed*Math.sin(degree);
		
		//���´��룬����ʵ�������߽磬�ڵ���������(ԭ���ʹ�̨����Ϸһ��)
        if(y>Constant.GAME_HEIGHT-height||y<30){
            degree = -degree;
        }
        if(x<0||x>Constant.GAME_WIDH-width){
            degree = Math.PI-degree;
        }
        //���ظ��ⲿ�������ǰ����ɫ
        g.setColor(c);
	}

}