package interfaz;

public class ListaEnlazada {
	
	public Vagon primerVagon; //Nodo
	public int pasajeros;
	
	public ListaEnlazada(){
		primerVagon = null;
	}
	
	public void Agregar(){
		Vagon nuevoVagon = new Vagon(pasajeros);
		nuevoVagon.siguiente = primerVagon;
		primerVagon = nuevoVagon;
	}
	
	public void Agregar(int posicion){
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
	
	public void Imprimir(){
		Vagon vagonc = primerVagon;
		if(vagonc != null){
			int posicion=1;
			while(vagonc != null){
				System.out.println("Vagon "+posicion+" contiente "+vagonc.pasajeros()+" pasajeros.");
				posicion++;
			}
		}else{
			System.out.println("Lista vacia!");
		}
	}
	
}
