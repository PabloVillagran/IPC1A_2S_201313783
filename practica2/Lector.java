package interfaz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Lector {
	String direccion, estacion;
	int idEstacion, kilometros;
	boolean nEstacion;
	ListaEnlazada lista = null;
	ListaEnlazada[] nLista = new ListaEnlazada[10];
	BufferedReader lectorArchivo;
	
	public Lector(String direccion){
		this.direccion = direccion;
		try {
			lectorArchivo = new BufferedReader(new FileReader(direccion));
			String linea;
			while(( linea = lectorArchivo.readLine().toLowerCase())!=null){
				if(!linea.isEmpty()){
					System.out.println(linea);
					comandos(linea);
				}
			}
			lectorArchivo.close();
		} catch (IOException e) {
			System.out.println("Error al abrir el archivo.");
		}
	}
	
	public void comandos(String linea){
		if(linea.contains("suben")){
			if(isComando(linea)){
				String temp[] = linea.split("\\s+");
				int pasajeros= Integer.valueOf(temp[1]);
				int clase = Integer.valueOf(temp[3]);
				if(clase == 1){
					lista.AgregarClaseI(pasajeros);
					/*if(lista.primerVagon != null){
						if((lista.BuscarClase(1).pasajeros)+pasajeros >10 || lista.primerVagon == null){
							
						}else{
							lista.BuscarClase(1).pasajeros+= pasajeros;
						}
					}*/
				}
				if(clase == 3){
					lista.AgregarClaseIII(pasajeros);
					/*if(lista.primerVagon != null){
						if((lista.BuscarClase(3).pasajeros)+pasajeros >40){
							lista.AgregarClaseIII(pasajeros);
						}else{
							lista.BuscarClase(3).pasajeros+= pasajeros;
						}
					}else{
						lista.AgregarClaseIII(pasajeros);
					}*/
				}
				while(kilometros > ((lista.ContarCarbon()*100) -(lista.Tamano()*10))){
					lista.AgregarCarbon();
				}
			}else{
				System.out.println("comando invalido");
			}
		}else if(linea.contains("bajan")){
			if(isComando(linea)){
				String temp[] = linea.split("\\s+");
				int pasajeros= Integer.valueOf(temp[1]);
				int clase = Integer.valueOf(temp[3]);
				if(clase == 1){
					/*if((lista.BuscarClase(1).pasajeros - pasajeros)>0 && lista.primerVagon!= null){
						
					}*/
				}
				if(clase == 3){
					/*if((lista.BuscarClase(3).pasajeros - pasajeros)>0 && lista.primerVagon!= null){
						
					}*/
				}
			}else{
				System.out.println("comando invalido");
			}
		}else if(isEstacion(linea)){
			String temp []= linea.split("\\s+");
			if(lista==null){
				lista = new ListaEnlazada(temp[0],temp[1],temp[2]);
			}else{
				ListaEnlazada t;
				for(int i =0;i<=nLista.length-2;i++){
					t = nLista[i];
					nLista[i]=lista;
					nLista[i+1]=t;
				}
				lista = new ListaEnlazada(temp[0],temp[1],temp[2]);
			}
		}else{
			System.out.println("Ingreso no valido.");
		}
	}
	
	public boolean isEstacion(String linea){
		boolean isEstacion=false;
		String temporal[];
		temporal = linea.split("\\s+");
		if(temporal.length == 3 && temporal[2].contains("km")){
			isEstacion = true;
		}
		nEstacion = false;
		return isEstacion;
	}
	
	public boolean isComando(String linea){
		boolean isComando=false;
		String temp[]=linea.split("\\s+");
		if(temp.length == 4 && temp[2].contains("clase") && 
				(temp[0].contains("suben") ^ temp[0].contains("bajan"))){
			isComando=true;
		}
		return isComando;
	}
	
	public boolean finEstacion(){
		
		return true;
	}
	
}
