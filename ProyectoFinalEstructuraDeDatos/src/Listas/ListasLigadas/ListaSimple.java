package Listas.ListasLigadas;

import Listas.NodoLista;

public class ListaSimple<T> extends ListaLigada<T> {

	protected NodoLista<T> cabeza;
	protected NodoLista<T> cola;
	protected int tamanio;


	public ListaSimple() {
		super();
	}

	public ListaSimple(T dato) {
		super(dato);
	}

	@Override
	public void insertar(NodoLista<T> nodo) {
		if (tamanio == 0) {
			cabeza.setSiguiente(nodo);
		} else {
			NodoLista<T> nodoTmp = cola.getPrevio();
			nodoTmp.setSiguiente(nodo);
		}
		nodo.setSiguiente(cola);
		cola.setPrevio(nodo);
		tamanio += 1;
	}

	@Override
	public void eliminar(NodoLista<T> nodo) {
		NodoLista<T> nodoPrevio = buscarDatoPrevio(nodo.getDato());
		NodoLista<T> nodoSiguiente = nodo.getSiguiente();
		nodoPrevio.setSiguiente(nodoSiguiente);
		tamanio -= 1;
	}

	public NodoLista<T> buscarDatoPrevio(T dato){
		NodoLista<T> nodoTmp = cabeza.getSiguiente();
		NodoLista<T> nodoBuscado = new NodoLista<>(null);
		NodoLista<T> nodoPrevio = cabeza;
		do {
			if (nodoTmp.getDato() == dato) {
				nodoBuscado = nodoPrevio;
				break;
			} else {
				nodoTmp = nodoTmp.getSiguiente();
				nodoPrevio = nodoPrevio.getSiguiente();
			}
		} while (nodoTmp != cola);
		return nodoBuscado;
	}
}
