import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author ASUS
 *
 * @time ����8:07:45
 *
 * @description ��������ڣ������ڼ���������Ҫ����dialog�ĸ���frame���ʸ�Ϊ��combine�����½�frame
 *
 */

public class MainWindow {
	JFrame frame;
	public MainWindow() {
		AllPanel all = new AllPanel();
		Container c = all.frame.getContentPane();
		c.setLayout(new BorderLayout());
		c.add(all.westPanel,BorderLayout.WEST);
		c.add(all.northPanel,BorderLayout.NORTH);
		c.add(all.centerPanel,BorderLayout.CENTER);
		all.frame.setJMenuBar(all.menu);
		all.frame.setVisible(true);
		new AboutDialog(frame).setVisible(true);
	}
	public static void main(String[] args) {
		new MainWindow();
	}
}
