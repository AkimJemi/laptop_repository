package mainPackage;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainPage extends JFrame {

	private Image screenImage;
	private Graphics screenGraphics;
	private Image introBackground;

	public MainPage() {
		setTitle("MainPage");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		try {
			introBackground = new ImageIcon("img/introBackground.jpg").getImage().getScaledInstance(Main.SCREEN_WIDTH,
					Main.SCREEN_HEIGHT, Image.SCALE_SMOOTH);
		} catch (Exception e) {
			System.out.println(e);
		}
		Music introMusic = new Music("introMusic.mp3", true);
		introMusic.start();

	}

	@Override
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphics = screenImage.getGraphics();
		screenDraw(screenGraphics);
		g.drawImage(screenImage, 0, 0, null);
	}

	private void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null);
		this.repaint();

	}

}
