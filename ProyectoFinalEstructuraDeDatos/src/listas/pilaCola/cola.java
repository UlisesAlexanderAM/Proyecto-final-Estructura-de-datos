package listas.pilaCola;

import listas.listasLigadas.listaDoble;
import listas.nodoLista;

public class cola<T> extends listaDoble<T> {
	public cola() {
	}

	public cola(T dato) {
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
			nodoLista<T> nodoTmp = cabeza.getSiguiente().getSiguiente();
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
