package listaDupla;

public class Aluno {
	private int matricula;
	private static int matriculaGerada;
	private String nome;
	
	public Aluno(String nome) throws Exception {
		matricula = geraMatricula();
		this.nome = nome;
	}
	
	public int getMatricula() {
		return matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	private int geraMatricula() throws Exception {
		if ( matriculaGerada == Integer.MAX_VALUE) {
			throw new Exception("Limite de matriculas atingido");
		}
		return matriculaGerada++;
	}
}
