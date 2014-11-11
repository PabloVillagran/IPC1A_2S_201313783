public class Prueba{
	private ListaEnlazada lista;
	
	public static void main(String args[]){
		Prueba prueba = new Prueba();
	}
	
	public Prueba(){
		lista = new ListaEnlazada();		
		lista.Agregar(5);
		lista.Agregar(20);
		lista.Agregar(3);
		lista.Agregar(75, 3);
		lista.Agregar(8, 1);
		System.out.println("La lista es: ");
		lista.Imprimir();
		System.out.println("y tiene "+ lista.Tamano()+" elementos.");
		lista.EliminarInicial();
		lista.EliminarFinal();
		lista.Eliminar(3);
		System.out.println("La lista ahora es: ");
		lista.Imprimir();
	}
	
}