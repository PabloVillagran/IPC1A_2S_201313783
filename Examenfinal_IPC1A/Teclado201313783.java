package ExamenFinalJava;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

public class Teclado201313783 {
	
	BufferedWriter bw;
	File outPut;
	
	public void leerArchivo(){
		JFileChooser fc = new JFileChooser();
		fc.showOpenDialog(null);
		File file = fc.getSelectedFile();
		String outDir = fc.getSelectedFile().getPath().replace("Input", "Output");
		outPut = new File(outDir.replace(".txt", "_201313783.txt"));
		try{
			BufferedReader br = new BufferedReader(new FileReader(file));
			bw= new BufferedWriter(new FileWriter(outPut));
			int number = Integer.parseInt(br.readLine());
			String line;
			int caso = 0;
			while((line=br.readLine())!=null){
				caso++;
				String letters[]=line.split("");
				line="Caso #"+caso+": ";
				for(int i=0;i<letters.length;i++){
					line= line + pressed(letters[i]);
				}
				line = line+"\r\n";
				bw.write(line);
			}
			bw.close();
			br.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public String pressed(String letter){
		String press=" ";
		switch (letter){
		case"a":press="2";break;
		case"b":press="22";break;
		case"c":press="222";break;
		case"d":press="3";break;
		case"e":press="33";break;
		case"f":press="333";break;
		case"g":press="4";break;
		case"h":press="44";break;
		case"i":press="444";break;
		case"j":press="5";break;
		case"k":press="55";break;
		case"m":press="555";break;
		case"n":press="6";break;
		case"l":press="66";break;
		case"o":press="666";break;
		case"p":press="7";break;
		case"q":press="77";break;			
		case"r":press="777";break;			
		case"s":press="7777";break;
		case"t":press="8";break;
		case"u":press="88";break;
		case"v":press="888";break;
		case"w":press="9";break;
		case"x":press="99";break;
		case"y":press="999";break;
		case"z":press="9999";break;
		default:press=" ";
		}
		return press;
	}
	
	public static void main(String args[]){
		Teclado201313783 teclado = new Teclado201313783();
		teclado.leerArchivo();
	}
}
