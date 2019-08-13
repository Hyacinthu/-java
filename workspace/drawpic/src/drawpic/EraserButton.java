package drawpic;
//import java.awt.*;
import javax.swing.*;
/**
 * 
 * @author ASUS
 *
 * @time 下午3:13:35
 *
 * @description 橡皮工具，无listener
 *
 */
public class EraserButton extends Button{
	public EraserButton() {
		button.setIcon(new ImageIcon("icon/eraser.png"));//构造橡皮属性
		button.setToolTipText("橡皮");
	}
}
