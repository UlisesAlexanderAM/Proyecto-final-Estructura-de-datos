package listas.listasEnlazadas;

public class listaSimple<T> extends listaLigada<T> {

	protected nodoLista<T> cabeza;
	protected nodoLista<T> cola;
	protected int tamanio;


	public listaSimple() {
		super();
	}

	public listaSimple(T dato) {
		super(dato);
	}

	@Override
	public void insertar(nodoLista<T> nodo) {
		if (tamanio == 0) {
			cabeza.setSiguiente(nodo);
		} else {
			nodoLista<T> nodoTmp = cola.getPrevio();
			nodoTmp.setSiguiente(nodo);
		}
		nodo.setSiguiente(cola);
		cola.setPrevio(nodo);
		tamanio += 1;
	}

	@Override
	public void eliminar(nodoLista<T> nodo) {
		nodoLista<T> nodoPrevio = buscarDatoPrevio(nodo.getDato());
		nodoLista<T> nodoSiguiente = nodo.getSiguiente();
		nodoPrevio.setSiguiente(nodoSiguiente);
		tamanio -= 1;
	}

	@Override
	public int eliminar(T dato) {
		nodoLista<T> nodoTmp = buscarDato(dato);
		if (nodoTmp.getDato() == null)
			return -1;
		else {
			eliminar(buscarDato(dato));
			return 0;
		}
	}

	public nodoLista<T> buscarDatoPrevio(T dato){
		nodoLista<T> nodoTmp = cabeza.getSiguiente();
		nodoLista<T> nodoBuscado = new nodoLista<>(null);
		nodoLista<T> nodoPrevio = cabeza;
		do {
			if (nodoTmp.getDato() == dato) {
				nodoBuscado = nodoPrevio;
				break;
			} else {
				nodoTmp = nodoTmp.getSiguiente();
				nodoPrevio = nodoPrevio.getSiguiente();
			}
		} while (nodoTmp != cola);
		return nodoBuscado;
	}
}
