package listaDupla;

import caixa.Caixa;

public class ListaEncadeada<T extends IBuscavel> {

	private Caixa<T> novo;
	private Caixa<T> primeiro;
	//private Caixa<T> ultimo;
	private Caixa<T> cursor;

	//	public Caixa<T> novo;
	//	public Caixa<T> primeiro;
	//	public Caixa<T> ultimo;
	//	public Caixa<T> cursor;


	private int size;

	public ListaEncadeada(){
		novo = null;
		primeiro = null;
		//ultimo = null;
		cursor = null;
		size = 0;
	}

	public void inserirFinal(T valor) {
		novo = new Caixa<T>(valor); // assumindo memória infinita, etc
		size++;
		if (primeiro == null) {
			primeiro = cursor = novo;
			primeiro.setAnterior(primeiro);
			primeiro.setProximo(primeiro);
		} else {

			novo.setProximo(primeiro); // circular
			novo.setAnterior(primeiro.getAnterior());
			primeiro.getAnterior().setProximo(novo);
			primeiro.setAnterior(novo);


			//			ultimo.setProximo(novo);
			//			novo.setAnterior(ultimo);
			//			novo.setProximo(primeiro); // circular
			//			ultimo = novo;
		}
		System.out.printf("Elmento inserido no final: %s; primeiro: %s; cursor: %s\n", novo, primeiro, cursor);
	}

