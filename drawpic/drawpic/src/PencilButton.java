import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author ASUS
 *
 * @time ����3:14:46
 *
 * @description Ǧ�ʹ��ߣ���listener
 *
 */
public class PencilButton extends Button{
	public PencilButton() {
		button.setIcon(new ImageIcon("icon/pencil.png"));//����Ǧ������
		button.setBackground(new Color(175,175,175));
		button.setToolTipText("Ǧ��");
	}
}
