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
		this();
		tamanio = 1;
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
		if (tamanio == 0){
			cabeza.setSiguiente(nodo);
			nodo.setPrevio(cabeza);
			nodo.setSiguiente(cola);
			cola.setPrevio(nodo);
		}
		else {
			nodoLista<T> nodoTmp = cola.getPrevio();
			nodoTmp.setSiguiente(nodo);
			nodo.setPrevio(nodoTmp);
			nodo.setSiguiente(cola);
			cola.setPrevio(nodo);
		}
		tamanio += 1;
	}

	@Override
	public void insertar(T dato) {
		insertar(new nodoLista<>(dato));
	}

	@Override
	public nodoLista<T> buscarDato(T dato) {
		nodoLista<T> nodoTmp = cabeza.getSiguiente();
		nodoLista<T> nodoBuscado = new nodoLista<>(null);
		do {
			if (nodoTmp.getDato() == dato) {
				nodoBuscado = nodoTmp;
				break;
			}
			else
				nodoTmp=nodoTmp.getSiguiente();
		}while (nodoTmp != cola);
		return nodoBuscado;
	}

	@Override
	public void eliminar(nodoLista<T> nodo) {
		nodoLista <T> nodoPrevio = nodo.getPrevio();
		nodoLista <T> nodoSiguiente = nodo.getSiguiente();
		nodoPrevio.setSiguiente(nodoSiguiente);
		nodoSiguiente.setPrevio(nodoPrevio);
		tamanio-=1;
	}

	@Override
	public int eliminar(T dato) {
		nodoLista<T> nodoTmp = buscarDato(dato);
		if (nodoTmp.getDato()==null)
			return -1;
		else {
			eliminar(buscarDato(dato));
			return 0;
		}
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
		cabeza.setSiguiente(cola);
		cola.setPrevio(cabeza);
	}

	public int getTamanio() {
		return tamanio;
	}
}
