package listas;

public class listaDoble<T> implements listaLigada<T> {
	protected nodoLista<T> cabeza;
	protected nodoLista<T> cola;
	protected int tamanio;

	public listaDoble() {
		tamanio = 0;
		cabeza = new nodoLista<>(null);
		cola = new nodoLista<>(null);
		cabeza.setSiguiente(cola);
		cola.setPrevio(cabeza);
	}

	public listaDoble(T dato){
		this(new nodoLista<>(dato));
	}

	public listaDoble(nodoLista<T> nodo) {
		tamanio = 1;
		cabeza = new nodoLista<>(null);
		cola = new nodoLista<>(null);
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
	public void insertar(nodoLista<T> nodo) {
	}

	@Override
	public void insertar(T dato) {
		nodoLista<T> nodoTmp = new nodoLista<>(dato);
		this.insertar(nodoTmp);
	}

	@Override
	public nodoLista<T> buscarDato(nodoLista<T> nodo) {
		return null;
	}

	@Override
	public nodoLista<T> buscarNodo(nodoLista<T> nodo) {
		return null;
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
		cabeza.setSiguiente(null);
		cola.setPrevio(null);
	}
}
