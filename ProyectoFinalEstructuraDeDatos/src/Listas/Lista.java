package Listas;

public interface Lista<T> {
	boolean estaVacia();

	void insertar(NodoLista<T> nodo);

	void insertar(T dato);

	NodoLista<T> buscarDato(T dato);

	void eliminar(NodoLista<T> nodo);

	int eliminar(T dato);

	T ultimo();

	T primero();

	NodoLista<T> nodoPrimero();

	NodoLista<T> nodoUltimo();

	void vaciar();

}
