package listas;

import listas.listasLigadas.listaLigada;

public class modificarLista<T> {

	public void eliminarElementos(listaLigada<T> lista, T dato){
		nodoLista<T> nodoTmp = lista.nodoPrimero();
		do {
			if (lista.eliminar(dato)==-1) {
				break;
			}
		}while (lista.cicloIncompleto(nodoTmp));
	}

	public int modificarDatoNodo(listaLigada<T> lista, T datoViejo,T datoNuevo){
		nodoLista<T> nodoTmp = lista.buscarDato(datoViejo);
		if (nodoTmp.getDato() == null)
			return -1;
		else {
			nodoTmp.setDato(datoNuevo);
			return 0;
		}
	}

	public int modificarDatoNodos(listaLigada<T> lista, T datoViejo,T datoNuevo){
		while (lista.buscarDato(datoViejo) != null){
			modificarDatoNodo(lista, datoViejo, datoNuevo);
		}
		return 0;
	}
}
