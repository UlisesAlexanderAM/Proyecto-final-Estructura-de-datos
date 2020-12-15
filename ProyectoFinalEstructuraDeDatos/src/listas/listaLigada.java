package listas;

public interface listaLigada<T> {
	boolean estaVacia();

	void insertar(nodoLista<T> nodo);

	void insertar(T dato);

	nodoLista<T> buscarNodo(nodoLista<T> nodo);

	nodoLista<T> buscarDato(nodoLista<T> nodo);

	void eliminar(nodoLista<T> nodo);

	nodoLista<T> anterior();

	nodoLista<T> primero();

	void vaciar();
}
