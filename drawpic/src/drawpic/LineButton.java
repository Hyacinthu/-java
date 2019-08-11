package drawpic;

//import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author ASUS
 *
 * @time 下午3:14:34
 *
 * @description 直线工具，无listener
 *
 */
public class LineButton extends Button{
	public LineButton() {
		button.setIcon(new ImageIcon("icon/line.png"));//构造直线属性
		button.setToolTipText("直线");
	}
}
