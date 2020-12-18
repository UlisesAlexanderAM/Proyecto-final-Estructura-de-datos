package listas.listasLigadas;

import listas.nodoLista;

public class listaCircular<T> extends listaLigada<T>{
	public listaCircular(){
		super();
	}

	public listaCircular(T dato){
		this(new nodoLista<>(dato));
	}

	public listaCircular(nodoLista<T> nodo){
		this();
		tamanio = 1;
		cabeza.setSiguiente(nodo);
		nodo.setSiguiente(nodo);
		cola.setPrevio(nodo);
	}

	@Override
	public void insertar(nodoLista<T> nodo) {
		if (tamanio == 0) {
			cabeza.setSiguiente(nodo);
			nodo.setSiguiente(nodo);
		} else {
			nodoLista<T> nodoTmp = cola.getPrevio();
			nodoTmp.setSiguiente(nodo);
			nodo.setSiguiente(cabeza.getSiguiente());
		}
		cola.setPrevio(nodo);
		tamanio += 1;
	}

	@Override
	public void eliminar(nodoLista<T> nodo) {
		nodoLista<T> nodoPrevio = buscarDatoPrevio(nodo.getDato());
		nodoLista<T> nodoSiguiente = nodo.getSiguiente();
		nodoPrevio.setSiguiente(nodoSiguiente);
		tamanio -= 1;
	}

	@Override
	public nodoLista<T> buscarDato(T dato){
		nodoLista<T> nodoTmp = cabeza.getSiguiente();
		nodoLista<T> nodoBuscado = new nodoLista<>(null);
		do {
			if (nodoTmp.getDato() == dato) {
				nodoBuscado = nodoTmp;
				break;
			} else
				nodoTmp = nodoTmp.getSiguiente();
		} while (cicloIncompleto(nodoTmp));
		return nodoBuscado;
	}

	public nodoLista<T> buscarDatoPrevio(T dato){
		nodoLista<T> nodoTmp = cabeza.getSiguiente();
		nodoLista<T> nodoBuscado = new nodoLista<>(null);
		nodoLista<T> nodoPrevio = cabeza;
		do {
			if (nodoTmp.getDato() == dato) {
				nodoBuscado = nodoPrevio;
				break;
			} else {
				nodoTmp = nodoTmp.getSiguiente();
				nodoPrevio = nodoPrevio.getSiguiente();
			}
		} while (cicloIncompleto(nodoTmp));
		return nodoBuscado;
	}

	public boolean cicloIncompleto(nodoLista<T> nodo){
		return nodo != cabeza.getSiguiente();
	}
}
