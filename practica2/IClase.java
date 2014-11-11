package interfaz;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class IClase extends Vagon {
	final int CANTIDAD_PASAJEROS = 10;
	
	public IClase(int pasajeros) {
		super(pasajeros);
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
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(34,177,76));
		g2d.fillRect(x+9, y+71, 96, 46);
		g2d.setColor(Color.GRAY);
		g2d.fillOval(x+13, y+105, 23, 23);
		g2d.fillOval(x+81, y+105, 23, 23);
		g2d.setColor(Color.LIGHT_GRAY);
		int[]x1={x,x+114,x+105,x+9},y1={y+71,y+71,y+60,y+60};
		g2d.fillPolygon(x1,y1,4);
		g2d.setColor(Color.blue);
		g2d.fillRect(x+16, y+80, 82, 13);
	}
}
