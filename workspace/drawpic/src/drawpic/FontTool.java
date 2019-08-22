package drawpic;
import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author ASUS
 *
 * @time 下午5:42:45
 *
 * @description 字体工具栏里面的工具
 *
 */

public class FontTool {
	JLabel fontLabel;
	JComboBox<String> fontTool;
	JComboBox<String> fontSizeTool;
	Button blacker;//加黑
	Button underer;//下划线
	Button leaner;//倾斜
	public FontTool() {
		fontLabel = new JLabel("字体:",JLabel.CENTER);
		fontLabel.setOpaque(true);
		fontTool = new JComboBox<String>();
		//获取当前系统内所有可用字体
		String[] g = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		fontSizeTool = new JComboBox<String>();
		for(int i=0;i<g.length;i++) {
			fontTool.addItem(g[i]);
		}
		for(int i=5;i<25;i++) {
			fontSizeTool.addItem(""+2*i);
		}
		fontTool.setSelectedIndex(g.length-7);
		fontSizeTool.setSelectedIndex(3);
		blacker = new Button();
		underer = new Button();
		leaner = new Button();
		blacker.button.setPreferredSize(new Dimension(25,25));
		underer.button.setPreferredSize(new Dimension(25,25));
		leaner.button.setPreferredSize(new Dimension(25,25));
		blacker.button.setIcon(new ImageIcon("icon/blacker.png"));
		underer.button.setIcon(new ImageIcon("icon/underer.png"));
		leaner.button.setIcon(new ImageIcon("icon/leaner.png"));
		blacker.button.setToolTipText("加粗");
		underer.button.setToolTipText("下划线");
		leaner.button.setToolTipText("斜体");
	}
}
