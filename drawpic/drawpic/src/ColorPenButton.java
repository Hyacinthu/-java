//import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author ASUS
 *
 * @time 下午3:13:00
 *
 * @description 取色笔工具，无listener
 *
 */
public class ColorPenButton extends Button{
	public ColorPenButton() {
		button.setIcon(new ImageIcon("icon/colorpen.png"));//构造取色笔属性
		button.setToolTipText("取色笔");
	}
}
