import java.awt.event.*;

//import java.awt.*;
import javax.swing.*;
/**
 * 
 * @author ASUS
 *
 * @time 下午3:33:13
 *
 * @description 此处为所有组件添加监听器的地方，也可以将响应后产生的dialog放到这里，相应产生的监听器事件也就要对应到AllListener中
 * 
 *
 */

public class AllCombine {
	Button[] allPenButton;
	JMenu[] allMenuMenu;
	JMenuItem[] allMenuMenuItem;
	JLabel[] allToolLabel;
	JComboBox<String> sizeToolBox;
	JComboBox<String> fontToolBox;
	JComboBox<String> fontSizeToolBox;
	Button[] allToolButton;
	JButton[] allToolColor;
	CanPaintLabel canvas; 
	JFrame frame;
	public AllCombine() {
		AllButton allButton = new AllButton();
		AllMenu allMenu = new AllMenu();
		AllTool allTool = new AllTool();
		CanPaintLabel allCanvas = new CanPaintLabel();
		MyFrame fram = new MyFrame();
		AllListener allListener = new AllListener(allButton,allMenu,allTool,allCanvas,fram);
		
		for(int i=0;i<allButton.allButton.length;i++) {
			allButton.allButton[i].button.addActionListener(allListener.action[i]);
		}
		//工具栏区域只需要实现颜色区的点击事件就可以,其他的参数等到canvas绘图时再提取
		for(int i=0;i<allTool.allButton.length;i++) {
			allTool.allButton[i].button.addActionListener(allListener.action[i+
			                                allButton.allButton.length]);
		}
		for(int i=0;i<allTool.allColor.length;i++) {
			allTool.allColor[i].addActionListener(allListener.action[i+allButton.allButton.length+
			                                allTool.allButton.length]);
		}
		//此处添加监听器,要注意的是,该程序到现在为止,没有设置任何的初始状态,故监听器要考虑到
		allCanvas.addMouseMotionListener(allListener.asd);
		allCanvas.addMouseListener(allListener.asd);
		for(int i=0;i<4;i++) {
			allMenu.allMenuItem[i].addActionListener(allListener.action[40+i]);
		}
		for(int i=5;i<12;i++) {
			allMenu.allMenuItem[i].addActionListener(allListener.action[39+i]);
		}
		allMenu.allMenuItem[4].addActionListener(allListener.exit);
		//为菜单栏的按钮绑定快捷键
		allMenu.allMenuItem[0].registerKeyboardAction(allListener.action[40],
				KeyStroke.getKeyStroke(KeyEvent.VK_N,KeyEvent.CTRL_MASK), JComponent.WHEN_IN_FOCUSED_WINDOW);
		allMenu.allMenuItem[1].registerKeyboardAction(allListener.action[41],
				KeyStroke.getKeyStroke(KeyEvent.VK_O,KeyEvent.CTRL_MASK), JComponent.WHEN_IN_FOCUSED_WINDOW);
		allMenu.allMenuItem[2].registerKeyboardAction(allListener.action[42],
				KeyStroke.getKeyStroke(KeyEvent.VK_S,KeyEvent.CTRL_MASK), JComponent.WHEN_IN_FOCUSED_WINDOW);
		allMenu.allMenuItem[3].registerKeyboardAction(allListener.action[43],
				KeyStroke.getKeyStroke(KeyEvent.VK_A,KeyEvent.CTRL_MASK), JComponent.WHEN_IN_FOCUSED_WINDOW);
		allMenu.allMenuItem[4].registerKeyboardAction(allListener.exit,
				KeyStroke.getKeyStroke(KeyEvent.VK_X,KeyEvent.CTRL_MASK), JComponent.WHEN_IN_FOCUSED_WINDOW);
		allMenu.allMenuItem[5].registerKeyboardAction(allListener.action[44],
				KeyStroke.getKeyStroke(KeyEvent.VK_Z,KeyEvent.CTRL_MASK), JComponent.WHEN_IN_FOCUSED_WINDOW);
		allMenu.allMenuItem[6].registerKeyboardAction(allListener.action[45],
				KeyStroke.getKeyStroke(KeyEvent.VK_Y,KeyEvent.CTRL_MASK), JComponent.WHEN_IN_FOCUSED_WINDOW);
		allMenu.allMenuItem[7].registerKeyboardAction(allListener.action[46],
				KeyStroke.getKeyStroke(KeyEvent.VK_C,KeyEvent.CTRL_MASK), JComponent.WHEN_IN_FOCUSED_WINDOW);
		allMenu.allMenuItem[8].registerKeyboardAction(allListener.action[47],
				KeyStroke.getKeyStroke(KeyEvent.VK_T,KeyEvent.CTRL_MASK), JComponent.WHEN_IN_FOCUSED_WINDOW);
		allMenu.allMenuItem[9].registerKeyboardAction(allListener.action[48],
				KeyStroke.getKeyStroke(KeyEvent.VK_V,KeyEvent.CTRL_MASK), JComponent.WHEN_IN_FOCUSED_WINDOW);
		allMenu.allMenuItem[10].registerKeyboardAction(allListener.action[49],
				KeyStroke.getKeyStroke(KeyEvent.VK_E,KeyEvent.CTRL_MASK), JComponent.WHEN_IN_FOCUSED_WINDOW);
		allMenu.allMenuItem[11].registerKeyboardAction(allListener.action[50],
				KeyStroke.getKeyStroke(KeyEvent.VK_P,KeyEvent.CTRL_MASK), JComponent.WHEN_IN_FOCUSED_WINDOW);

		fram.frame.addWindowListener(allListener.exit);
		//所有监听器赋值完毕后,对该处进行初始化
		allPenButton = allButton.allButton;
		allMenuMenu = allMenu.allMenu;
		allMenuMenuItem = allMenu.allMenuItem;
		allToolLabel = allTool.allLabel;
		sizeToolBox = allTool.sizeBox;
		fontToolBox = allTool.fontBox;
		fontSizeToolBox = allTool.fontSizeBox;
		allToolButton = allTool.allButton;
		allToolColor = allTool.allColor;
		canvas = allCanvas;
		frame = fram.frame;
	}
}
