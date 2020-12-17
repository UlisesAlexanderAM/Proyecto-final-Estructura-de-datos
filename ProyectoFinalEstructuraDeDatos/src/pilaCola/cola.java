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

	public int eliminar() {
		nodoLista<T> nodoTmp = cabeza.getSiguiente().getSiguiente();
		cabeza.setSiguiente(nodoTmp);
		nodoTmp.setPrevio(cabeza);
		return 0;
	}


}
