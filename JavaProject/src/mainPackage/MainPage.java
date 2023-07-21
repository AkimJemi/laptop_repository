package mainPackage;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainPage extends NewJFrame{

	private Image screenImage;
	private Graphics screenGraphics;
	private Image background = new ImageIcon("img/background001.jpg").getImage()
			.getScaledInstance(Main.SCREEN_MAIN_WIDTH, Main.SCREEN_MAIN_HEIGHT, Image.SCALE_SMOOTH);
	private JLabel menuBar = new JLabel(new ImageIcon("img/menuBar.png"));
	private JButton button = new JButton(new ImageIcon(new ImageIcon("img/exitButton.png").getImage()
			.getScaledInstance(Main.EXIT_BUTTON, Main.EXIT_BUTTON, Image.SCALE_SMOOTH)));
	private ImageIcon startButtonEnteredImageIcon = new ImageIcon(new ImageIcon("img/startButtonEntered.png").getImage()
			.getScaledInstance(Main.START_BUTTON_WIDTH, Main.START_BUTTON_HEIGHT, Image.SCALE_SMOOTH));
	private ImageIcon startButtonExittedImageIcon = new ImageIcon(new ImageIcon("img/startButtonExitted.png").getImage()
			.getScaledInstance(Main.START_BUTTON_WIDTH, Main.START_BUTTON_HEIGHT, Image.SCALE_SMOOTH));
	private JButton startButton = new JButton(startButtonEnteredImageIcon);

	private int mouseX, mouseY;

	public MainPage() {
		System.out.println("test");
		setUndecorated(true);
		setTitle("MainPage");
		setSize(Main.SCREEN_MAIN_WIDTH, Main.SCREEN_MAIN_HEIGHT + Main.MENUBAR_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		menuBar.setBounds(0, 0, Main.SCREEN_MAIN_WIDTH, Main.MENUBAR_HEIGHT);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});

		button.setBounds(Main.SCREEN_MAIN_WIDTH - 30, 0, 30, 30);
		buttonSetting(button);
		
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				new Music(Main.MOUSE_ENTERED_SOUND, true).run();
			}
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		startButton.setBounds( (int)Math.round((Main.SCREEN_MAIN_WIDTH/2)-Main.START_BUTTON_WIDTH/2) , (int)Math.round(Main.SCREEN_MAIN_HEIGHT/1.2), Main.START_BUTTON_WIDTH, Main.START_BUTTON_HEIGHT);
		buttonSetting(startButton);
		startButton.addMouseListener(new NewMouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				new Music(Main.MOUSE_ENTERED_SOUND, true).run();
				startButton.setIcon(startButtonExittedImageIcon);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonEnteredImageIcon);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				new Music(Main.MOUSE_PRESSED_SOUND, true);
			}
		});
		
		add(button);
		add(startButton);
		add(menuBar);

//		Music introMusic = new Music("introMusic.mp3", true);
//		introMusic.start();

	}

	private void buttonSetting(JButton button) {
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setFocusPainted(false);
	}

	@Override
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_MAIN_WIDTH, Main.SCREEN_MAIN_HEIGHT);
		screenGraphics = screenImage.getGraphics();
		screenDraw(screenGraphics);
		g.drawImage(screenImage, 0, 0, null);
	}

	private void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null);
		paintComponents(g);
		this.repaint();

	}

}
