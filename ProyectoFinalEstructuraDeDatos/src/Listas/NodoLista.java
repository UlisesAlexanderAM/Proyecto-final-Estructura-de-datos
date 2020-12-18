package Listas;

public class NodoLista<T> {
	private NodoLista<T> siguiente;
	private NodoLista<T> previo;
	private T dato;

	public NodoLista(T dato) {
		this.dato = dato;
	}

	public NodoLista<T> getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(NodoLista<T> siguiente) {
		this.siguiente = siguiente;
	}

	public NodoLista<T> getPrevio() {
		return previo;
	}

	public void setPrevio(NodoLista<T> previo) {
		this.previo = previo;
	}

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}
}
