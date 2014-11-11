package ExamenFinalJava;

import java.io.*;

import javax.swing.*;

public class MaestroYoda201313783 {
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
			//int number = Integer.parseInt(br.readLine());
			String line;
			int caso = 0;
			while((line=br.readLine())!=null){
				caso++;
				String words[]=line.split(" ");
				line="Caso #"+caso+": ";
				for(int i=words.length-1;i>=0;i--){
					line = line+" "+words[i];
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

	public static void main(String[] args) {
		MaestroYoda201313783 maestro = new MaestroYoda201313783();
		maestro.leerArchivo();
		System.out.println(maestro.outPut.getPath());
	}

}
