package interfaz;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Vagon{
	Canvas canvas;
	Vagon siguiente=null;
	int pasajeros, block, row,clase, idEstacion;
	
	public Vagon(){
		siguiente = null;
	}
	
	public Vagon(Canvas canvas){
		this.canvas = canvas;
		block = 0;
		row = 0;
		siguiente = null;
	}
	
	public Vagon(int pasajeros){
		this.pasajeros = pasajeros;
	}
	
	public int pasajeros(){  
		return pasajeros;
	}
	
	public void setBlock(int block){
		this.block = block;
	}
	
	public void setRow(int block){
		this.block = block;
	}
	
	public int getBlock(){
		return block;
	}
	
	public int getRow(){
		return row;
	}
	
	public void paint0(Graphics g){
		setBlock(127);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.RED);
		int[] x2={40,40,67,123,123},y2={119,85,60,60,119};
		g2d.fillPolygon( x2, y2, 5);
		g2d.setColor(Color.YELLOW);
		int[] x3={86,104,104,111,79,86},y3={60,60,45,36,36,45};
		g2d.fillPolygon( x3, y3, 6);
		g2d.setColor(Color.GRAY);
		g2d.fillOval(45, 101, 25, 25);
		g2d.fillOval(93, 101, 25, 25);
		g2d.setColor(Color.WHITE);
		g2d.fillRect(80, 70, 30, 25);
		g2d.setColor(Color.BLACK);
		g2d.fillRoundRect(120, 100, 15, 7, 15, 15);
		g2d.setColor(Color.LIGHT_GRAY);
		int[] x={7,40,40},y={119,119,92};
		g2d.fillPolygon( x, y, 3);
		g2d.setStroke(new BasicStroke(4));
		g2d.drawLine(55, 106, 105, 119);
	}
}
