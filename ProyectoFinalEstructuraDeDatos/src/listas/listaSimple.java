package listas;

public class listaSimple <T> implements listaLigada<T>{
	private nodoLista<T> cabeza;
	private nodoLista<T> cola;
	private int tamanio;

	public listaSimple() {
		tamanio = 0;
		cabeza = new nodoLista<>(null);
		cola = new nodoLista<>(null);
		cabeza.siguiente = cola;
	}

	public listaSimple(nodoLista<T> nodo){
		cabeza = new nodoLista<>(null);
		cola = new nodoLista<>(null);
		cabeza.siguiente=nodo;
		nodo.siguiente=cola;
	}

	@Override
	public void crearLista(nodoLista<T> nodo) {
		cabeza.siguiente = nodo;
		nodo.siguiente = cola;
		tamanio = 1;
	}

	@Override
	public boolean estaVacia() {
		return tamanio == 0;
	}

	@Override
	public void insertar(nodoLista<T> nodo) {
		nodo.previo = cola.previo;
		cola.previo = nodo;
		nodo.siguiente=cola;
		tamanio+=1;
	}

	@Override
	public nodoLista<T> buscar(nodoLista<T> nodo) {
		nodoLista<T> cabezaTmp=cabeza.siguiente;
		nodoLista<T> nodoEncontrado = null;
		while (cabeza.siguiente.siguiente != cola){
			if (cabeza.siguiente == nodo){
				nodoEncontrado = cabeza.siguiente;
			}
			else {
				cabeza.siguiente=cabeza.siguiente.siguiente;
			}
		}
		cabeza.siguiente = cabezaTmp;
		return nodoEncontrado;
	}

	@Override
	public void eliminar(nodoLista<T> nodo) {

	}

	@Override
	public nodoLista<T> anterior() {
		return null;
	}

	@Override
	public nodoLista<T> primero() {
		return null;
	}

	@Override
	public void vaciar() {

	}
}
