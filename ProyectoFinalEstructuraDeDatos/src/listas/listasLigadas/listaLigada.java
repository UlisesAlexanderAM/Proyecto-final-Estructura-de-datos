package listas.listasLigadas;

import listas.lista;
import listas.nodoLista;

public abstract class listaLigada<T> implements lista<T> {
	protected nodoLista<T> cabeza;
	protected nodoLista<T> cola;
	protected int tamanio;

	public listaLigada() {
		cabeza = new nodoLista<>(null);
		cola = new nodoLista<>(null);
		tamanio = 0;
		cabeza.setSiguiente(cola);
		cola.setPrevio(cabeza);
	}

	public listaLigada(T dato) {
		this(new nodoLista<>(dato));
	}

	public listaLigada(nodoLista<T> nodo) {
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
	public abstract void insertar(nodoLista<T> nodo);

	@Override
	public void insertar(T dato) {
		insertar(new nodoLista<>(dato));
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
		} while (nodoTmp != cola);
		return nodoBuscado;
	}

	@Override
	public abstract void eliminar(nodoLista<T> nodo);

	@Override
	public int eliminar(T dato){
		nodoLista<T> nodoTmp = buscarDato(dato);
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
	public nodoLista<T> nodoPrimero() {
		return cabeza.getSiguiente();
	}

	@Override
	public nodoLista<T> nodoUltimo() {
		return cola.getPrevio();
	}

	@Override
	public void vaciar() {
		cabeza.setSiguiente(cola);
		cola.setPrevio(cabeza);
		tamanio = 0;
	}

	public boolean cicloIncompleto(nodoLista<T> nodo){
		return nodo != cola;
	}

	public nodoLista<T> getCabeza() {
		return cabeza;
	}

	public nodoLista<T> getCola() {
		return cola;
	}
}
