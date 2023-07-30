package JavaWithLinux;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class JFrameHome {
	private final int JFRAME_X = 500;
	private final int JFRAME_Y = 500;
	private final int JFRAME_WIDTH = 500;
	private final int JFRAME_HEIGHT = 500;
	private final int TEXT_LOCATION_X = 10;
	private final int TEXT_LOCATION_Y = 10;
	private final int TEXT_HEIGHT = 30;
	private final int TEXT_WIDTH = 100;
	private final int BUTTON_WIDTH = 70;
	private final int BUTTON_HEIGHT = 30;

	public JFrameHome() {
		LinuxCommandController jb = new LinuxCommandController();

		jb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jb.setBounds(JFRAME_X, JFRAME_Y, JFRAME_WIDTH, JFRAME_HEIGHT);
		jb.getRootPane().registerKeyboardAction(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				jb.dispose();
//				JOptionPane.showMessageDialog(jb, "F1 have been pressed!");
			}
		}, KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);

		Container c = jb.getContentPane();
		c.setLayout(null);
		JTextField text = new JTextField();
		JTextField text2 = new JTextField();
		text.setBounds(TEXT_LOCATION_X, TEXT_LOCATION_Y, TEXT_WIDTH, TEXT_HEIGHT);
		text2.setBounds(TEXT_LOCATION_X, TEXT_LOCATION_Y + TEXT_HEIGHT, JFRAME_WIDTH, TEXT_HEIGHT * 3);
		text2.setEditable(false)	;
		text2.setText(new LinuxCommand().get_INTERNAL_COMMANDS_AND_BUILTINS_List().toString());
		text2.setAutoscrolls(true);
		text2.setDragEnabled(true);
		c.add(text);
		c.add(text2);
		JButton but = new JButton(JButton.TEXT_CHANGED_PROPERTY);
		but.setBounds(TEXT_LOCATION_X + TEXT_WIDTH, TEXT_LOCATION_Y, BUTTON_WIDTH, BUTTON_HEIGHT);
		but.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jb.main(new String[] { text.getText() });
			}
		});
		c.add(but);
		jb.setVisible(true);
		Thread thread = new Thread();
		thread.start();
		Timer timer = new Timer();
		TimerTask timeOutTask = new TimerTask() {
			@Override
			public void run() {
				if (thread != null && thread.isAlive()) {
					thread.interrupt();
					timer.cancel();
				}
				jb.dispose();
			}
		};
		timer.schedule(timeOutTask, 10000);
	}

}
