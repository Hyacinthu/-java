import java.awt.*;
import java.awt.event.*;
//import javax.swing.*;

/**
 * 
 * @author ASUS
 *
 * @time 下午4:02:53
 *
 * @description 为左侧功能按键设置按键监听器，以button数组的索引区分
 *
 */

public class LeftButtonListener implements ActionListener{
	Button[] button;
	int flag;
	public LeftButtonListener(Button[] b,int s) {//传入按钮，以顺序作为标志来完成选定的更改，更改背景颜色
		button = b;
		flag = s;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Color temp = new Color(175,175,175);
		for(int i=0;i<button.length;i++) {
			if(button[i].button.getBackground().equals(temp)) {//将原先的选定更改为原来的颜色
				button[i].button.setBackground(new Color(255,255,255));
				button[i].button.updateUI();
			}
			if(i==flag) {//当前选定的
				button[i].button.setBackground(temp);
				button[i].button.updateUI();
			}
		}
	}
}
