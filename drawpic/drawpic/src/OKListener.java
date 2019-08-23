import java.awt.event.*;
//import java.awt.*;
import javax.swing.*;


/**
 * 
 * @author ASUS
 *
 * @time 下午5:43:41
 *
 * @description 仅供EditDialog调用的监听器，实现点确定的功能
 *
 */

public class OKListener implements ActionListener{
	JLabel a;
	JLabel b;
	JDialog g;
	public OKListener(JLabel s,JLabel f,JDialog q) {
		a=s;
		b=f;
		g=q;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		a.setBackground(b.getBackground());
		a.updateUI();
		g.dispose();
	}
	
}