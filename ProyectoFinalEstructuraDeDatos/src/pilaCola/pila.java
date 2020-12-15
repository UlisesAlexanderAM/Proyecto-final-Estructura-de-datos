package pilaCola;

import listas.listaDoble;
import listas.nodoLista;

public class pila<T> extends listaDoble<T> {
	public pila() {
		super();
	}

	public pila(nodoLista<T> nodo){
		super(nodo);
	}

	public pila(T dato) {
		this(new nodoLista<>(dato));
	}

	@Override
	public void insertar(nodoLista<T> nodo) {
		nodoLista<T> nodoTmp = cola.getPrevio();
		nodoTmp.setSiguiente(nodo);
		nodo.setSiguiente(cola);
		tamanio+=1;
	}
}
