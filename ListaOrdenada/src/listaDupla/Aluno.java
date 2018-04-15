package listaDupla;

public class Aluno implements IBuscavel {
	private int matricula;
	private String nome;
		
	public Aluno(String nome, int matricula) {
		this.nome = nome;
		this.matricula = matricula;
	}
	
	public int getCodigo() {
		return matricula;
	}
	
	public void setCodigo(int codigo) {
		this.matricula = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}	
	
	public Aluno getFake(int ID) {
		return new Aluno("", ID);
	}
}
