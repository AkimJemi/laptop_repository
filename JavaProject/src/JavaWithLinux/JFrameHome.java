package JavaWithLinux;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class JFrameHome extends JFrameAndLinux {
	private final int TEXT_LOCATION_X = 10;
	private final int TEXT_LOCATION_Y = 10;
	private final int TEXT_HEIGHT = 30;
	private final int TEXT_WIDTH = 100;
	private final int BUTTON_WIDTH = 70;
	private final int BUTTON_HEIGHT = 30;

	public JFrameHome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 300, 300);
		Container c = getContentPane();
		c.setLayout(null);
		JTextField text = new JTextField();
		text.setBounds(TEXT_LOCATION_X, TEXT_LOCATION_Y, TEXT_WIDTH, TEXT_HEIGHT);
		c.add(text);
		JButton but = new JButton(JButton.TEXT_CHANGED_PROPERTY);
		but.setBounds(TEXT_LOCATION_X + TEXT_WIDTH, TEXT_LOCATION_Y, BUTTON_WIDTH, BUTTON_HEIGHT);
		but.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				main(new String[]{text.getText()});
			}
		});
		
		
		c.add(but);
		setVisible(true);
	}

}
