package drawpic;
import java.awt.*;
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
		newMenu = new JMenuItem("�½�");
		openMenu = new JMenuItem("��");
		saveMenu = new JMenuItem("����");;
		saveAsMenu = new JMenuItem("���Ϊ");
		exitMenu = new JMenuItem("�˳�");
		fileMenu.add(newMenu);
		fileMenu.add(openMenu);
		fileMenu.add(saveMenu);
		fileMenu.add(saveAsMenu);
		fileMenu.add(exitMenu);
	}
	public static void main(String[] args) {
		//�������Ե�������Ĵ����,����ʱ��ע��
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
		//c.add(new FileMenu().fileMenu);//�������ӵ�menubar�У����޷����
		frame.setSize(1200,700);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}
