package ExamenFinalJava;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

public class Numeros201313783 {
	
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
			String origiline;
			int caso = 0;
			while((origiline=br.readLine())!=null){
				caso++;
				String line="Caso #"+caso+": " + String.valueOf(matematica(origiline))+"\r\n";
				bw.write(line);
			}
			bw.close();
			br.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public String matematica(String line){
		double resultado = 0;
		double CONSTANT = (3+ Math.sqrt(5));
		int numero = Integer.parseInt(line);
		resultado =(numero*CONSTANT);
		String a = String.valueOf(resultado/1000);
		int index = a.indexOf(".")+1;
		String b= a.substring(index,index+3);
		//resultado = Integer.parseInt(b);
		return b;
	}
	
	public static void main(String args[]){
		Numeros201313783 numeros = new Numeros201313783();
		numeros.leerArchivo();
	}
}
