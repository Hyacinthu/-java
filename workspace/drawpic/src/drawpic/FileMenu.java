package drawpic;
//import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author ASUS
 *
 * @time ����4:27:06
 *
 * @description �����ļ��˵�����menu������ʱҪ��ӵ�MenuBar��
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
		fileMenu = new JMenu("�ļ�");
		newMenu = new JMenuItem("�½���ctrl+N��");
		openMenu = new JMenuItem("�򿪣�ctrl+O��");
		saveMenu = new JMenuItem("���棨ctrl+S��");;
		saveAsMenu = new JMenuItem("���Ϊ��ctrl+A��");
		exitMenu = new JMenuItem("�˳���ctrl+X��");
		fileMenu.add(newMenu);
		fileMenu.add(openMenu);
		fileMenu.add(saveMenu);
		fileMenu.add(saveAsMenu);
		fileMenu.add(exitMenu);
	}
}
