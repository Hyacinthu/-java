package drawpic;
//import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author ASUS
 *
 * @time ����4:34:38
 *
 * @description �����༭�˵�����menu������ʱҪ��ӵ�MenuBar��
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
		editMenu = new JMenu("�༭");
		undoMenu = new JMenuItem("����");
		redoMenu = new JMenuItem("����");
		copyMenu = new JMenuItem("����");;
		cutMenu = new JMenuItem("����");
		pasteMenu = new JMenuItem("ճ��");
		editMenu.add(undoMenu);
		editMenu.add(redoMenu);
		editMenu.add(copyMenu);
		editMenu.add(cutMenu);
		editMenu.add(pasteMenu);
	}
}