	public void inserirInicio(T valor) {
		cursor = primeiro;
		inserirPosAtual(valor);
//		novo = new Caixa<T>(valor);
//		size++;
//		if (primeiro == null) {
//			primeiro = cursor = novo;
//			primeiro.setAnterior(primeiro);
//			primeiro.setProximo(primeiro);
//		} else {
//			Caixa<T> ultimo = primeiro.getAnterior();
//			novo.setAnterior(ultimo);
//			novo.setProximo(primeiro);
//			ultimo.setProximo(novo);
//			primeiro.setAnterior(novo);
//			primeiro = novo;



			//			primeiro.setAnterior(novo);
			//			novo.setProximo(primeiro);
			//			novo.setAnterior(ultimo);
			//			primeiro = novo;
		}
		System.out.printf("Elmento inserido no inicio %s; primeiro: %s; cursor: %s\n", novo, primeiro, cursor);
	}

	public T retirarInicio() throws Exception {

		if (primeiro == null) throw new Exception("Fila vazia");

		T elemento = primeiro.getElemento();
		excluirInicio();    	
		return elemento;
	}

	public T retirarFinal() throws Exception {

		if (primeiro == null) throw new Exception("Fila vazia");

		T elemento = primeiro.getAnterior().getElemento();
		excluirFinal();

		return elemento;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int getNumElementos() {
		return size;
	}

	// PRECISA FAZER A BUSCA A PARTIR DA POSICAO DO CURSOR, E CIRCULAR
	//    public Caixa<T> buscar(int codigo) throws Exception {
	//    	if (primeiro == null) throw new Exception("Fila vazia");
	//    	
	//    	while (cursor.getElemento().getCodigo() != codigo) {
	//    		if (cursor != ultimo) {
	//    			cursor = cursor.getProximo();
	//    		} else throw new Exception("Elemento nao encontrado.");
	//    	}
	//    	return cursor;
	//    }
	//    
	//    public Caixa<T> buscar2(T elemento) throws Exception {
	//    	if (primeiro == null) throw new Exception("Fila vazia");
	//    	    	
	//    	inserirFinal(elemento); // fake
	//    	cursor = primeiro; // mais fácil procurar sempre a partir do primeiro
	//    	
	//    	while (cursor.getElemento() != elemento) {
	//    		cursor = cursor.getProximo();
	//    	}
	//    	
	//    	if (cursor != ultimo) {
	//    		excluirFinal();
	//    		return cursor;
	//    	} else {
	//    		excluirFinal();
	//    		throw new Exception("Elemento nao encontrado no buscar2");
	//    	}
	//    }

	public Caixa<T> buscar3(T elemento) throws Exception {
		if (primeiro == null) throw new Exception("Fila vazia");

		Caixa<T> posicaoInicial = cursor;
		Caixa<T> posicaoBusca = cursor;
		inserirPosAtual(elemento); // fake
		avancarCursor();
		System.out.println("Elemento fake inserido na posicao: " + cursor);
		while (cursor.getElemento() != elemento) {
			System.out.println("Cursor vai para proxima posicao: " + cursor.getProximo());
			cursor = cursor.getProximo();
		}

		if (cursor != posicaoInicial) {
			posicaoBusca = cursor;
			System.out.println("Posicao onde elemento foi encontrado: " + cursor);
			cursor = posicaoInicial; // preparar para exclusao
			excluirPosAtual();
			System.out.println("Posicao do cursor apos exclusao do fake: " + cursor);
			return posicaoBusca;
		} else {
			excluirPosAtual();
			throw new Exception("Elemento nao encontrado no buscar3");
		}
	}

	public void excluirInicio() throws Exception {
		cursor = primeiro;
		excluirPosAtual();
//		if (primeiro == null) throw new Exception("Fila vazia");
//
//		size--;
//
//		Caixa<T> ultimo = primeiro.getAnterior();
//		primeiro.getProximo().setAnterior(ultimo);
//		primeiro = primeiro.getProximo();
//		ultimo.setProximo(primeiro);
//		cursor.setProximo(primeiro); // aponta para o elemento posterior ao excluido
		
		System.out.printf("Elmento excluido do inicio da lista; primeiro: %s; cursor: %s\n", primeiro, cursor);

		//    	if (primeiro == ultimo) {		// só resta um elemento na fila
		//    		primeiro = ultimo = cursor = null;	// reset
		//    	} else {
		//    		primeiro = primeiro.getProximo();
		//    		primeiro.setAnterior(null); // o novo "primeiro" não aponta para nenhum anterior
		//    	}
	}

	public void excluirFinal() throws Exception {
		cursor = primeiro.getAnterior();
		excluirPosAtual();
		
		
//		if (primeiro == null) throw new Exception("Fila vazia");
//
//		if (size == 1) {					// só resta um elemento na fila
//			primeiro = cursor = null;		// reset
//		} else {
//
//			Caixa<T> ultimo = primeiro.getAnterior();
//			primeiro.setAnterior(ultimo.getAnterior());
//			ultimo.getAnterior().setProximo(primeiro);
//			cursor.setProximo(primeiro); // aponta para o elemento posterior ao excluido
//		}
//		size--;

	}


	public void excluirPosAtual() throws Exception {
		if (primeiro == null) throw new Exception("Fila vazia");

		if (size == 1) {					// só resta um elemento na fila
			primeiro = cursor = null;		// reset
		} else {
			cursor.getAnterior().setProximo(cursor.getProximo());
			cursor.getProximo().setAnterior(cursor.getAnterior());
			cursor = cursor.getProximo(); // aponta para o elemento posterior ao excluido
		}
		size--;
	}

	public void excluirItem(T elemento) throws Exception {
		buscar3(elemento); //posiciona o cursor
		excluirPosAtual();
	}

	public void inserirPosAtual(T elemento) {
		novo = new Caixa<T>(elemento); // assumindo memória infinita, etc
		size++;
		if (primeiro == null) {
			primeiro = cursor = novo;
			primeiro.setAnterior(primeiro); // se so existe o primeiro elemento, ele aponta para ele mesmo
			primeiro.setProximo(primeiro);

		} else {
			novo.setAnterior(cursor.getAnterior());
			novo.setProximo(cursor);
			cursor.getAnterior().setProximo(novo);
			cursor.setAnterior(novo);
			// cursor permanece igual, ou seja, aponta para o elemento apos o incluido
			System.out.println("Endereco cursor apos inserir posicao atual: " + cursor);
		}

	}

	public void avancarCursor() {
		System.out.printf("Primeiro: %s; Posicao atual cursor: %s; proxima posicao cursor: %s\n", primeiro, cursor, cursor.getProximo());
		cursor = cursor.getProximo();
	}


	//  public void inserirApos(Item<T> item, T valor);
	//  
	//  public void inserirAntes(Item<T> item, T valor);
	//  
	//  public void excluirItem(Item<T> item);
	//  
	//  
	//  public Item<T> buscarItem(Item<T> item);




}
