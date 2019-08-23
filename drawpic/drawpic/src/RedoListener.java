import java.awt.*;
import java.awt.event.*;

public class RedoListener implements ActionListener {
	MyFrame frame;
	CanPaintLabel a;
	AllMenu b;
	public RedoListener(MyFrame frame,CanPaintLabel a,AllMenu b) {
		this.frame = frame;
		this.a = a;
		this.b = b;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		a.teImage = null;
		a.gg = null;
		a.setPreferredSize(new Dimension(frame.redo.get(frame.redo.size()-1).getWidth(),
				frame.redo.get(frame.redo.size()-1).getHeight()));
		a.image = frame.redo.get(frame.redo.size()-1);
		a.bg = (Graphics2D)a.image.getGraphics();
		a.oldtimes = 1;
		a.times = 1;
		a.updateUI();
		frame.undo.addElement(frame.redo.get(frame.redo.size()-1));
		frame.redo.remove(frame.redo.size()-1);
		b.allMenuItem[5].setEnabled(true);
		if(frame.redo.isEmpty()) {
			b.allMenuItem[6].setEnabled(false);
		}
	}
}
