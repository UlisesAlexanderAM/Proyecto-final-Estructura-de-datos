package Listas.PilaCola;

import Listas.ListasLigadas.ListaDoble;
import Listas.NodoLista;

public class Pila<T> extends ListaDoble<T> {
	T datoCima;
	public Pila() {
		super();
	}

	public Pila(T dato) {
		super(dato);
	}

	public void push(T dato) {
		insertar(new NodoLista<>(dato));
	}

	public T pop() {
		if (eliminar() == -1) {
			return null;
		} else
			return datoCima;
	}

	public int eliminar() {
		if (this.estaVacia())
			return -1;
		else {
			NodoLista<T> nodoTmp = cola.getPrevio().getPrevio();
			datoCima = cima();
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
