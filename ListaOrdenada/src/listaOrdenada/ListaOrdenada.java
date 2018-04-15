package listaOrdenada;

import java.util.ArrayList;

import listaDupla.Aluno;
import listaDupla.IBuscavel;
import listaDupla.ListaEncadeada;

public class ListaOrdenada <T extends IBuscavel> {
	
	private ListaEncadeada<T> lista;
	
	public ListaOrdenada() {
		lista = new ListaEncadeada<T>();
	}
	
	public T buscar(int ID) throws Exception {
		lista.buscar(ID);
		return lista.lerAtual();
	}
	
	public void excluir(int ID) throws Exception {
		lista.buscar(ID);
		lista.excluirItem(ID);
	}
	
	public void inserirOrdenado(T elemento) throws Exception {
		
		if (lista.isEmpty()) {
			lista.inserirAposAtual(elemento);
		} else {

			lista.cursorParaUltimo();
			int maiorCodigo = lista.lerAtual().getCodigo();

			if (elemento.getCodigo() > maiorCodigo) {
				lista.cursorParaUltimo();
				lista.inserirAposAtual(elemento);
			} else {
				lista.cursorParaPrimeiro();
				while (elemento.getCodigo() > lista.lerAtual().getCodigo()) {
					lista.avancarCursor();
				}

				lista.inserirAntesAtual(elemento);
			}
		}
//		lista.cursorParaPrimeiro();
//		if (elemento.getCodigo() > )
//		
//		if (lista.isEmpty()) {
//			lista.inserirAposAtual(elemento);
//		} else {
//			while (elemento.getCodigo() > lista.lerAtual().getCodigo()) {
//				lista.avancarCursor();
//			}
//			
//			lista.inserirAntesAtual(elemento);
//		}
	}
	
	/**
	 * Apenas para testes, para verificar se elementos foram inseridos na ordem correta
	 */
	public void imprimeLista() throws Exception{
		ArrayList<T> al = new ArrayList<T>();
		lista.cursorParaPrimeiro();
		for (int i = 1; i <= lista.getNumElementos(); i++) {
			al.add(lista.lerAtual());
			lista.avancarCursor();
		}
		System.out.print("Lista ordenada:");
		if (al.isEmpty()) System.out.println("- vazia -");
		for (T a : al) {
			System.out.print(" " + a.getCodigo());
		}
		System.out.println("");
	}
	
}
