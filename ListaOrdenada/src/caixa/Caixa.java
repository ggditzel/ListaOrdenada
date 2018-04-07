package caixa;

public class Caixa<T> {
	
	private T valor;
	private Caixa<T> proximo;
	private Caixa<T> anterior;
	
	public Caixa(T valor) {
		this.proximo = null;
		this.anterior = null;
		this.valor = valor;
	}
	
	public T getValor() {
		return this.valor;
	}
	
	public void setValor(T valor) {
		this.valor = valor;
	}
	
	public Caixa<T> getProximo() {
		return proximo;
	}
	
	public void setProximo(Caixa<T> proximo) {
		this.proximo = proximo;
	}
	
	public Caixa<T> getAnterior() {
		return anterior;
	}
	
	public void setAnterior(Caixa<T> anterior) {
		this.anterior = anterior;
	}
}
