package listas.listasLigadas;

import listas.nodoLista;

public class listaDoble<T> extends listaLigada<T> {

	public listaDoble() {
		super();
	}

	public listaDoble(T dato) {
		super(dato);
	}

	@Override
	public void insertar(nodoLista<T> nodo) {
		if (tamanio == 0) {
			cabeza.setSiguiente(nodo);
			nodo.setPrevio(cabeza);
		} else {
			nodoLista<T> nodoTmp = cola.getPrevio();
			nodoTmp.setSiguiente(nodo);
			nodo.setPrevio(nodoTmp);
		}
		nodo.setSiguiente(cola);
		cola.setPrevio(nodo);
		tamanio += 1;
	}

	@Override
	public void eliminar(nodoLista<T> nodo) {
		nodoLista<T> nodoPrevio = nodo.getPrevio();
		nodoLista<T> nodoSiguiente = nodo.getSiguiente();
		nodoPrevio.setSiguiente(nodoSiguiente);
		nodoSiguiente.setPrevio(nodoPrevio);
		tamanio -= 1;
	}

}
