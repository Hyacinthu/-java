package drawpic;
import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author ASUS
 *
 * @time 下午4:00:15
 *
 * @description 对combine进行处理，简化传入frame中的参数个数
 *
 */

public class AllPanel {
	JMenuBar menu;
	JPanel westPanel,northPanel;
	JScrollPane centerPanel;//定义三个区
	JFrame frame;
	public AllPanel() {
		FlowLayout f = new FlowLayout(FlowLayout.LEFT);
		f.setHgap(50);
		westPanel = new JPanel(new 	GridLayout(14,2));//14行两列,用空白label补充空位
		menu = new JMenuBar();
		menu.setLayout(new FlowLayout(FlowLayout.LEFT));//设置菜单栏属性
		northPanel = new JPanel(f);
		
		AllCombine allCombine = new AllCombine();
		for(int i=0;i<allCombine.allPenButton.length;i++) {
			westPanel.add(allCombine.allPenButton[i].button);//添加到西区面板上
		}
		for(int i=0;i<14;i++) {
			westPanel.add(new JLabel(""));
		}
		for(int i=0;i<allCombine.allMenuMenu.length;i++) {
			allCombine.allMenuMenu[i].addSeparator();
			menu.add(allCombine.allMenuMenu[i]);
		}
		JPanel[] tools = new JPanel[3];//将北区分为三块
		//添加字体栏组件
		tools[0] = new JPanel(new GridLayout(3,1));
		JPanel[] tool = new JPanel[3];
		for(int i=0;i<3;i++) {
			tool[i] = new JPanel(new FlowLayout(FlowLayout.LEFT));//为了显示更舒服，否则会一样大，炸了
		}
		tool[0].add(allCombine.allToolLabel[3]);
		tool[1].add(allCombine.fontToolBox);
		tool[1].add(allCombine.fontSizeToolBox);
		tool[2].add(allCombine.allToolButton[3].button);
		tool[2].add(allCombine.allToolButton[4].button);
		tool[2].add(allCombine.allToolButton[5].button);
		for(int i=0;i<3;i++) {
			tools[0].add(tool[i]);
		}
		//添加大小组件
		tools[1] = new JPanel(new GridLayout(2,1));
		tools[1].add(allCombine.allToolLabel[2]);
		tools[1].add(allCombine.sizeToolBox);
		//添加颜色组件
		tools[2] = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel colorBox = new JPanel(new GridLayout(2,1));//用来装小颜色区
		JPanel[] color = new JPanel[2];
		for(int i=0;i<2;i++) {
			color[i] = new JPanel(new FlowLayout(FlowLayout.CENTER));
			color[i].setBackground(Color.WHITE);
		}
		for(int i=0;i<10;i++) {
			color[0].add(allCombine.allToolColor[i]);
			color[1].add(allCombine.allToolColor[10+i]);
		}
		colorBox.add(color[0]);
		colorBox.add(color[1]);
		colorBox.setPreferredSize(new Dimension(205,50));
		colorBox.setBackground(Color.WHITE);
		colorBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		tools[2].add(allCombine.allToolButton[0].button);
		tools[2].add(allCombine.allToolButton[1].button);
		tools[2].add(colorBox);
		tools[2].add(allCombine.allToolButton[2].button);
		for(int i=0;i<3;i++) {
			northPanel.add(tools[i]);
		}
		//添加画布区
		centerPanel = new JScrollPane(allCombine.canvas);
		frame = allCombine.frame;
	}
	
}
