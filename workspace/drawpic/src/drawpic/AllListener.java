package drawpic;
//import java.awt.*;
import java.awt.event.*;
/**
 * 
 * @author ASUS
 *
 * @time ����3:23:25
 *
 * @description �����listener��������Ҫʲôlistener������������������趨���������뷽ʽ���켴��
 * !!!ע�⣬����������Ҫ��ɸô�AllListener�Ĺ��캯��
 *
 */
public class AllListener {
	ActionListener[] action;
	FocusListener[] focus;
	KeyListener[] key;
	MouseListener[] mouse;
	MouseMotionListener[] mouseMotion;
	BorderListener asd;
	public AllListener(AllButton b,AllMenu m,AllTool t,CanPaintLabel c,MyFrame fram) {
		/*����
		 * action = new ActionListener["����ĸ������˴���Ҫ�Ķ�"];
		 * ...�˴�Ϊ������listener
		 * action["�˴�Ϊ��Ӧ��listener�����"] = MyListener("����"��"����"��������);
		 * !����listener���ܲ�ȫ���������Ҫ������Ӷ����listener������ɾ���������listener
		 */
		//Ϊ�˿��Ե��ԣ���ʱΪÿһ�����60������
		action = new ActionListener[40];
		focus = new FocusListener[60];
		key = new KeyListener[60];
		mouse = new MouseListener[60];
		mouseMotion = new MouseMotionListener[60];
		for(int i=0;i<14;i++) {
			action[i] = new LeftButtonListener(b.allButton,i);
		}
		action[14] = new ColorSelectListener(t.allButton[0].button,t.allButton[1].button);
		action[15] = new ColorSelectListener(t.allButton[1].button,t.allButton[0].button);
		action[16] = new EditColorListener(fram.frame,t.allButton[0].button,
				t.allButton[1].button,t.allLabel);
		for(int i=0;i<3;i++) {
			action[i+17] = new FontListener(t.allButton[i+3].button);
		}
		for(int i=0;i<20;i++) {
			action[i+20] = new ColorBoxListener(t.allLabel,t.allButton[0].button,
					t.allButton[1].button,t.allColor[i]);
		}
		asd = new BorderListener(b,m,t,c,fram);
		//�·�Ϊ��δʵ�ֵļ�����
		for(int i=0;i<60;i++) {
			focus[i] = new FocusListener() {

				@Override
				public void focusGained(FocusEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void focusLost(FocusEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
			};
			key[i] = new KeyListener() {

				@Override
				public void keyPressed(KeyEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void keyReleased(KeyEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void keyTyped(KeyEvent arg0) {
					// TODO Auto-generated method stub
					
				}};
			mouse[i] = new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}};
			mouseMotion[i] = new MouseMotionListener() {

				@Override
				public void mouseDragged(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseMoved(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}};
		}
	}
}
