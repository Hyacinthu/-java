import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class UndoListener implements ActionListener {
	MyFrame frame;
	CanPaintLabel a;
	AllMenu b;
	public UndoListener(MyFrame frame,CanPaintLabel a,AllMenu b) {
		this.frame = frame;
		this.a = a;
		this.b = b;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		a.teImage = null;
		a.gg = null;
		frame.redo.addElement(frame.undo.get(frame.undo.size()-1));
		frame.undo.remove(frame.undo.size()-1);
		b.allMenuItem[6].setEnabled(true);
		if(!frame.undo.isEmpty()) {
			a.setPreferredSize(new Dimension(frame.undo.get(frame.undo.size()-1).getWidth(),
					frame.undo.get(frame.undo.size()-1).getHeight()));
			a.image = frame.undo.get(frame.undo.size()-1);
			a.bg = (Graphics2D)a.image.getGraphics();
			a.oldtimes = 1;
			a.times = 1;
			a.updateUI();
		}
		else {
			a.setPreferredSize(new Dimension(1000,500));
			BufferedImage image = new BufferedImage(1000,500,BufferedImage.TYPE_INT_RGB);//设置RGB形式的图像
			Graphics2D bg = (Graphics2D)image.getGraphics();//得到画笔
			bg.setColor(Color.WHITE);
			bg.fillRect(0, 0, image.getWidth(), image.getHeight());//填充初始背景为白色
			a.image = image;
			a.bg = (Graphics2D)a.image.getGraphics();
			a.oldtimes = 1;
			a.times = 1;
			a.updateUI();
			b.allMenuItem[5].setEnabled(false);
		}
	}
}