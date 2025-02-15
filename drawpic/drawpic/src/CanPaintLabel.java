import java.awt.*;
import java.awt.image.*;
import java.util.*;
import javax.swing.*;

/**
 * 
 * @author ASUS
 *
 * @time 下午5:36:30
 *
 * @description 代替canvas用来绘图的板子，部分功能实现在BorderListener中
 *
 */

@SuppressWarnings("serial")
public class CanPaintLabel extends JLabel{
	private static final double pi = 3.1415926535;//用以求取曲线的起始角
	int selectButton;//选择的工具
	int oldtimes;//记录的原始倍数
	int times;//放大倍数
	int x,y;//绘图的终止位置
	int x1,y1;//绘图的起始位置，多功能引用，不局限于此
	int size;//画笔大小
	Color fore;//前景色
	Color back;//背景色
	int flag;//用以判断是否需要paint其他的组件
	BufferedImage image;//原始图像，随label本身变化及绘图而变化
	Graphics2D bg;//image的画笔
	BufferedImage teImage;//临时图像缓存区，用于存储可移动图像部分
	Graphics2D gg;//teImage的画笔
	int temx,temy,temw,temh;//记录teImage存在时在该组件中的位置，用以更新时绘图
	
	public CanPaintLabel() {//初始化参数，之后会传入部分重要参数进行更改
		//在这里传入参数,可以自己设定一些参数
		setOpaque(true);//设置不透明
		setBackground(Color.WHITE);//设置背景色为白色
		setPreferredSize(new Dimension(1000,500));//设置原始大小为1000x500
		selectButton = 9; times = 1;oldtimes = 1;//根据界面初始值，设置初始选定及其他组件状态
		x = 0; y = 0;
		x1 = 0; y1 = 0;
		size = 3;
		fore = new Color(0,0,0);
		back = new Color(255,255,255);
		flag = -1;
		image = new BufferedImage(1000,500,BufferedImage.TYPE_INT_RGB);//设置RGB形式的图像
		bg = (Graphics2D)image.getGraphics();//得到画笔
		bg.setColor(back);
		bg.fillRect(0, 0, image.getWidth(), image.getHeight());//填充初始背景为白色
		bg.setColor(fore);
		teImage = null;//设定临时区图像为空
		gg = null;
	}
	
