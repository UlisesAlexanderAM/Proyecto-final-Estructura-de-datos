package listas;

public interface listaLigada<T> {
	boolean estaVacia();

	void insertar(nodoLista<T> nodo);

	void insertar(T dato);

	nodoLista<T> buscarNodo(nodoLista<T> nodo);

	nodoLista<T> buscarDato(T dato);

	void eliminar(nodoLista<T> nodo);

	T ultimo();

	T primero();

	T primero(nodoLista<T> nodo);

	T ultimo(nodoLista<T> nodo);

	void vaciar();
}
