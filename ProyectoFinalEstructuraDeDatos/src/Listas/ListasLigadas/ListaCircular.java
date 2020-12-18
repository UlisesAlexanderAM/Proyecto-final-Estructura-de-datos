package Listas.ListasLigadas;

import Listas.NodoLista;

public class ListaCircular<T> extends ListaLigada<T> {
	public ListaCircular(){
		super();
	}

	public ListaCircular(T dato){
		this(new NodoLista<>(dato));
	}

	public ListaCircular(NodoLista<T> nodo){
		this();
		tamanio = 1;
		cabeza.setSiguiente(nodo);
		nodo.setSiguiente(nodo);
		cola.setPrevio(nodo);
	}

	@Override
	public void insertar(NodoLista<T> nodo) {
		if (tamanio == 0) {
			cabeza.setSiguiente(nodo);
			nodo.setSiguiente(nodo);
		} else {
			NodoLista<T> nodoTmp = cola.getPrevio();
			nodoTmp.setSiguiente(nodo);
			nodo.setSiguiente(cabeza.getSiguiente());
		}
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

	@Override
	public NodoLista<T> buscarDato(T dato){
		NodoLista<T> nodoTmp = cabeza.getSiguiente();
		NodoLista<T> nodoBuscado = new NodoLista<>(null);
		do {
			if (nodoTmp.getDato() == dato) {
				nodoBuscado = nodoTmp;
				break;
			} else
				nodoTmp = nodoTmp.getSiguiente();
		} while (cicloIncompleto(nodoTmp));
		return nodoBuscado;
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
		} while (cicloIncompleto(nodoTmp));
		return nodoBuscado;
	}

	public boolean cicloIncompleto(NodoLista<T> nodo){
		return nodo != cabeza.getSiguiente();
	}
}
