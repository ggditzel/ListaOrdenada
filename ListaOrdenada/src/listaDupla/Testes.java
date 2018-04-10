package listaDupla;

public class Testes {

	public static void main(String[] args) {

		ListaEncadeada<Aluno> l1 = new ListaEncadeada<Aluno>();

		System.out.printf("Fila vazia? %s\n", l1.isEmpty() ? "Sim" : "Nao");

		Aluno a1 = null;
		Aluno a2 = null;
		Aluno a3 = null;
		Aluno a4 = null;
		Aluno a5 = null;
		try {
			a1 = new Aluno("Jose");
			a2 = new Aluno("Joao");
			a3 = new Aluno("Silvio");
			a4 = new Aluno("Paulo");
			a5 = new Aluno("Ninguem");
//			 l1.inserirFinal(a4);
//			 l1.inserirFinal(a1);
//			 l1.inserirFinal(a3);
//			 l1.inserirFinal(a2);
			l1.inserirInicio(a4);
			l1.inserirInicio(a1);
			l1.inserirInicio(a3);
			l1.inserirInicio(a2);
			for (int i = 1; i <= 3; i++) {
				l1.avancarCursor();
			}
			l1.inserirPosAtual(a5);

		} catch (Exception e2) {
			System.out.println(e2);
		}

		System.out.printf("Fila vazia? %s\n", l1.isEmpty() ? "Sim" : "Nao");

		// try {
		// buscado = l1.buscar(1).getElemento();
		// System.out.printf("Aluno encontrado pelo codigo: %s; matricula: %d; cursor:
		// %s\n", buscado.getNome(), buscado.getCodigo(), buscado);
		// } catch (Exception e1) {
		// System.out.println(e1);
		// }
		//
		// try {
		// buscado = l1.buscar2(a3).getElemento();
		// System.out.printf("Aluno encontrado: %s; matricula: %d; cursor: %s\n",
		// buscado.getNome(), buscado.getCodigo(), buscado);
		// } catch (Exception e1) {
		// System.out.println(e1);
		// }
		//
		// try {
		// buscado = l1.buscar2(desconhecido).getElemento();
		// System.out.printf("Aluno encontrado: %s; matricula: %d; cursor: %s\n",
		// buscado.getNome(), buscado.getCodigo(), buscado);
		// } catch (Exception e1) {
		// System.out.println(e1);
		// }

		// try {
		// l1.excluirItem(a3);
		// } catch (Exception e1) {
		// System.out.println(e1);
		// }

		try {
			l1.buscar(a5);
			l1.excluirPosAtual();
		} catch (Exception e1) {
			System.out.println(e1);
		}

		// l1.avancarCursor();
		// l1.avancarCursor();
		// l1.avancarCursor();
//		try {
//			l1.excluirPosAtual();
//		} catch (Exception e1) {
//			System.out.println(e1);
//		}

		try {
			for (int i = 1; i <= 4; i++) {
				//Aluno a = l1.retirarInicio();
				Aluno a = l1.retirarFinal();
				System.out.printf("Aluno retirado da lista: %s; matricula: %d; referencia: %s\n", a.getNome(),
						a.getCodigo(), a);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.printf("Fila vazia? %s\n", l1.isEmpty() ? "Sim" : "Nao");

	}

}
