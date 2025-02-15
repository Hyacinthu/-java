//import java.awt.*;
//import javax.swing.*;

/**
 * 
 * @author ASUS
 *
 * @time 下午3:11:08
 *
 * @description 
 * !所有button区域的集合，方便传参数
 * !按顺序依次是：刷子、圆形、圆角矩形、取色笔、曲线、橡皮、填色桶、放大镜、直线、铅笔、矩形、选定框、喷枪、文本框
 * !所有的按钮与监视器有关
 */
public class AllButton {
	Button[] allButton;//整合所有的button，以便于设置listener时的参数传入
	public AllButton() {
		allButton = new Button[14];
		allButton[0] = new BrushButton();
		allButton[1] = new CircleButton();
		allButton[2] = new CirRectButton();
		allButton[3] = new ColorPenButton();
		allButton[4] = new CurveButton();
		allButton[5] = new EraserButton();
		allButton[6] = new FillColorButton();
		allButton[7] = new LargerButton();
		allButton[8] = new LineButton();
		allButton[9] = new PencilButton();
		allButton[10] = new RectangleButton();
		allButton[11] = new SelectBoxButton();
		allButton[12] = new SprayPaintButton();
		allButton[13] = new TextBoxButton();
	}
}
