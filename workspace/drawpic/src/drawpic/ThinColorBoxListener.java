package drawpic;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author ASUS
 *
 * @time 下午5:51:15
 *
 * @description 用以Dialog中的渐变色板的颜色选择，使能够选择的颜色更多
 *
 */


public class ThinColorBoxListener implements MouseListener {
	JDialog b;
	JLabel c;
	ShadeLabel ds;
	JLabel[] zz;
	//传入参数为：Dialog，渐变色面板，需要改变的预览图和数据框label
	public ThinColorBoxListener(JDialog q,ShadeLabel d,JLabel[] z) {
		b = q;
		ds=d;
		c = new JLabel();
		c.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		c.setBounds(ds.getBounds().x-5,ds.getBounds().y-5,25,5);
		b.add(c);
		zz = z;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		c.setLocation(ds.getBounds().x-2, ds.getBounds().y+e.getY()-2);
		Color te;
		//这里同颜色板类似，从一个颜色渐变过去到另一个颜色的变化规律如下
		if(e.getY()<=120) {
			te = new Color((int)(255-(255-ds.getBackground().getRed())*e.getY()/120.0),
					(int)(255-(255-ds.getBackground().getGreen())*e.getY()/120.0),
					(int)(255-(255-ds.getBackground().getBlue())*e.getY()/120.0));
		}
		else {
			te = new Color((int)(ds.getBackground().getRed()*(240-e.getY())/120.0),
					(int)(ds.getBackground().getGreen()*(240-e.getY())/120.0),
					(int)(ds.getBackground().getBlue()*(240-e.getY())/120.0));
		}
		zz[4].setBackground(te);
		zz[4].updateUI();
		//显示RGB值
		zz[5].setText(String.valueOf(te.getRed()));
		zz[6].setText(String.valueOf(te.getGreen()));
		zz[7].setText(String.valueOf(te.getBlue()));
		for(int i=0;i<3;i++) {
			zz[i+5].updateUI();
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}
}
