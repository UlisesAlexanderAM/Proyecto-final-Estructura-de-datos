package Listas.PilaCola;

import Listas.ListasLigadas.ListaDoble;
import Listas.NodoLista;

public class Cola<T> extends ListaDoble<T> {
	T datoFrente;
	public Cola() {
	}

	public Cola(T dato) {
		super(dato);
	}

	public T quitar() {
		if (eliminar() == -1) {
			return null;
		} else
			return datoFrente;
	}

	public int eliminar() {
		if (this.estaVacia())
			return -1;
		else {
			NodoLista<T> nodoTmp = cabeza.getSiguiente().getSiguiente();
			datoFrente = frente();
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
