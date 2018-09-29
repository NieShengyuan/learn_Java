package com.sethnie.game;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

public class MyGameFrame extends Frame{
	private Image offScreenImage = null;
	
	Image bgImg = GameUtil.getImage("images/bg.jpg");
    Image planeImg = GameUtil.getImage("images/plane.png");
    Plane plane = new Plane(planeImg,300,300);
    Shell[] shells = new Shell[20];
    Explode bao;
    Date startTime = new Date();
    Date endTime;
    int period;
    
  
    //����Ϊ�ڲ��࣬���Է����ʹ���ⲿ�����ͨ����\
    //���̼���
    class KeyMonitor extends KeyAdapter{
    	@Override
    	public void keyPressed(KeyEvent e) {
    		plane.addDrication(e);
    	}
    	@Override
    	public void keyReleased(KeyEvent e) {
    		plane.minusDirection(e);
    	}
    }
    
    //paint���������ǣ������������ڼ��ڲ����ݡ���ϵͳ�Զ����á�
    @Override
    public void paint(Graphics g) {  
        g.drawImage(bgImg, 0, 0, null);
        plane.drawMySelf(g);//���ɻ�
        for(int i=0;i<shells.length;i++) {//  ���ڵ�
        	shells[i].draw(g);
        	
        	boolean peng = shells[i].getRect().intersects(plane.getRect());
        	if(peng) {
        		plane.live = false;
        		if(bao == null) {
        			bao = new Explode(plane.x,plane.y);
        			endTime = new Date();
        			period = (int)((endTime.getTime() - startTime.getTime())/1000);
        		}
        		bao.draw(g);
        	}
        	if(!plane.live) {
        		Font f = new Font("����",Font.BOLD,50);
        		g.setFont(f);
        		g.setColor(Color.red);
        		g.drawString("ʱ��"+ period +"��",(int)plane.x,(int)plane.y);
        	}
        }
        
        
    }
    //���˫���弼��
    public void update(Graphics g) {
    	if(offScreenImage == null) {
    		offScreenImage = this.createImage(Constant.GAME_WIDH, Constant.GAME_HEIGHT);
    	}
    	Graphics gOff = offScreenImage.getGraphics();
    	paint(gOff);
    	g.drawImage(offScreenImage, 0, 0, null);
    }
	
	public void launchFrame() {
		this.setTitle("�ɻ���ս������");
		this.setVisible(true);//����Ĭ�ϲ��ɼ�����Ϊ�ɼ�
		this.setSize(Constant.GAME_WIDH, Constant.GAME_HEIGHT);
		this.setLocation(300, 300);//�������ϽǶ��������λ��
		
		 //���ӹرմ��ڼ����������û�������Ͻǹر�ͼ�꣬���Թر���Ϸ����
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		new PaintThread().start();//�����ػ��߳�
		addKeyListener(new KeyMonitor());//���Ӽ��̵ļ���
		
		//��ʼ��50���ڵ�
		for(int i=0;i<shells.length;i++) {
        	shells[i] = new Shell();
        }
	}
	
	class PaintThread extends Thread{
    	public void run() {
    		while(true) {
    			repaint();
    			try {
    				Thread.sleep(40);
    			}catch(InterruptedException e) {
    				e.printStackTrace();
    			}
    		}
    	}
    }
	
	public static void main(String[] args) {
		MyGameFrame f = new MyGameFrame();
		f.launchFrame();
	}
}
