import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author ASUS
 *
 * @time 下午3:14:46
 *
 * @description 铅笔工具，无listener
 *
 */
public class PencilButton extends Button{
	public PencilButton() {
		button.setIcon(new ImageIcon("icon/pencil.png"));//构造铅笔属性
		button.setBackground(new Color(175,175,175));
		button.setToolTipText("铅笔");
	}
}
