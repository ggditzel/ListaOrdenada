package listaDupla;

import caixa.Caixa;

public class ListaEncadeada<T> {
	
	private Caixa<T> novo;
	private Caixa<T> primeiro;
	private Caixa<T> ultimo;
	private Caixa<T> cursor;
	
	public ListaEncadeada(){
		novo = null;
		primeiro = null;
		ultimo = null;
		cursor = null;
	}

	public void inserirFinal(T valor) {
		if (primeiro == null) {
			novo = new Caixa<T>(valor);
			primeiro = ultimo = cursor = novo;
		} else {
			novo = new Caixa<T>(valor);
			ultimo.setProximo(novo);
			novo.setAnterior(ultimo);
			ultimo = novo;
		}
	}

    public void inserirInicio(T valor) {
		if (primeiro == null) {
			novo = new Caixa<T>(valor);
			primeiro = ultimo = cursor = novo;
		} else {
			novo = new Caixa<T>(valor);
			novo.setProximo(primeiro);
			primeiro.setAnterior(novo);
			primeiro = novo;
		}
    }
    
    public T retirarInicio() throws Exception {
    	if (primeiro == null) throw new Exception("Fila vazia");

    	T elemento = primeiro.getValor();
    	if (primeiro == ultimo) {		// só resta um elemento na fila
    		primeiro = ultimo = null;	// reset
    	} else {
    		primeiro = primeiro.getProximo();
    		primeiro.setAnterior(null); // o novo "primeiro" não aponta para nenhum anterior
    	}
    	
    	return elemento;
    }
    
    public T retirarFim() throws Exception {

    	if (primeiro == null) throw new Exception("Fila vazia");

    	T elemento = ultimo.getValor();
    	if (ultimo == primeiro) {			// só resta um elemento na fila
    		ultimo = primeiro = null;		// reset
    	} else {
    		ultimo = ultimo.getAnterior();
    		ultimo.setProximo(null); // o novo "ultimo" nao aponta para nenhum proximo
    	}
    	
    	return elemento;
    }	
}
