//import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author ASUS
 *
 * @time 下午3:41:27
 *
 * @description 
 * allLabel前两项与监听器有关，代表颜色1、颜色2，随颜色选择而更改，后两项为显示作用，为大小标签和字体标签
 * sizeBox代表大小工具中的下拉框，fontBox为字体工具的选择字体栏，fontSizeBox为字体大小选择栏
 * allButton中，前三个为颜色区，前景色、背景色和编辑颜色的按钮，后三个是字体区，加粗、下划线、斜体
 * allColor为颜色区，点击会使上方label改变颜色
 * 编辑颜色需要调用另外一个dialog对话框，以及相应的监听器
 * 
 *
 */

public class AllTool {
	JLabel[] allLabel;
	JComboBox<String> sizeBox;//原始类型的泛型无法构建数组，故分开传输
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
