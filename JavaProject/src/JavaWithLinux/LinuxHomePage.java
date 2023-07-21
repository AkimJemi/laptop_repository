package JavaWithLinux;

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
import javax.swing.JTextField;

import mainPackage.Main;
import mainPackage.MainPage;
import mainPackage.Music;

public class LinuxHomePage extends JFrame {
	public static final int SCREEN_HOME_WIDTH = 1000;
	public static final int SCREEN_HOME_HEIGHT = 600;

	public static final int SCREEN_MAIN_WIDTH = 1280;
	public static final int SCREEN_MAIN_HEIGHT = 720;
	public static final int MENUBAR_HEIGHT = 30;
	public static final int EXIT_BUTTON = 30;

	public static final int START_BUTTON_HEIGHT = 80;
	public static final int START_BUTTON_WIDTH = 150;

	private JLabel menuBar = new JLabel(new ImageIcon("img/menuBar.png"));
	private JButton button = new JButton(new ImageIcon(new ImageIcon("img/exitButton.png").getImage()
			.getScaledInstance(EXIT_BUTTON, EXIT_BUTTON, Image.SCALE_SMOOTH)));
	private ImageIcon startButtonEnteredImageIcon = new ImageIcon(new ImageIcon("img/startButtonEntered.png").getImage()
			.getScaledInstance(START_BUTTON_WIDTH, START_BUTTON_HEIGHT, Image.SCALE_SMOOTH));
	private ImageIcon startButtonExittedImageIcon = new ImageIcon(new ImageIcon("img/startButtonExitted.png").getImage()
			.getScaledInstance(START_BUTTON_WIDTH, START_BUTTON_HEIGHT, Image.SCALE_SMOOTH));
	private JButton startButton = new JButton(startButtonEnteredImageIcon);

	private int mouseX, mouseY;

	public LinuxHomePage() {
		setUndecorated(true);
		setTitle("MainPage");
		setSize(SCREEN_HOME_WIDTH, SCREEN_HOME_HEIGHT + MENUBAR_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
//		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		setMenuBar();
		
		JTextField textFile = new JTextField();
		textFile.setBounds(300,300,120,30);
		textFile.setVisible(true);
		add(textFile);
		
		
		

	}

	private void setMenuBar() {
		menuBar.setBounds(0, 0, SCREEN_HOME_WIDTH, MENUBAR_HEIGHT);
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
		button.setBounds(SCREEN_HOME_WIDTH - 30, 0, 30, 30);
		buttonSetting(button);

		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		startButton.setBounds((int) Math.round((SCREEN_HOME_WIDTH / 2) - START_BUTTON_WIDTH / 2),
				(int) Math.round(SCREEN_HOME_HEIGHT / 1.2), START_BUTTON_WIDTH, START_BUTTON_HEIGHT);
		buttonSetting(startButton);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonExittedImageIcon);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonEnteredImageIcon);
			}

			@Override
			public void mousePressed(MouseEvent e) {

			}
		});

		add(button);
		add(startButton);
		add(menuBar);

	}

	private void buttonSetting(JButton button) {
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setFocusPainted(false);
	}

//	@Override
//	public void paint(Graphics g) {
//		screenImage = createImage(SCREEN_HOME_WIDTH, SCREEN_HOME_HEIGHT);
//		screenGraphics = screenImage.getGraphics();
//		screenDraw(screenGraphics);
//		g.drawImage(screenImage, 0, 0, null);
//	}
//
//	private void screenDraw(Graphics g) {
//		g.drawImage(background, 0, 0, null);
//		paintComponents(g);
//		this.repaint();
//	}
}
