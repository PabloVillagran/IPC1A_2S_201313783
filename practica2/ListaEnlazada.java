package interfaz;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class ListaEnlazada {
	
	public String nombre,idEstacion, distancia;
	public Vagon primerVagon;
	public int clase;

	public ListaEnlazada(String nombre, String id,String distancia){
		this.nombre = nombre;
		this.idEstacion = id;
		this.distancia = distancia.substring(0, distancia.indexOf("k"));
		primerVagon = null;
	}
	
	public void AgregarCarbon(){
		Carbon nuevoVagon = new Carbon();
		nuevoVagon.clase = 0;
		nuevoVagon.siguiente = primerVagon;
		primerVagon = nuevoVagon;
	}
	
	public void AgregarClaseIII(int pasajeros){
		IIIClase nuevoVagon = new IIIClase(pasajeros);
		nuevoVagon.clase = 3;
		nuevoVagon.siguiente = primerVagon;
		primerVagon = nuevoVagon;
	}
	
	public void AgregarClaseI(int pasajeros){
		IClase nuevoVagon = new IClase(pasajeros);
		nuevoVagon.clase = 1;
		nuevoVagon.siguiente = primerVagon;
		primerVagon = nuevoVagon;
	}
	
	public Vagon BuscarClase(int clase){
		Vagon referencia = primerVagon;
		if(primerVagon!= null){
			while(referencia.clase!=clase){
				referencia=referencia.siguiente;
			}
		}else{
			System.out.println("lista vacia");
		}
		return referencia;
	}

	public Vagon BuscarID(int idEstacion){
		Vagon referencia = primerVagon;
		if(primerVagon!= null){
			while(referencia.idEstacion!=idEstacion){
				referencia=referencia.siguiente;
			}
		}else{
			System.out.println("lista vacia");
		}
		return referencia;
	}
	
	public void Agregar(int pasajeros, int posicion){
		int actual=1;
		Vagon nuevoVagon = new Vagon(pasajeros);
		Vagon temporal = primerVagon;
		while(posicion > actual){
			if(temporal.siguiente !=null){
				temporal = temporal.siguiente;
				actual++;
			}else{
				actual = posicion;
			}
		}
		nuevoVagon.siguiente = temporal;
	}
	
	public void EliminarInicial(){
		if(primerVagon != null){
			primerVagon = primerVagon.siguiente;
		}else{
			System.out.println("Lista vacia");
		}		
	}
		
	public void EliminarFinal(){
		Vagon vagon = primerVagon;
		while(vagon != null){
			vagon = vagon.siguiente;
			if(vagon.siguiente == null){
				vagon = null;
			}
		}
	}

	public void Eliminar(int posicion){
		Vagon actual = primerVagon, previo = null;
		int pActual=1;
		if(actual!=null){
			while(posicion >= pActual){
				if(posicion == pActual){
					if(previo == null){
						primerVagon = primerVagon.siguiente;
					}else{						
						previo.siguiente = actual.siguiente;
					}
					break;
				}else{
					previo = actual;
					actual = actual.siguiente;
					posicion++;
				}
			}
		}else{
			System.out.println("no existe una lista");
		}
		
	}
	
	public int Tamano(){
		Vagon vagonC = primerVagon;
		int tamano=0;
		while(vagonC != null){
			tamano++;
			vagonC = vagonC.siguiente;
		}
		return tamano;
	}
	
	public int ContarCarbon(){
		int carbon = 0;
		Vagon temp = primerVagon;
		while(temp != null){
			if(temp.clase == 0){
				carbon++;
			}
			temp=temp.siguiente;
		}
		return carbon;
	}
	
	public void Imprimir(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		Vagon vagonc = primerVagon;
		if(vagonc != null){
			while(vagonc != null){
				vagonc.paint0(g2d);
				vagonc=vagonc.siguiente;
			}
		}else{
			System.out.println("Lista vacia!");
		}
	}
	public static void main(String args[]){
		ListaEnlazada lista = new ListaEnlazada("estacion","id","200km");
		lista.AgregarClaseIII(5);
		lista.AgregarClaseI(10);
		lista.AgregarCarbon();
		lista.AgregarCarbon();
		lista.AgregarCarbon();
		System.out.println(lista.BuscarClase(1).pasajeros);
		System.out.println(lista.ContarCarbon());
	}
}
