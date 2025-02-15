import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.*;
import javax.swing.filechooser.FileFilter;

/**
 * 
 * @author ASUS
 *
 * @time 下午10:55:08
 *
 * @description 打开文件监听器
 *
 */

public class OpenListener implements ActionListener{
	MyFrame frame;
	CanPaintLabel a;
	AllMenu b;
	public OpenListener(MyFrame frame,CanPaintLabel a,AllMenu b) {
		this.frame = frame;
		this.a = a;
		this.b = b;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(frame.name != null) {
			int result = JOptionPane.showConfirmDialog(frame.frame, "是否保存您所作的更改?","保存",
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if(result == JOptionPane.OK_OPTION){
            	String[] tem = frame.name.split("\\.");
            	String tee = tem[tem.length-1];
            	try {
					ImageIO.write(a.image,tee,new File(frame.name));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
		}
		JFileChooser fileChooser = new JFileChooser();// 创建文件选择对话框
		FileFilter filter = new FileNameExtensionFilter("图像文件（JPG/JPEG/PNG）", "JPG", "JPEG","PNG");// 设置文件过滤器，只列出JPG或PNG格式的图片
		fileChooser.setFileFilter(filter);
		while(true) {
			int j = fileChooser.showOpenDialog(frame.frame);// 显示文件选择对话框
			// 判断用户单击的是否为“打开”按钮
			if (j == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();// 获得选中的图片对象
				if(!(new File(selectedFile.getAbsolutePath()).exists())) {
					JOptionPane.showMessageDialog(fileChooser, 
							selectedFile.getAbsolutePath()+" 不存在，请重新选择。");
				}
				else {
					try {
						a.image = ImageIO.read(new File(selectedFile.getAbsolutePath()));
						a.bg = (Graphics2D)a.image.getGraphics();//得到画笔
						a.setPreferredSize(new Dimension(a.image.getWidth(),a.image.getHeight()));
						a.teImage = null;
						a.gg = null;
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						a.image = new BufferedImage(1000,500,BufferedImage.TYPE_INT_RGB);//设置RGB形式的图像
						a.bg = (Graphics2D)a.image.getGraphics();//得到画笔
						a.bg.setColor(Color.WHITE);
						a.bg.fillRect(0, 0, a.image.getWidth(), a.image.getHeight());//填充初始背景为白色
						a.setPreferredSize(new Dimension(1000,500));
						a.teImage = null;
						a.gg = null;
					}
					frame.name = selectedFile.getAbsolutePath();
					frame.undo.clear();
					frame.undo.addElement(a.image);
					frame.redo.clear();
					frame.cutboard = null;
					for(int i=5;i<=9;i++) {
						b.allMenuItem[i].setEnabled(false);
					}
					a.updateUI();
					break;
				}
			}
			else {
				break;
			}
		}
	}
}
