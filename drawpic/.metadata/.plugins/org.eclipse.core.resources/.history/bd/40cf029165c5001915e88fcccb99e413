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
		undoMenu = new JMenuItem("撤回（ctrl+Z）");
		redoMenu = new JMenuItem("重做（ctrl+Y）");
		copyMenu = new JMenuItem("复制（ctrl+C）");;
		cutMenu = new JMenuItem("剪切（ctrl+T）");
		pasteMenu = new JMenuItem("粘贴（ctrl+V）");
		editMenu.add(undoMenu);
		editMenu.add(redoMenu);
		editMenu.add(copyMenu);
		editMenu.add(cutMenu);
		editMenu.add(pasteMenu);
		undoMenu.setEnabled(false);
		redoMenu.setEnabled(false);
		copyMenu.setEnabled(false);
		cutMenu.setEnabled(false);
		pasteMenu.setEnabled(false);
	}
}
