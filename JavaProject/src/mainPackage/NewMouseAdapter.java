package mainPackage;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NewMouseAdapter extends MouseAdapter{

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("mousePressed");
		new Music(Main.MOUSE_PRESSED_SOUND, true);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("mouseEntered");
		new Music(Main.MOUSE_ENTERED_SOUND, true);
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	
	
	
}
