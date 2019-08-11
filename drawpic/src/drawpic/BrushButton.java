package drawpic;

//import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author ASUS
 *
 * @time 下午3:11:52
 *
 * @description 格式刷工具，无listener
 *
 */
public class BrushButton extends Button{
	public BrushButton() {
		button.setIcon(new ImageIcon("icon/brush.png"));//构造格式刷属性
		button.setToolTipText("格式刷");
	}
}

