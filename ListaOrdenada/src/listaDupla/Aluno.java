package listaDupla;

public class Aluno implements IBuscavel {
	private static int matriculaGerada;
	private int matricula;
	private String nome;
	
	public Aluno(String nome) throws Exception {
		matricula = geraMatricula();
		this.nome = nome;
	}
	
	public int getCodigo() {
		return matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	private int geraMatricula() throws Exception {
		if ( matricula == Integer.MAX_VALUE) throw new Exception("Limite de matriculas atingido");
		return matriculaGerada++;
	}
}
