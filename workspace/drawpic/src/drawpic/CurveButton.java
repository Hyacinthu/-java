package drawpic;

//import java.awt.*;
import javax.swing.*;
/**
 * 
 * @author ASUS
 *
 * @time 下午3:13:21
 *
 * @description 曲线工具，无listener
 *
 */
public class CurveButton extends Button{
	public CurveButton() {
		button.setIcon(new ImageIcon("icon/curve.png"));//构造曲线属性
		button.setToolTipText("曲线");
	}
}


