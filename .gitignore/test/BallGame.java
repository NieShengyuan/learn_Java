import java.awt.*;
import javax.swing.*;

public class BallGame extends JFrame {
	
	//´°¿Ú¼ÓÔØ
	void lunchFrame() {
		setSize(300,300);
		setLocation(400,400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		System.out.println("this is a first java game.");
		BallGame game = new BallGame();
		game.lunchFrame();
	}

}
