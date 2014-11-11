package interfaz;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Carbon extends Vagon{
	final int KILOMETROS = 100;
	
	public Carbon(){
		this.idEstacion = idEstacion;
	}
	
	@Override
	public void paint0(Graphics g){
		int x=getBlock(), y=getRow();
		if(x <= 674){
			setBlock(x+=125);
		}else{
			setBlock(x=7);
			setRow(y+=128);
		}
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(new Color(87,44,0));
		g2d.fillRect(x+9,y+79, 96, 38);
		g2d.setColor(Color.black);
		int[]x2={x+10,x+9,x+41,x+53,x+64,x+77,x+104},y2={y+67,y+49,y+56,y+48,y+56,y+48,y+67};
		g2d.fillPolygon(x2, y2, 7);
		g2d.setColor(Color.LIGHT_GRAY);
		int[]xPoints={x,x+9,x+105,x+114},yPoints={y+68,y+79,y+79,y+68};
		g2d.fillPolygon(xPoints, yPoints, 4);
		g2d.setColor(Color.gray);
		g2d.fillOval(x+13, y+105, 23, 23);
		g2d.fillOval(x+81, y+105, 23, 23);
	}
	
}
