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

	public void push(T dato){
		insertar(new nodoLista<>(dato));
	}

	public T pop(){
		eliminar();
		return cima();
	}

	public void eliminar() {
		nodoLista<T> nodoTmp = cola.getPrevio().getPrevio();
		nodoTmp.setSiguiente(cola);
		cola.setPrevio(nodoTmp);
	}

	public T cima(){
		return cola.getPrevio().getDato();
	}
}
