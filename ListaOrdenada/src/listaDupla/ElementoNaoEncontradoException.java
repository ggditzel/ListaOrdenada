package listaDupla;

public class ElementoNaoEncontradoException extends Exception {

	public ElementoNaoEncontradoException() {
		this("Elemento nao encontrado");
	}
	
	public ElementoNaoEncontradoException(String msg) {
		super(msg);
	}
}