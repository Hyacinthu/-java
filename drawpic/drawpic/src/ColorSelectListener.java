import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author ASUS
 *
 * @time 下午5:38:02
 *
 * @description 此监听器a为被点击对象，b为修改对象，使用时要注意顺序
 *
 */

public class ColorSelectListener implements ActionListener{
	JButton[] button;
	public ColorSelectListener(JButton a,JButton b) {
		button = new JButton[2];
		button[0] = a;
		button[1] = b;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		button[0].setBackground(new Color(0,162,232));
		button[1].setBackground(new Color(220,220,220));
		button[0].updateUI();
		button[1].updateUI();
	}
}
