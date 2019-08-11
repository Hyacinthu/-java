package drawpic;
//import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author ASUS
 *
 * @time 下午4:34:38
 *
 * @description 创建编辑菜单栏的menu，调用时要添加到MenuBar中
 *
 */

public class EditMenu {
	JMenu editMenu;
	JMenuItem undoMenu;
	JMenuItem redoMenu;
	JMenuItem copyMenu;
	JMenuItem cutMenu;
	JMenuItem pasteMenu;
	public EditMenu() {
		editMenu = new JMenu("编辑");
		undoMenu = new JMenuItem("撤回");
		redoMenu = new JMenuItem("重做");
		copyMenu = new JMenuItem("复制");;
		cutMenu = new JMenuItem("剪切");
		pasteMenu = new JMenuItem("粘贴");
		editMenu.add(undoMenu);
		editMenu.add(redoMenu);
		editMenu.add(copyMenu);
		editMenu.add(cutMenu);
		editMenu.add(pasteMenu);
	}
}
