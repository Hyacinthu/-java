import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author ASUS
 *
 * @time 下午5:39:18
 *
 * @description 工具栏的颜色工具
 *
 */

public class ColorTool {
	JLabel foreColorIcon;//前景色图标的显示，与监听器同步更改
	JLabel backColorIcon;//背景色图标显示，与监听器同步
	Button foreColor;//前景色按钮
	Button backColor;//背景色按钮
	JButton[] colorBox;//常用颜色版
	Button editColor;//编辑颜色按钮
	
	public ColorTool() {
		foreColor = new Button();
		backColor = new Button();
		editColor = new Button();
		foreColor.button.setPreferredSize(new Dimension(70,100));
		backColor.button.setPreferredSize(new Dimension(70,100));
		editColor.button.setPreferredSize(new Dimension(90,100));
		foreColor.button.setBackground(new Color(0,162,232));
		backColor.button.setBackground(new Color(220,220,220));
		editColor.button.setBackground(new Color(220,220,220));
		JPanel temp1 = new JPanel(new GridLayout(2,1));
		temp1.setOpaque(false);
		JPanel temp2 = new JPanel(new GridLayout(2,1));
		temp2.setOpaque(false);
		JPanel temp3 = new JPanel(new GridLayout(2,1));
		temp3.setOpaque(false);
		foreColorIcon = new JLabel("",JLabel.CENTER);
		foreColorIcon.setOpaque(true);//背景设置为不透明，才可以设置背景色
		foreColorIcon.setBackground(Color.BLACK);//背景色设置为黑，用以代表当前选定的颜色
		foreColorIcon.setBorder(BorderFactory.createLineBorder(new Color(220,220,220)));
		backColorIcon = new JLabel("",JLabel.CENTER);
		backColorIcon.setOpaque(true);//背景设置为不透明，才可以设置背景色
		backColorIcon.setBackground(Color.WHITE);//背景色设置为黑，用以代表当前选定的颜色
		backColorIcon.setBorder(BorderFactory.createLineBorder(new Color(220,220,220)));
		JLabel[] temp = new JLabel[4];
		for(int i=0;i<4;i++) {
			temp[i] = new JLabel("",JLabel.CENTER);
			temp[i].setOpaque(false);
		}
		temp[0].setText("颜色1");
		temp[1].setText("颜色2");
		temp[2].setIcon(new ImageIcon("icon/colorBox.png"));
		temp[3].setText("编辑颜色");
		temp1.add(foreColorIcon);
		temp1.add(temp[0]);
		foreColor.button.add(temp1);
		temp2.add(backColorIcon);
		temp2.add(temp[1]);
		backColor.button.add(temp2);
		temp3.add(temp[2]);
		temp3.add(temp[3]);
		editColor.button.add(temp3);
		colorBox = new JButton[20];
		for(int i=0;i<20;i++) {
			colorBox[i] = new JButton();
			colorBox[i].setPreferredSize(new Dimension(15,15));
			//colorBox[i].setBorderPainted(false);//设置不绘制边框，此处应该无用，在JDialog中有用，保留在这
		}
		colorBox[0].setBackground(new Color(0,0,0));//根据电脑画图板,添加这些基本颜色
		colorBox[1].setBackground(new Color(127,127,127));
		colorBox[2].setBackground(new Color(136,0,21));
		colorBox[3].setBackground(new Color(237,28,36));
		colorBox[4].setBackground(new Color(255,127,39));
		colorBox[5].setBackground(new Color(255,242,0));
		colorBox[6].setBackground(new Color(34,177,76));
		colorBox[7].setBackground(new Color(0,162,232));
		colorBox[8].setBackground(new Color(63,72,204));
		colorBox[9].setBackground(new Color(163,73,164));
		colorBox[10].setBackground(new Color(255,255,255));
		colorBox[11].setBackground(new Color(195,195,195));
		colorBox[12].setBackground(new Color(185,122,87));
		colorBox[13].setBackground(new Color(255,174,201));
		colorBox[14].setBackground(new Color(255,201,14));
		colorBox[15].setBackground(new Color(239,228,176));
		colorBox[16].setBackground(new Color(181,230,29));
		colorBox[17].setBackground(new Color(153,217,234));
		colorBox[18].setBackground(new Color(112,146,190));
		colorBox[19].setBackground(new Color(200,191,231));
	}
}
