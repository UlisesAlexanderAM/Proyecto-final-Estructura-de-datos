package listas;

class nodoLista <T> {
	nodoLista<T> siguiente;
	nodoLista<T> previo;
	T dato;

	public nodoLista(T dato) {
		this.dato = dato;
	}
}
