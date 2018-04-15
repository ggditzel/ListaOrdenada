package listaOrdenada;

import listaDupla.Aluno;
import listaDupla.ElementoNaoEncontradoException;
import listaDupla.FilaVaziaException;

public class TestesListaOrdenada {

	public static void main(String[] args) {

		ListaOrdenada<Aluno> lista = new ListaOrdenada<Aluno>();

		Aluno a1 = new Aluno("Jose", 13);
		Aluno a2 = new Aluno("Joao", 24);
		Aluno a3 = new Aluno("Silvio", 69);
		Aluno a4 = new Aluno("Paulo", 51);
		Aluno a5 = new Aluno("Ninguem", 42);

		// Criacao da lista
		try {
			lista.inserirOrdenado(a5);
			lista.inserirOrdenado(a3);
			lista.inserirOrdenado(a4);
			lista.inserirOrdenado(a2);
			lista.inserirOrdenado(a1);
			System.out.printf("Ordem de insercao: %d, %d, %d, %d, %d\n", a5.getCodigo(), a3.getCodigo(), a4.getCodigo(), a2.getCodigo(), a1.getCodigo());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// verificar a lista
		try {
			lista.imprimeLista();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		
		// buscar por ID que nao existe
		try {
			int codigo = 22;
			System.out.printf("\n(procurando por codigo %d...)\n", codigo);
			Aluno buscado = lista.buscar(codigo);
			System.out.printf("Elemento buscado/lido: codigo: %d; nome: %s\n", buscado.getCodigo(), buscado.getNome());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		
		//buscar por ID que existe
		try {
			int codigo = 69;
			System.out.printf("\n(procurando por codigo %d...)\n", codigo);
			Aluno buscado = lista.buscar(codigo);
			System.out.printf("Elemento buscado/lido: codigo: %d; nome: %s\n", buscado.getCodigo(), buscado.getNome());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		
		// exclusao
		try {
			int codigo = 13;
			System.out.printf("\n(procurando por codigo %d...)\n", codigo);
			Aluno buscado = lista.buscar(codigo);
			System.out.printf("Elemento retirado: codigo: %d; nome: %s\n", buscado.getCodigo(), buscado.getNome());
			lista.excluir(buscado.getCodigo());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// verificar a lista
		try {
			lista.imprimeLista();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		// exclusao
		try {
			int codigo = 51;
			System.out.printf("\n(procurando por codigo %d...)\n", codigo);
			Aluno buscado = lista.buscar(codigo);
			System.out.printf("Elemento retirado: codigo: %d; nome: %s\n", buscado.getCodigo(), buscado.getNome());
			lista.excluir(buscado.getCodigo());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// verificar a lista
		try {
			lista.imprimeLista();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}


		// exclusao de item que nao existe
		try {
			int codigo = 86;
			System.out.printf("\n(procurando por codigo %d...)\n", codigo);
			Aluno buscado = lista.buscar(codigo);
			System.out.printf("Elemento retirado: codigo: %d; nome: %s\n", buscado.getCodigo(), buscado.getNome());
			lista.excluir(buscado.getCodigo());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// verificar a lista
		try {
			lista.imprimeLista();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}

}
