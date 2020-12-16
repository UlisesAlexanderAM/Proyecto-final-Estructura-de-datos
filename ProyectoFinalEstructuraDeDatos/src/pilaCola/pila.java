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
		nodo.setPrevio(nodoTmp);
		nodo.setSiguiente(cola);
		cola.setPrevio(nodo);
		tamanio+=1;
	}

	public void push(T dato){
		insertar(new nodoLista<>(dato));
	}

	public T pop(){
		nodoLista<T> nodoTmp = cola.getPrevio().getPrevio();
		T dato = cola.getPrevio().getDato();
		nodoTmp.setSiguiente(cola);
		cola.setPrevio(nodoTmp);
		return dato;
	}

	public void eliminar() {
		nodoLista<T> nodoTmp = cola.getPrevio().getPrevio();
		nodoTmp.setSiguiente(cola);
		cola.setPrevio(nodoTmp);
	}

	public void pop(int opcion){
		if (opcion == 1){
			pop();
		}
		else
			eliminar();
	}
}
