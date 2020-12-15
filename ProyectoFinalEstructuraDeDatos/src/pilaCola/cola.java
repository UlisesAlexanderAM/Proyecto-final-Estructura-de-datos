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
		nodoLista<T> nodoTmp = cabeza.getSiguiente();
		nodoTmp.setPrevio(nodo);
		nodo.setSiguiente(nodoTmp);
		nodo.setPrevio(cabeza);
		cabeza.setSiguiente(nodo);
		tamanio+=1;
	}

	public void push(T dato){
		insertar(new nodoLista<>(dato));
	}
}
