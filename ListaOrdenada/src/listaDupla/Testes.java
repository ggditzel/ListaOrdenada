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
			a1 = new Aluno("Jose", 13);
			a2 = new Aluno("Joao", 24);
			a3 = new Aluno("Silvio", 69);
			a4 = new Aluno("Paulo", 51);
			a5 = new Aluno("Ninguem", 42);
			l1.inserirInicio(a4);
			l1.inserirInicio(a1);
			l1.inserirInicio(a3);
			l1.inserirInicio(a2);
			for (int i = 1; i <= 3; i++) {
				l1.avancarCursor();
			}
			for (int i = 1; i <= 1; i++) {
				l1.voltarCursor();
			}
			l1.inserirFinal(a5);
	

		} catch (Exception e2) {
			System.out.println(e2);
		}

		System.out.printf("Fila vazia? %s\n", l1.isEmpty() ? "Sim" : "Nao, tamanho " + l1.getNumElementos());


		try {
			l1.cursorParaPrimeiro();
			for (int i = 1; i <= 5; i++) {
				//Aluno a = l1.retirarInicio();
				Aluno a = l1.lerAtual();
				System.out.printf("Aluno lido da lista: %s; matricula: %d; referencia: %s\n", a.getNome(),
						a.getCodigo(), a);
				l1.avancarCursor();
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.println("");
		
		try {
			for (int i = 1; i <= 5; i++) {
				//Aluno a = l1.retirarInicio();
				Aluno a = l1.retirarFinal();
				System.out.printf("Aluno retirado da lista: %s; matricula: %d; referencia: %s\n", a.getNome(),
						a.getCodigo(), a);
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}

		System.out.printf("Fila vazia? %s\n", l1.isEmpty() ? "Sim" : "Nao, tamanho " + l1.getNumElementos());

	}

}
