package listas;

public interface lista<T> {
	boolean estaVacia();

	void insertar(nodoLista<T> nodo);

	void insertar(T dato);

	nodoLista<T> buscarDato(T dato);

	void eliminar(nodoLista<T> nodo);

	int eliminar(T dato);

	T ultimo();

	T primero();

	nodoLista<T> nodoPrimero();

	nodoLista<T> nodoUltimo();

	void vaciar();

}
