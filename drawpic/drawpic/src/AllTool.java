//import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author ASUS
 *
 * @time ����3:41:27
 *
 * @description 
 * allLabelǰ������������йأ�������ɫ1����ɫ2������ɫѡ������ģ�������Ϊ��ʾ���ã�Ϊ��С��ǩ�������ǩ
 * sizeBox�����С�����е�������fontBoxΪ���幤�ߵ�ѡ����������fontSizeBoxΪ�����Сѡ����
 * allButton�У�ǰ����Ϊ��ɫ����ǰ��ɫ������ɫ�ͱ༭��ɫ�İ�ť�������������������Ӵ֡��»��ߡ�б��
 * allColorΪ��ɫ���������ʹ�Ϸ�label�ı���ɫ
 * �༭��ɫ��Ҫ��������һ��dialog�Ի����Լ���Ӧ�ļ�����
 * 
 *
 */

public class AllTool {
	JLabel[] allLabel;
	JComboBox<String> sizeBox;//ԭʼ���͵ķ����޷��������飬�ʷֿ�����
	JComboBox<String> fontBox;
	JComboBox<String> fontSizeBox;
	Button[] allButton;
	JButton[] allColor;
	public AllTool() {
		ColorTool temp1 = new ColorTool();
		SizeTool temp2 = new SizeTool();
		FontTool temp3 = new FontTool();
		allLabel = new JLabel[4];
		allLabel[0]=temp1.foreColorIcon;
		allLabel[1]=temp1.backColorIcon;
		allLabel[2]=temp2.sizeLabel;
		allLabel[3]=temp3.fontLabel;
		sizeBox = temp2.sizeTool;
		fontBox = temp3.fontTool;
		fontSizeBox = temp3.fontSizeTool;
		allButton = new Button[6];
		allButton[0]=temp1.foreColor;
		allButton[1]=temp1.backColor;
		allButton[2]=temp1.editColor;
		allButton[3]=temp3.blacker;
		allButton[4]=temp3.underer;
		allButton[5]=temp3.leaner;
		allColor = new JButton[20];
		for(int i=0;i<20;i++) {
			allColor[i]=temp1.colorBox[i];
		}
	}
}