	public void setProperty(int se,int ti,int si,Color fore,Color ba) {//设定重要参数
		selectButton = se; times = ti;oldtimes = ti;//所选组件、倍数
		size = si;//组件大小
		this.fore = fore;//前景色
		back = ba;//背景色
	}
	@Override
    public void paintComponent(Graphics g1) {
		//在这里绘制我们想要的东西,可以通过updateUI()更新图像
		super.paintComponent(g1);//g1是系统调用时所用的画笔，我们在绘图时不用，最后将整个图片绘制到组件上才用到
		if(flag == 1 ) {//触发事件
			switch(selectButton) {//刷子
			case 0:{
				bg.setColor(fore);
				Stroke s = new BasicStroke(3*size+1);//就是大一点的铅笔
				bg.setStroke(s);
				bg.drawLine(x1, y1, x, y);//将之前保存的点与当前点连接起来，否则系统返回的点是不连续的，会出现断点位置
				x1 = x;//记录当前的位置用于下一轮调用
				y1 = y;
				break;
				}
			case 1:{//圆形
				int sx=0;
				int sy=0;
				if(x1>x) {//此处用于找到左上的端点
					sx = x;
				}
				else {
					sx = x1;
				}
				if(y1>y) {
					sy = y;
				}
				else {
					sy = y1;
				}
				teImage = new BufferedImage(Math.abs(x-x1)+5,Math.abs(y-y1)+5,
						BufferedImage.TYPE_INT_ARGB);//开辟临时图像区
				gg = (Graphics2D)teImage.getGraphics();
				gg.setColor(Color.BLACK);
				for(int i=1;i<=5;i=i+2) {//设置边框
					gg.drawLine(teImage.getWidth()*(i-1)/5, 0, teImage.getWidth()*i/5, 0);
					gg.drawLine(teImage.getWidth()*(i-1)/5, teImage.getHeight()-1,
							teImage.getWidth()*i/5, teImage.getHeight()-1);
					gg.drawLine(0, teImage.getHeight()*(i-1)/5, 0, teImage.getHeight()*i/5);
					gg.drawLine(teImage.getWidth()-1, teImage.getHeight()*(i-1)/5, 
							teImage.getWidth()-1, teImage.getHeight()*i/5);
				}
				Stroke s = new BasicStroke(size*2-1);//设置粗细
				gg.setStroke(s);
				gg.setColor(fore);
				gg.drawOval(2+size, 2+size, teImage.getWidth()-5-2*size, teImage.getHeight()-5-2*size);
				temx = sx-2;temy = sy-2;temw = teImage.getWidth();temh = teImage.getHeight();//记录绘制的图像位置，以便于后方调用
				break;
			}
			case 2:{//圆角矩形,大部分与圆形相同
				int sx=0;
				int sy=0;
				if(x1>x) {//找左上点
					sx = x;
				}
				else {
					sx = x1;
				}
				if(y1>y) {
					sy = y;
				}
				else {
					sy = y1;
				}
				teImage = new BufferedImage(Math.abs(x-x1)+5,Math.abs(y-y1)+5,
						BufferedImage.TYPE_INT_ARGB);//同上
				gg = (Graphics2D)teImage.getGraphics();
				gg.setColor(Color.BLACK);
				for(int i=1;i<=5;i=i+2) {
					gg.drawLine(teImage.getWidth()*(i-1)/5, 0, teImage.getWidth()*i/5, 0);
					gg.drawLine(teImage.getWidth()*(i-1)/5, teImage.getHeight()-1,
							teImage.getWidth()*i/5, teImage.getHeight()-1);
					gg.drawLine(0, teImage.getHeight()*(i-1)/5, 0, teImage.getHeight()*i/5);
					gg.drawLine(teImage.getWidth()-1, teImage.getHeight()*(i-1)/5, 
							teImage.getWidth()-1, teImage.getHeight()*i/5);
				}
				Stroke s = new BasicStroke(2*size-1);
				gg.setStroke(s);
				gg.setColor(fore);
				gg.drawRoundRect(2+size, 2+size, teImage.getWidth()-5-2*size, teImage.getHeight()-5-2*size,
						(teImage.getWidth()-5)/5,(teImage.getHeight()-5)/5);
				temx = sx-2;temy = sy-2;temw = teImage.getWidth();temh = teImage.getHeight();
				break;
			}
			case 4:{//曲线
				int sx=0;
				int sy=0;
				if(x1>x) {
					sx = x;
				}
				else {
					sx = x1;
				}
				if(y1>y) {
					sy = y;
				}
				else {
					sy = y1;
				}
				teImage = new BufferedImage(Math.abs(x-x1)+5,Math.abs(y-y1)+5,
						BufferedImage.TYPE_INT_ARGB);
				gg = (Graphics2D)teImage.getGraphics();
				gg.setColor(Color.BLACK);
				for(int i=1;i<=5;i=i+2) {
					gg.drawLine(teImage.getWidth()*(i-1)/5, 0, teImage.getWidth()*i/5, 0);
					gg.drawLine(teImage.getWidth()*(i-1)/5, teImage.getHeight()-1,
							teImage.getWidth()*i/5, teImage.getHeight()-1);
					gg.drawLine(0, teImage.getHeight()*(i-1)/5, 0, teImage.getHeight()*i/5);
					gg.drawLine(teImage.getWidth()-1, teImage.getHeight()*(i-1)/5, 
							teImage.getWidth()-1, teImage.getHeight()*i/5);
				}
				Stroke s = new BasicStroke(2*size-1);
				gg.setStroke(s);
				gg.setColor(fore);
				double tr;
				if(x1-x == 0) {
					if(y1-y >0) {
						tr = pi/2;
					}
					else if(y1-y < 0) {
						tr = -pi/2;
					}
					else {
						tr = 0;
					}
					gg.drawArc(2+size, 2+size, teImage.getWidth()-5-2*size, teImage.getHeight()-5-2*size,
							(int)(180*tr/pi),180);
				}
				else if(y1-y == 0) {
					tr = 0;
					gg.drawArc(2+size, 2+size, teImage.getWidth()-5-2*size, teImage.getHeight()-5-2*size,
							(int)(180*tr/pi),180);
				}
				else {//此处为了让拖动时,四个方向的弧线均不同
					tr = -Math.atan(((double)(y1-y))/(x1-x));
					gg.drawArc(2+size, 2+size, teImage.getWidth()-5-2*size, teImage.getHeight()-5-2*size,
						(int)(180*tr/pi)*((x1-x)/Math.abs(x1-x)),
						180*((x1-x)/Math.abs(x1-x))*((y1-y)/Math.abs(y1-y)));
				}
				
				temx = sx-2;temy = sy-2;temw = teImage.getWidth();temh = teImage.getHeight();
				break;
			}
			case 5:{//橡皮
				bg.setColor(back);
				Stroke s = new BasicStroke(2*size+1);
				bg.setStroke(s);
				bg.drawLine(x1, y1, x, y);
				x1 = x;
				y1 = y;
				break;
				}
			case 6:{//填色桶,可能能再次更新为速度更快的算法,当前涂色有延迟
				int[] rgb = new int[3];
				int pixel = image.getRGB(x1,y1);
				rgb[0] = (pixel & 0xff0000) >> 16;
				rgb[1] = (pixel & 0xff00) >> 8;
				rgb[2] = (pixel & 0xff);
				if(!fore.equals(new Color(rgb[0],rgb[1],rgb[2]))) {
					fill(x1,y1,new Color(rgb[0],rgb[1],rgb[2]));//种子填充算法
				}
				break;
			}
			case 7:{//放大镜
				BufferedImage te = new BufferedImage(image.getWidth()*times/oldtimes,
						image.getHeight()*times/oldtimes,BufferedImage.TYPE_INT_RGB);
				Graphics2D tee = (Graphics2D)te.getGraphics();
				tee.scale(((double)times)/oldtimes, ((double)times)/oldtimes);//放大倍数
				tee.drawImage(image, 0, 0, null);//以放大倍数来绘制在另一临时区
				image = te;
				bg = tee;
				oldtimes = times;
				break;
			}
			case 8:{//直线
				int sx=0;
				int sy=0;
				if(x1>x) {
					sx = x;
				}
				else {
					sx = x1;
				}
				if(y1>y) {
					sy = y;
				}
				else {
					sy = y1;
				}
				teImage = new BufferedImage(Math.abs(x-x1)+5,Math.abs(y-y1)+5,
						BufferedImage.TYPE_INT_ARGB);
				gg = (Graphics2D)teImage.getGraphics();
				gg.setColor(Color.BLACK);
				for(int i=1;i<=5;i=i+2) {
					gg.drawLine(teImage.getWidth()*(i-1)/5, 0, teImage.getWidth()*i/5, 0);
					gg.drawLine(teImage.getWidth()*(i-1)/5, teImage.getHeight()-1,
							teImage.getWidth()*i/5, teImage.getHeight()-1);
					gg.drawLine(0, teImage.getHeight()*(i-1)/5, 0, teImage.getHeight()*i/5);
					gg.drawLine(teImage.getWidth()-1, teImage.getHeight()*(i-1)/5, 
							teImage.getWidth()-1, teImage.getHeight()*i/5);
				}
				Stroke s = new BasicStroke(2*size-1);
				gg.setStroke(s);
				gg.setColor(fore);
				gg.drawLine(x1 - (Math.min(x1, x)-3), y1 - (Math.min(y1, y)-3),
						x - (Math.min(x1, x)-3),  y - (Math.min(y1, y)-3));
				temx = sx-2;temy = sy-2;temw = teImage.getWidth();temh = teImage.getHeight();
				break;
			}
			case 9:{//铅笔
				bg.setColor(fore);
				Stroke s = new BasicStroke(size);
				bg.setStroke(s);
				bg.drawLine(x1, y1, x, y);
				x1 = x;
				y1 = y;
				break;
				}
			case 10:{//矩形
				int sx=0;
				int sy=0;
				if(x1>x) {
					sx = x;
				}
				else {
					sx = x1;
				}
				if(y1>y) {
					sy = y;
				}
				else {
					sy = y1;
				}
				teImage = new BufferedImage(Math.abs(x-x1)+5,Math.abs(y-y1)+5,
						BufferedImage.TYPE_INT_ARGB);
				gg = (Graphics2D)teImage.getGraphics();
				gg.setColor(Color.BLACK);
				for(int i=1;i<=5;i=i+2) {
					gg.drawLine(teImage.getWidth()*(i-1)/5, 0, teImage.getWidth()*i/5, 0);
					gg.drawLine(teImage.getWidth()*(i-1)/5, teImage.getHeight()-1,
							teImage.getWidth()*i/5, teImage.getHeight()-1);
					gg.drawLine(0, teImage.getHeight()*(i-1)/5, 0, teImage.getHeight()*i/5);
					gg.drawLine(teImage.getWidth()-1, teImage.getHeight()*(i-1)/5, 
							teImage.getWidth()-1, teImage.getHeight()*i/5);
				}
				Stroke s = new BasicStroke(2*size-1);
				gg.setStroke(s);
				gg.setColor(fore);
				gg.drawRect(2+size, 2+size, teImage.getWidth()-5-2*size, teImage.getHeight()-5-2*size);
				temx = sx-2;temy = sy-2;temw = teImage.getWidth();temh = teImage.getHeight();
				break;
			}
			case 11:{//选定框
				if(x>this.getPreferredSize().width) {//保证选定框不能在画布的范围外
					x = this.getPreferredSize().width;
				}
				else if(x<0) {
					x = 0;
				}
				if(y>this.getPreferredSize().height) {
					y = this.getPreferredSize().height;
				}
				else if(y<0) {
					y = 0;
				}
				int sx=0;
				int sy=0;
				if(x1>x) {//找左上角点
					sx = x;
				}
				else {
					sx = x1;
				}
				if(y1>y) {
					sy = y;
				}
				else {
					sy = y1;
				}
				teImage = new BufferedImage(Math.abs(x-x1)+5,Math.abs(y-y1)+5,
						BufferedImage.TYPE_INT_ARGB);
				gg = (Graphics2D)teImage.getGraphics();
				gg.setColor(Color.BLACK);
				for(int i=1;i<=5;i=i+2) {//绘制选定框边框
					gg.drawLine(teImage.getWidth()*(i-1)/5, 0, teImage.getWidth()*i/5, 0);
					gg.drawLine(teImage.getWidth()*(i-1)/5, teImage.getHeight()-1,
							teImage.getWidth()*i/5, teImage.getHeight()-1);
					gg.drawLine(0, teImage.getHeight()*(i-1)/5, 0, teImage.getHeight()*i/5);
					gg.drawLine(teImage.getWidth()-1, teImage.getHeight()*(i-1)/5, 
							teImage.getWidth()-1, teImage.getHeight()*i/5);
				}
				temx = sx-2;temy = sy-2;temw = teImage.getWidth();temh = teImage.getHeight();
				break;
			}
			case 12:{//喷枪
				int rx;
				int ry;
				bg.setColor(fore);
				for(int i=0;i<50;i++) {
					rx = (int)(Math.random()*(size+1)*5/2)-1;//选取50个随机点
					ry = (int)(Math.random()*(size+1)*5/2)-1;
					bg.drawLine(x+rx, y+ry, x+rx, y+ry);//循环绘制一个点，连续绘制50个
				}
				break;
			}
			default:break;
			}
		}
		else if(flag == 0){//此处为画布边框被拖动时准备
			BufferedImage temp = new BufferedImage(this.getPreferredSize().width,
					this.getPreferredSize().height,BufferedImage.TYPE_INT_RGB);
			Graphics2D te = (Graphics2D)temp.getGraphics();//创建与原画布相同类型的画布
			te.setColor(back);
			te.fillRect(0, 0, temp.getWidth(), temp.getHeight());//设置背景色
			if(this.getPreferredSize().width>image.getWidth()&&
					this.getPreferredSize().height>image.getHeight()) {//原画布大小比组件小
				te.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
			}
			else if(this.getPreferredSize().width>image.getWidth()&&
					this.getPreferredSize().height<=image.getHeight()) {//原画布比组件高
				BufferedImage a = image.getSubimage(0, 0, image.getWidth(),//截取对应部分
						this.getPreferredSize().height);
				te.drawImage(a, 0, 0, a.getWidth(), a.getHeight(), null);
			}
			else if(this.getPreferredSize().width<=image.getWidth()&&
					this.getPreferredSize().height>image.getHeight()) {//原画布比组件宽
				BufferedImage a = image.getSubimage(0, 0, 
						this.getPreferredSize().width,image.getHeight());//截取对应部分
				te.drawImage(a, 0, 0, a.getWidth(), a.getHeight(), null);
			}
			else {
				BufferedImage a = image.getSubimage(0, 0, 
						this.getPreferredSize().width,this.getPreferredSize().height);
				te.drawImage(a, 0, 0, a.getWidth(), a.getHeight(), null);
			}
			image = temp;//覆盖原对象
			bg = te;//覆盖原画笔
		}
		g1.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);//系统将原图像绘制到组件上
		if(teImage != null) {//如果有临时图像则绘制到对应位置
			g1.drawImage(teImage, temx, temy, temw, temh, null);
		}
	}
	private void fill(int xx,int yy,Color co) {//种子填充算法，用于填色桶
		//此为4-连通种子填充法，测试过比8-连通的要快，且不会错涂
		Vector<Point> tete = new Vector<Point>();//记录被涂色点的上下左右的点的位置
		tete.addElement(new Point(xx,yy));//起始点添加
		while(!tete.isEmpty()) {//当内部所有该涂的点全部被涂完
			int[] rgb = new int[3];
			int pixel = image.getRGB(tete.get(0).x,tete.get(0).y);
			rgb[0] = (pixel & 0xff0000) >> 16;
			rgb[1] = (pixel & 0xff00) >> 8;
			rgb[2] = (pixel & 0xff);
			if(co.equals(new Color(rgb[0],rgb[1],rgb[2]))) {//判断该点是否可涂
				//可涂
				image.setRGB(tete.get(0).x,tete.get(0).y,fore.getRGB());//涂色
				//添加其上下左右的点的坐标
				if(tete.get(0).x>0) {
					tete.addElement(new Point(tete.get(0).x-1,tete.get(0).y));
				}
				if(tete.get(0).x<image.getWidth()-1) {
					tete.addElement(new Point(tete.get(0).x+1,tete.get(0).y));
				}
				if(tete.get(0).y>0) {
					tete.addElement(new Point(tete.get(0).x,tete.get(0).y-1));
				}
				if(tete.get(0).y<image.getHeight()-1) {
					tete.addElement(new Point(tete.get(0).x,tete.get(0).y+1));
				}
			}
			tete.remove(0);//清除vector的第一位的元素，以支持循环可结束
		}
	}
}
