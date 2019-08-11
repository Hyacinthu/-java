package drawpic;
import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author ASUS
 *
 * @time 下午4:27:06
 *
 * @description 创建文件菜单栏的menu，调用时要添加到MenuBar中
 *
 */
public class FileMenu {
	JMenu fileMenu;
	JMenuItem newMenu;
	JMenuItem openMenu;
	JMenuItem saveMenu;
	JMenuItem saveAsMenu;
	JMenuItem exitMenu;
	public FileMenu() {
		fileMenu = new JMenu("文件");
		newMenu = new JMenuItem("新建");
		openMenu = new JMenuItem("打开");
		saveMenu = new JMenuItem("保存");;
		saveAsMenu = new JMenuItem("另存为");
		exitMenu = new JMenuItem("退出");
		fileMenu.add(newMenu);
		fileMenu.add(openMenu);
		fileMenu.add(saveMenu);
		fileMenu.add(saveAsMenu);
		fileMenu.add(exitMenu);
	}
	public static void main(String[] args) {
		//用来测试单个程序的代码段,不用时可注释
		// TODO Auto-generated method stub
		//AllButton button = new AllButton();
		JFrame frame = new JFrame();
		Container c = frame.getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.LEFT));
		//JPanel p1 = new JPanel(new GridLayout(5,2,5,5));
		//for(int i=0;i<14;i++) {
		//	c.add(button.allButton[i].button);
		//}
		JMenuBar as = new JMenuBar();
		as.add(new FileMenu().fileMenu);
		c.add(as);
		//c.add(new FileMenu().fileMenu);//如果不添加到menubar中，则无法点击
		frame.setSize(1200,700);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}
