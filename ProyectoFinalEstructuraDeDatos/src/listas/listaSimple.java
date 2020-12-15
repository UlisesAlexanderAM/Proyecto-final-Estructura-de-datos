package listas;

public class listaSimple <T> extends listaDoble<T>{

	public listaSimple() {
		super();
	}

	public listaSimple(nodoLista<T> nodo){
		super(nodo);
	}

	@Override
	public void eliminar(nodoLista<T> nodo) {
		;
	}

	@Override
	public void vaciar() {
		cabeza.setSiguiente(null);
	}
}
