package listas;

public class nodoLista <T> {
	private nodoLista<T> siguiente;
	private nodoLista<T> previo;
	private T dato;

	public nodoLista(T dato) {
		this.dato = dato;
	}

	public nodoLista<T> getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(nodoLista<T> siguiente) {
		this.siguiente = siguiente;
	}

	public nodoLista<T> getPrevio() {
		return previo;
	}

	public void setPrevio(nodoLista<T> previo) {
		this.previo = previo;
	}

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}
}
