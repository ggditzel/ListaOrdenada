package listaDupla;

public class Testes {

public static void main(String[] args) {
		
		ListaEncadeada<Aluno> l1 = new ListaEncadeada<Aluno>();
		
		try {
			l1.inserirFinal(new Aluno("Jose"));
			l1.inserirFinal(new Aluno("Pedro"));
			l1.inserirFinal(new Aluno("Joao"));
			l1.inserirFinal(new Aluno("Jorge"));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		

		try {
			for (int i = 1; i <= 4; i++) {
				//Aluno a = l1.retirarInicio();
				Aluno a = l1.retirarFim();
				System.out.printf("Aluno retirado da lista: %s; matricula: %d\n", a.getNome(), a.getMatricula());
			}
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
}
