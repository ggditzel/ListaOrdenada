package listaDupla;

public class FilaVaziaException extends Exception {

	public FilaVaziaException() {
		this("Fila Vazia");
	}
	
	public FilaVaziaException(String msg) {
		super(msg);
	}
}
