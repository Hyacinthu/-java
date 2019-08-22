package drawpic;
//import java.awt.*;
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
		newMenu = new JMenuItem("新建（ctrl+N）");
		openMenu = new JMenuItem("打开（ctrl+O）");
		saveMenu = new JMenuItem("保存（ctrl+S）");;
		saveAsMenu = new JMenuItem("另存为（ctrl+A）");
		exitMenu = new JMenuItem("退出（ctrl+X）");
		fileMenu.add(newMenu);
		fileMenu.add(openMenu);
		fileMenu.add(saveMenu);
		fileMenu.add(saveAsMenu);
		fileMenu.add(exitMenu);
	}
}
