package Listas;

import Listas.ListasLigadas.ListaLigada;
import Listas.PilaCola.Cola;
import Listas.PilaCola.Pila;

public class ModificarLista<T> {

	public void eliminarElementos(ListaLigada<T> lista, T dato){
		NodoLista<T> nodoTmp = lista.nodoPrimero();
		do {
			if (lista.eliminar(dato)==-1) {
				break;
			}
		}while (lista.cicloIncompleto(nodoTmp));
	}

	public int modificarDatoNodo(ListaLigada<T> lista, T datoViejo, T datoNuevo){
		NodoLista<T> nodoTmp = lista.buscarDato(datoViejo);
		if (nodoTmp.getDato() == null)
			return -1;
		else {
			nodoTmp.setDato(datoNuevo);
			return 0;
		}
	}

	public int modificarDatoNodos(ListaLigada<T> lista, T datoViejo, T datoNuevo){
		while (lista.buscarDato(datoViejo) != null){
			modificarDatoNodo(lista, datoViejo, datoNuevo);
		}
		return 0;
	}

	public String mostrarLista(ListaLigada<T> listaLigada){
		StringBuilder lista= new StringBuilder();
		if (listaLigada instanceof Cola){
			while (!listaLigada.estaVacia())
				lista.append(" ").append(((Cola<T>) listaLigada).quitar());
			return lista.toString();
		}else if (listaLigada instanceof Pila){
			while (!listaLigada.estaVacia())
				lista.append(" ").append(((Pila<T>) listaLigada).pop());
			return lista.toString();
		}else {
			NodoLista<T> nodoTmp = listaLigada.nodoPrimero();
			while (listaLigada.cicloIncompleto(nodoTmp))
				lista.append(" ").append(nodoTmp.getDato().toString());
			return lista.toString();
		}
	}
}
