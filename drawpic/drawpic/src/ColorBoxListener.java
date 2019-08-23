import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author ASUS
 *
 * @time 下午5:52:46
 *
 * @description 此监听器为了响应小颜色区的按钮
 *
 */

public class ColorBoxListener implements ActionListener{
	JLabel[] label;
	JButton[] button;
	JButton flag;
	public ColorBoxListener(JLabel[] a,JButton f,JButton b,JButton s) {
		label = a;
		button = new JButton[2];
		button[0] = f;
		button[1] = b;
		flag = s;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(button[0].getBackground().equals(new Color(0,162,232))) {
			label[0].setBackground(flag.getBackground());
			label[0].updateUI();
		}
		else {
			label[1].setBackground(flag.getBackground());
			label[1].updateUI();
		}
	}
	
}
