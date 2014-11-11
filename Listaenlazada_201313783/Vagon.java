
public class Vagon{
	Vagon siguiente;
	int cantidadPasajeros;
	
	public Vagon(){
		siguiente = null;
	}
	
	public Vagon(int cantidadPasajeros){
		this.cantidadPasajeros = cantidadPasajeros;
	}
	
	public int pasajeros(){  
		return cantidadPasajeros;
	}
}
