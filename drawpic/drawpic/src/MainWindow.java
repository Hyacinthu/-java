import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author ASUS
 *
 * @time 下午8:07:45
 *
 * @description 程序主入口，由于在监听器层需要调用dialog的父类frame，故改为在combine处就新建frame
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
