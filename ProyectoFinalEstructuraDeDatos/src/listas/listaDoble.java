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
	public nodoLista<T> buscarDato(T dato) {
		nodoLista<T> nodoTmp = cabeza.getSiguiente();
		nodoLista<T> nodoBuscado = new nodoLista<>(null);
		do {
			if (cabeza.getSiguiente().getDato() == dato) {
				nodoBuscado = cabeza.getSiguiente();
				break;
			}
		}while (cabeza.getSiguiente() != null);
		cabeza.setSiguiente(nodoTmp);
		return nodoBuscado;
	}

	@Override
	public void eliminar(nodoLista<T> nodo) {
		nodoLista <T> nodoPrevio, nodoSiguiente = new nodoLista<>(null);
		nodoPrevio = nodo.getPrevio();
		nodoSiguiente = nodo.getSiguiente();
		nodoPrevio.setSiguiente(nodoSiguiente);
		nodoSiguiente.setPrevio(nodoPrevio);
	}

	@Override
	public void eliminar(T dato) {
		eliminar(buscarDato(dato));
	}

	@Override
	public T ultimo() {
		return ultimo(cola.getPrevio());
	}

	@Override
	public T primero() {
		return primero(cabeza.getSiguiente());
	}

	@Override
	public T primero(nodoLista<T> nodo) {
		return nodo.getDato();
	}

	@Override
	public T ultimo(nodoLista<T> nodo) {
		return nodo.getDato();
	}

	@Override
	public void vaciar() {
		cabeza.setSiguiente(null);
		cola.setPrevio(null);
	}

	public int getTamanio() {
		return tamanio;
	}
}
