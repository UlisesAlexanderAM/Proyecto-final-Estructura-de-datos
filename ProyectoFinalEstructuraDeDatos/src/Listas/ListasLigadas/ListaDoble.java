package Listas.ListasLigadas;

import Listas.NodoLista;

public class ListaDoble<T> extends ListaLigada<T> {

	public ListaDoble() {
		super();
	}

	public ListaDoble(T dato) {
		super(dato);
	}

	@Override
	public void insertar(NodoLista<T> nodo) {
		if (tamanio == 0) {
			cabeza.setSiguiente(nodo);
			nodo.setPrevio(cabeza);
		} else {
			NodoLista<T> nodoTmp = cola.getPrevio();
			nodoTmp.setSiguiente(nodo);
			nodo.setPrevio(nodoTmp);
		}
		nodo.setSiguiente(cola);
		cola.setPrevio(nodo);
		tamanio += 1;
	}

	@Override
	public void eliminar(NodoLista<T> nodo) {
		NodoLista<T> nodoPrevio = nodo.getPrevio();
		NodoLista<T> nodoSiguiente = nodo.getSiguiente();
		nodoPrevio.setSiguiente(nodoSiguiente);
		nodoSiguiente.setPrevio(nodoPrevio);
		tamanio -= 1;
	}

}
