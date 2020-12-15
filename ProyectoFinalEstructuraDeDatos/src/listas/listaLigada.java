package listas;

public interface listaLigada<T> {
	void crearLista(nodoLista<T> nodo);
	boolean estaVacia();
	void insertar(nodoLista<T> nodo);
	nodoLista<T> buscar(nodoLista<T> nodo);
	void eliminar(nodoLista<T> nodo);
	nodoLista<T> anterior();
	nodoLista<T> primero();
	void vaciar();
}
