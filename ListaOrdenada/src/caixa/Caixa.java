package caixa;

public class Caixa<T> {
	
	private T elemento;
	private Caixa<T> proximo;
	private Caixa<T> anterior;
	
	public Caixa() {
		this.proximo = null;
		this.anterior = null;
		this.elemento = elemento;
	}
	
	public Caixa(T elemento) {
		this.proximo = null;
		this.anterior = null;
		this.elemento = elemento;
	}
	
	public T getElemento() {
		return this.elemento;
	}
	
	public void setElemento(T elemento) {
		this.elemento = elemento;
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
