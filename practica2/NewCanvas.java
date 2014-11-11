package interfaz;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

class NewCanvas extends Canvas{
	
	ListaEnlazada lista = null;
	void setLista(ListaEnlazada lista){
		this.lista = lista;
		System.out.println(lista);
		repaint();
	}
	
	@Override
	public void paint(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.scale(0.5, 0.5);
		g2d.setColor(Color.orange.darker());
		for(int y =126; y < getHeight();y+=127)	g2d.fillRect(0, y, 800, 10);
		new Vagon(this).paint0(g);
		if(lista != null)lista.Imprimir(g2d);
		/*new Carbon(0).paint0(g);
		new IClase(5,0).paint0(g);
		new IIIClase(10,0).paint0(g);*/
	}
}