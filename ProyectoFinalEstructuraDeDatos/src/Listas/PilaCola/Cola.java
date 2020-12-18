package Listas.PilaCola;

import Listas.ListasLigadas.ListaDoble;
import Listas.NodoLista;

public class Cola<T> extends ListaDoble<T> {
	public Cola() {
	}

	public Cola(T dato) {
		super(dato);
	}

	public T quitar() {
		if (eliminar() == -1) {
			return null;
		} else
			return frente();
	}

	public int eliminar() {
		if (this.estaVacia())
			return -1;
		else {
			NodoLista<T> nodoTmp = cabeza.getSiguiente().getSiguiente();
			cabeza.setSiguiente(nodoTmp);
			nodoTmp.setPrevio(cabeza);
			tamanio -= 1;
			return 0;
		}
	}

	public T frente() {
		return primero();
	}

}
