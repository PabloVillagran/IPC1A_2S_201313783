package interfaz;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class Interfaz extends JFrame{
	private JMenuBar menu = new JMenuBar();
	private NewCanvas canvas;
	String estacionActual = "Estacion: ";
	String direccionArchivo = "C:\\Users\\PabloDaniel\\Desktop\\estructura.txt";
	Lector lector = null;
	ListaEnlazada mLista[];
	int count=1;
	
	public Interfaz(){
		super("Train Sim X");
		setLayout(null);
		setBounds(0,0,400,400);
		
		//barra de menu
		setJMenuBar(menu);
		JMenu archivo = new JMenu("Archivo");
		JMenuItem abrir = new JMenuItem("Abrir");
		archivo.add(abrir);
		abrir.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JFileChooser archivoAbrir = new JFileChooser();
				archivoAbrir.showOpenDialog(null);
				try{
					direccionArchivo = archivoAbrir.getSelectedFile().getPath();
					lector = new Lector(direccionArchivo);
					mLista = lector.nLista;
				}catch(NullPointerException n){
					System.out.println("NULL");
				}
			}
		});
		menu.add(archivo);
		
		//Nombre de la estacion
		JLabel estacion = new JLabel(estacionActual);
		estacion.setBounds(5,5,300,28);
		add(estacion);
		
		//Canvas
		canvas = new NewCanvas();
		canvas.setBounds(5,35,400,235);
		canvas.setBackground(this.getBackground());
		add(canvas);
		
		//Botones
		JButton avanzar = new JButton("Avanzar");
		JButton retroceder = new JButton("Retroceder");
		retroceder.setBounds(235,280,150,50);
		avanzar.setBounds(70,280,150,50);
		avanzar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				canvas.setLista(mLista[count]);
				if(count < mLista.length){
					count++;
				}
			}
		});
		retroceder.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println(canvas);
				System.out.println(mLista);
				canvas.setLista(mLista[count]);
				if(count != 0){
					count--;
				}
			}
		});
		add(avanzar); add(retroceder);
	}
	
	public static void main(String args[]){
		Interfaz inter = new Interfaz();
		inter.setLocationRelativeTo(null);
		inter.setResizable(false);
		inter.setDefaultCloseOperation(Interfaz.EXIT_ON_CLOSE);
		inter.setVisible(true);
	}
	
}
