package drawpic;
//import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author ASUS
 *
 * @time ����5:24:30
 *
 * @description ���������˵�����menu������ʱҪ��ӵ�MenuBar��
 *
 */

public class HelpMenu {
	JMenu helpMenu;
	JMenuItem showHelpMenu;
	JMenuItem aboutMenu;
	public HelpMenu() {
		helpMenu = new JMenu("����");
		showHelpMenu = new JMenuItem("��ʾ����");
		aboutMenu = new JMenuItem("����");
		helpMenu.add(showHelpMenu);
		helpMenu.add(aboutMenu);
	}
}
