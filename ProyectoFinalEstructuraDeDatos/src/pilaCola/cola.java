package pilaCola;

import listas.listaDoble;
import listas.nodoLista;

public class cola<T> extends listaDoble<T> {
	public cola() {
	}

	public cola(T dato) {
		super(dato);
	}

	public cola(nodoLista<T> nodo) {
		super(nodo);
	}

	@Override
	public void insertar(nodoLista<T> nodo) {
	}
}
