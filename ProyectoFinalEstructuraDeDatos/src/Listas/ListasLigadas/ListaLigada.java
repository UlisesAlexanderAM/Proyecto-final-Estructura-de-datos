package Listas.ListasLigadas;

import Listas.Lista;
import Listas.NodoLista;

public abstract class ListaLigada<T> implements Lista<T> {
	protected NodoLista<T> cabeza;
	protected NodoLista<T> cola;
	protected int tamanio;

	public ListaLigada() {
		cabeza = new NodoLista<>(null);
		cola = new NodoLista<>(null);
		tamanio = 0;
		cabeza.setSiguiente(cola);
		cola.setPrevio(cabeza);
	}

	public ListaLigada(T dato) {
		this(new NodoLista<>(dato));
	}

	public ListaLigada(NodoLista<T> nodo) {
		this();
		tamanio = 1;
		cabeza.setSiguiente(nodo);
		nodo.setPrevio(cabeza);
		nodo.setSiguiente(cola);
		cola.setPrevio(nodo);
	}

	@Override
	public boolean estaVacia() {
		return tamanio == 0;
	}

	@Override
	public abstract void insertar(NodoLista<T> nodo);

	@Override
	public void insertar(T dato) {
		insertar(new NodoLista<>(dato));
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
		} while (nodoTmp != cola);
		return nodoBuscado;
	}

	@Override
	public abstract void eliminar(NodoLista<T> nodo);

	@Override
	public int eliminar(T dato){
		NodoLista<T> nodoTmp = buscarDato(dato);
		if (nodoTmp.getDato() == null)
			return -1;
		else {
			eliminar(buscarDato(dato));
			return 0;
		}
	}

	@Override
	public T ultimo() {
		return nodoUltimo().getDato();
	}

	@Override
	public T primero() {
		return nodoPrimero().getDato();
	}

	@Override
	public NodoLista<T> nodoPrimero() {
		return cabeza.getSiguiente();
	}

	@Override
	public NodoLista<T> nodoUltimo() {
		return cola.getPrevio();
	}

	@Override
	public void vaciar() {
		cabeza.setSiguiente(cola);
		cola.setPrevio(cabeza);
		tamanio = 0;
	}

	public boolean cicloIncompleto(NodoLista<T> nodo){
		return nodo != cola;
	}

	public NodoLista<T> getCabeza() {
		return cabeza;
	}

	public NodoLista<T> getCola() {
		return cola;
	}
}