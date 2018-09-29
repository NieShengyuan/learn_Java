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
    
  
    //定义为内部类，可以方便的使用外部类的普通属性\
    //键盘监听
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
    
    //paint方法作用是：画出整个窗口及内部内容。被系统自动调用。
    @Override
    public void paint(Graphics g) {  
        g.drawImage(bgImg, 0, 0, null);
        plane.drawMySelf(g);//画飞机
        for(int i=0;i<shells.length;i++) {//  画炮弹
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
        		Font f = new Font("宋体",Font.BOLD,50);
        		g.setFont(f);
        		g.setColor(Color.red);
        		g.drawString("时间"+ period +"秒",(int)plane.x,(int)plane.y);
        	}
        }
        
        
    }
    //添加双缓冲技术
    public void update(Graphics g) {
    	if(offScreenImage == null) {
    		offScreenImage = this.createImage(Constant.GAME_WIDH, Constant.GAME_HEIGHT);
    	}
    	Graphics gOff = offScreenImage.getGraphics();
    	paint(gOff);
    	g.drawImage(offScreenImage, 0, 0, null);
    }
	
	public void launchFrame() {
		this.setTitle("飞机大战哇哇哇");
		this.setVisible(true);//窗口默认不可见，设为可见
		this.setSize(Constant.GAME_WIDH, Constant.GAME_HEIGHT);
		this.setLocation(300, 300);//窗口左上角顶点的坐标位置
		
		 //增加关闭窗口监听，这样用户点击右上角关闭图标，可以关闭游戏程序
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		new PaintThread().start();//启动重画线程
		addKeyListener(new KeyMonitor());//增加键盘的监听
		
		//初始化50个炮弹
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
