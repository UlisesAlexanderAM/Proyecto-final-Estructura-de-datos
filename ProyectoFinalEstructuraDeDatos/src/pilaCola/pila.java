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
