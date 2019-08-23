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
	BorderListener asd;
	ExitListener exit;
	public AllListener(AllButton b,AllMenu m,AllTool t,CanPaintLabel c,MyFrame fram) {
		/*����
		 * action = new ActionListener["����ĸ������˴���Ҫ�Ķ�"];
		 * ...�˴�Ϊ������listener
		 * action["�˴�Ϊ��Ӧ��listener�����"] = MyListener("����"��"����"��������);
		 * !����listener���ܲ�ȫ���������Ҫ������Ӷ����listener������ɾ���������listener
		 */
		//Ϊ�˿��Ե��ԣ���ʱΪÿһ�����60������
		action = new ActionListener[51];
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
		action[40] = new NewListener(fram,c,m);
		action[41] = new OpenListener(fram,c,m);
		action[42] = new SaveListener(fram,c);
		action[43] = new SaveAsListener(fram,c);
		action[44] = new UndoListener(fram,c,m);
		action[45] = new RedoListener(fram,c,m);
		action[46] = new CopyListener(fram,c,m);
		action[47] = new CutListener(fram,c,m);
		action[48] = new PasteListener(fram,c);
		action[49] = new ShowHelpListener(fram.frame);
		action[50] = new AboutListener(fram.frame);
		exit = new ExitListener(fram,c);
	}
}
