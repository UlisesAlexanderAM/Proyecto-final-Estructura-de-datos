package listas.pilaCola;

import listas.listasEnlazadas.listaDoble;
import listas.listasEnlazadas.nodoLista;

public class pila<T> extends listaDoble<T> {
	public pila() {
		super();
	}

	public pila(nodoLista<T> nodo) {
		super(nodo);
	}

	public pila(T dato) {
		super(dato);
	}

	public void push(T dato) {
		insertar(new nodoLista<>(dato));
	}

	public T pop() {
		if (eliminar() == -1) {
			return null;
		} else
			return cima();
	}

	public int eliminar() {
		if (this.estaVacia())
			return -1;
		else {
			nodoLista<T> nodoTmp = cola.getPrevio().getPrevio();
			nodoTmp.setSiguiente(cola);
			cola.setPrevio(nodoTmp);
			tamanio -= 1;
			return 0;
		}
	}

	public T cima() {
		return ultimo();
	}
}
