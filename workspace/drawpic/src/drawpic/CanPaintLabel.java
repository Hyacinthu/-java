package drawpic;
import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author ASUS
 *
 * @time ����5:36:30
 *
 * @description ����canvas������ͼ�İ���
 *
 */

@SuppressWarnings("serial")
public class CanPaintLabel extends JLabel{
	public CanPaintLabel() {
		//�����ﴫ�����,�����Լ��趨һЩ����
		setOpaque(true);
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(1200,700));
		setBorder(BorderFactory.createLineBorder(new Color(220,220,220)));
	}
	@Override
    protected void paintComponent(Graphics g1) {
		//���������������Ҫ�Ķ���,����ͨ��updateUI()����ͼ��
		super.paintComponent(g1);
	}
	//���������дJLabel��ĳЩ���õĺ���
}
